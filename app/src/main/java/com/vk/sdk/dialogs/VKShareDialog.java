package com.vk.sdk.dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.dialogs.VKShareDialogBuilder;
import com.vk.sdk.dialogs.VKShareDialogDelegate;

public class VKShareDialog extends DialogFragment implements VKShareDialogDelegate.DialogFragmentI {
    private VKShareDialogDelegate mDelegate = new VKShareDialogDelegate(this);

    public interface VKShareDialogListener extends VKShareDialogBuilder.VKShareDialogListener {
    }

    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Deprecated
    public VKShareDialog() {
    }

    @SuppressLint({"ValidFragment"})
    VKShareDialog(VKShareDialogBuilder builder) {
        this.mDelegate.setAttachmentImages(builder.attachmentImages);
        this.mDelegate.setText(builder.attachmentText);
        if (!(builder.linkTitle == null || builder.linkUrl == null)) {
            this.mDelegate.setAttachmentLink(builder.linkTitle, builder.linkUrl);
        }
        this.mDelegate.setUploadedPhotos(builder.existingPhotos);
        this.mDelegate.setShareDialogListener(builder.listener);
    }

    public VKShareDialog setAttachmentImages(VKUploadImage[] images) {
        this.mDelegate.setAttachmentImages(images);
        return this;
    }

    public VKShareDialog setText(CharSequence textToPost) {
        this.mDelegate.setText(textToPost);
        return this;
    }

    public VKShareDialog setAttachmentLink(String linkTitle, String linkUrl) {
        this.mDelegate.setAttachmentLink(linkTitle, linkUrl);
        return this;
    }

    public VKShareDialog setUploadedPhotos(VKPhotoArray photos) {
        this.mDelegate.setUploadedPhotos(photos);
        return this;
    }

    public VKShareDialog setShareDialogListener(VKShareDialogListener listener) {
        this.mDelegate.setShareDialogListener(listener);
        return this;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return this.mDelegate.onCreateDialog(savedInstanceState);
    }

    @SuppressLint({"NewApi"})
    public void onStart() {
        super.onStart();
        this.mDelegate.onStart();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.mDelegate.onSaveInstanceState(outState);
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        this.mDelegate.onCancel(dialog);
    }
}
