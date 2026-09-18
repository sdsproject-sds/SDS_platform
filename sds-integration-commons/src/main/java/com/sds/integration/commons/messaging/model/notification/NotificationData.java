package com.sds.integration.commons.messaging.model.notification;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Joseph.Kibe. Created On 13 Jun 2026 18:52
 */
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "notificationChannel"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = HttpNotificationData.class, name = "HTTP"),
        @JsonSubTypes.Type(value = SmsNotificationData.class, name = "SMS"),
        @JsonSubTypes.Type(value = EmailNotificationData.class, name = "EMAIL"),
        @JsonSubTypes.Type(value = DevicePushNotificationData.class, name = "DEVICE_PUSH")
})
@Getter
@Setter
public abstract class NotificationData {
    protected NotificationChannel notificationChannel;
}
