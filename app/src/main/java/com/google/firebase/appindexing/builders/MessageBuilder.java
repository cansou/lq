package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbo;
import com.tencent.component.net.download.multiplex.http.ContentType;
import java.util.Date;

public final class MessageBuilder extends IndexableBuilder<MessageBuilder> {
    MessageBuilder() {
        super("Message");
    }

    MessageBuilder(String str) {
        super(str);
    }

    public final MessageBuilder setDateRead(@NonNull Date date) {
        zzbo.zzu(date);
        return (MessageBuilder) put("dateRead", date.getTime());
    }

    public final MessageBuilder setDateReceived(@NonNull Date date) {
        zzbo.zzu(date);
        return (MessageBuilder) put("dateReceived", date.getTime());
    }

    public final MessageBuilder setDateSent(@NonNull Date date) {
        zzbo.zzu(date);
        return (MessageBuilder) put("dateSent", date.getTime());
    }

    public final MessageBuilder setIsPartOf(@NonNull ConversationBuilder... conversationBuilderArr) {
        return (MessageBuilder) put("isPartOf", (S[]) conversationBuilderArr);
    }

    public final MessageBuilder setMessageAttachment(@NonNull DigitalDocumentBuilder... digitalDocumentBuilderArr) {
        return (MessageBuilder) put("messageAttachment", (S[]) digitalDocumentBuilderArr);
    }

    public final MessageBuilder setRecipient(@NonNull PersonBuilder... personBuilderArr) {
        return (MessageBuilder) put("recipient", (S[]) personBuilderArr);
    }

    public final MessageBuilder setSender(@NonNull PersonBuilder personBuilder) {
        return (MessageBuilder) put("sender", (S[]) new PersonBuilder[]{personBuilder});
    }

    public final MessageBuilder setText(@NonNull String str) {
        return (MessageBuilder) put(ContentType.TYPE_TEXT, str);
    }
}
