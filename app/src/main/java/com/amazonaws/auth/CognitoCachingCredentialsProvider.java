package com.amazonaws.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.NotAuthorizedException;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.util.VersionInfoUtils;
import com.appsflyer.share.Constants;
import java.util.Date;
import java.util.Map;

public class CognitoCachingCredentialsProvider extends CognitoCredentialsProvider {
    private static final String AK_KEY = "accessKey";
    private static final String EXP_KEY = "expirationDate";
    private static final String ID_KEY = "identityId";
    private static final String SK_KEY = "secretKey";
    private static final String ST_KEY = "sessionToken";
    private static final String TAG = "CognitoCachingCredentialsProvider";
    private static final String USER_AGENT = (CognitoCachingCredentialsProvider.class.getName() + Constants.URL_PATH_DELIMITER + VersionInfoUtils.getVersion());
    private final String DEFAULT_SHAREDPREFERENCES_NAME = "com.amazonaws.android.auth";
    private String identityId;
    private final IdentityChangedListener listener = new IdentityChangedListener() {
        public void identityChanged(String oldIdentityId, String newIdentityId) {
            Log.d(CognitoCachingCredentialsProvider.TAG, "Identity id is changed");
            CognitoCachingCredentialsProvider.this.saveIdentityId(newIdentityId);
            CognitoCachingCredentialsProvider.this.clearCredentials();
        }
    };
    boolean needIdentityRefresh = false;
    private final SharedPreferences prefs;

    public CognitoCachingCredentialsProvider(Context context, String accountId, String identityPoolId, String unauthRoleArn, String authRoleArn, Regions region) {
        super(accountId, identityPoolId, unauthRoleArn, authRoleArn, region);
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, String accountId, String identityPoolId, String unauthRoleArn, String authRoleArn, Regions region, ClientConfiguration clientConfiguration) {
        super(accountId, identityPoolId, unauthRoleArn, authRoleArn, region, clientConfiguration);
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, String identityPoolId, Regions region) {
        super(identityPoolId, region);
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, String identityPoolId, Regions region, ClientConfiguration clientConfiguration) {
        super(identityPoolId, region, clientConfiguration);
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, String accountId, String identityPoolId, String unauthArn, String authArn, AmazonCognitoIdentityClient cibClient, AWSSecurityTokenService stsClient) {
        super(accountId, identityPoolId, unauthArn, authArn, cibClient, stsClient);
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider provider, String unauthArn, String authArn) {
        super(provider, unauthArn, authArn);
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider provider, String unauthArn, String authArn, AWSSecurityTokenService stsClient) {
        super(provider, unauthArn, authArn, stsClient);
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider provider, Regions region) {
        super(provider, region);
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider provider, Regions region, ClientConfiguration clientConfiguration) {
        super(provider, region, clientConfiguration);
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.prefs = context.getSharedPreferences("com.amazonaws.android.auth", 0);
        initialize();
    }

    private void initialize() {
        checkUpgrade();
        this.identityId = getCachedIdentityId();
        loadCachedCredentials();
        registerIdentityChangedListener(this.listener);
    }

    public String getIdentityId() {
        if (this.needIdentityRefresh) {
            this.needIdentityRefresh = false;
            refresh();
            this.identityId = super.getIdentityId();
            saveIdentityId(this.identityId);
        }
        this.identityId = getCachedIdentityId();
        if (this.identityId == null) {
            this.identityId = super.getIdentityId();
            saveIdentityId(this.identityId);
        }
        return this.identityId;
    }

    public synchronized AWSSessionCredentials getCredentials() {
        AWSSessionCredentials aWSSessionCredentials;
        if (this.sessionCredentials == null) {
            loadCachedCredentials();
        }
        if (!needsNewSession()) {
            aWSSessionCredentials = this.sessionCredentials;
        } else {
            try {
                super.getCredentials();
            } catch (NotAuthorizedException e) {
                Log.e(TAG, "Failure to get credentials", e);
                if (getLogins() != null) {
                    super.setIdentityId((String) null);
                    super.getCredentials();
                } else {
                    throw e;
                }
            }
            saveCredentials(this.sessionCredentials, getSessionCredentitalsExpiration().getTime());
            aWSSessionCredentials = this.sessionCredentials;
        }
        return aWSSessionCredentials;
    }

    public void refresh() {
        super.refresh();
        saveCredentials(this.sessionCredentials, getSessionCredentitalsExpiration().getTime());
    }

    public void setLogins(Map<String, String> logins) {
        super.setLogins(logins);
        this.needIdentityRefresh = true;
        clearCredentials();
    }

    public void clear() {
        super.clear();
        this.prefs.edit().clear().apply();
    }

    public void clearCredentials() {
        super.clearCredentials();
        Log.d(TAG, "Clearing credentials from SharedPreferences");
        this.prefs.edit().remove(namespace(AK_KEY)).remove(namespace(SK_KEY)).remove(namespace(ST_KEY)).remove(namespace(EXP_KEY)).apply();
    }

    public String getCachedIdentityId() {
        String cachedIdentityId = this.prefs.getString(namespace(ID_KEY), (String) null);
        if (cachedIdentityId != null && this.identityId == null) {
            super.setIdentityId(cachedIdentityId);
        }
        return cachedIdentityId;
    }

    /* access modifiers changed from: package-private */
    public void loadCachedCredentials() {
        Log.d(TAG, "Loading credentials from SharedPreferences");
        this.sessionCredentialsExpiration = new Date(this.prefs.getLong(namespace(EXP_KEY), 0));
        boolean hasAK = this.prefs.contains(namespace(AK_KEY));
        boolean hasSK = this.prefs.contains(namespace(SK_KEY));
        boolean hasST = this.prefs.contains(namespace(ST_KEY));
        if (!hasAK || !hasSK || !hasST) {
            Log.d(TAG, "No valid credentials found in SharedPreferences");
            this.sessionCredentialsExpiration = null;
            return;
        }
        this.sessionCredentials = new BasicSessionCredentials(this.prefs.getString(namespace(AK_KEY), (String) null), this.prefs.getString(namespace(SK_KEY), (String) null), this.prefs.getString(namespace(ST_KEY), (String) null));
    }

    private void saveCredentials(AWSSessionCredentials sessionCredentials, long time) {
        Log.d(TAG, "Saving credentials to SharedPreferences");
        if (sessionCredentials != null) {
            this.prefs.edit().putString(namespace(AK_KEY), sessionCredentials.getAWSAccessKeyId()).putString(namespace(SK_KEY), sessionCredentials.getAWSSecretKey()).putString(namespace(ST_KEY), sessionCredentials.getSessionToken()).putLong(namespace(EXP_KEY), time).apply();
        }
    }

    /* access modifiers changed from: private */
    public void saveIdentityId(String identityId2) {
        Log.d(TAG, "Saving identity id to SharedPreferences");
        this.identityId = identityId2;
        this.prefs.edit().putString(namespace(ID_KEY), identityId2).apply();
    }

    /* access modifiers changed from: protected */
    public String getUserAgent() {
        return USER_AGENT;
    }

    private void checkUpgrade() {
        if (this.prefs.contains(ID_KEY)) {
            Log.i(TAG, "Identity id without namespace is detected. It will be saved under new namespace.");
            this.prefs.edit().clear().putString(namespace(ID_KEY), this.prefs.getString(ID_KEY, (String) null)).apply();
        }
    }

    private String namespace(String key) {
        return getIdentityPoolId() + "." + key;
    }
}
