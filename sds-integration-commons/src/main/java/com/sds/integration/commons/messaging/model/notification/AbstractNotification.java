package com.sds.integration.commons.messaging.model.notification;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author Joseph.Kibe. Created On 13 Jun 2026 18:16
 */

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public abstract class AbstractNotification<T extends NotificationData> {

    /**
     * Represents a reference associated with the notification.
     * This field can be used to store additional information
     * to uniquely identify or link the notification to an external entity or system.
     */
    protected String notificationId;
    protected Date notificationEntryTime;

    /**
     * Unique notification identifier
     */
    protected String notificationRef;
    /**
     * Specifies the channel through which the notification will be delivered.
     * This could include delivery mechanisms such as HTTP, SMS, EMAIL, or DEVICE_PUSH.
     */
    protected NotificationChannel notificationChannel;
    /**
     * Represents the unique identifier for a client (Service) associated with the notification.
     * This field can be used to distinguish notifications specific to a particular client
     * in a multi-tenant or client-specific setup.
     */
    protected String clientId;
    /**
     * Number of notifications to be sent
     */
    protected int count;

    /**
     * Time delay between notification push incas more than one notification are to be sent
     * The value should be in milliseconds
     */
    protected int delay;

    /**
     * Denotes the type of content associated with the notification.
     * This field can be used to specify the format of the notification content,
     * such as "application/json", "text/plain", "text/html", etc.
     */
    protected String contentType;

    /**
     * Represents metadata associated with the notification.
     * This field contains additional contextual information about
     * the notification's original.
     */
    protected Metadata metadata;

    /**
     * Represents the unique cryptographic signature associated with the notification.
     * This field can be used to validate the authenticity and integrity of a notification
     * payload, ensuring that the notification has not been tampered with during transmission.
     */
    protected String signature;

    /**
     * Represents the notification-specific data associated with the {@code AbstractNotification}.
     * This data is typically an instance of a subclass of {@code NotificationData}, such as:
     * {@code HttpNotificationData}, {@code SmsNotificationData}, {@code EmailNotificationData},
     * or {@code DevicePushNotificationData}.
     * <p>
     * The notification data encapsulates the details required for the delivery
     * of the notification, depending on the channel specified
     * (e.g., HTTP, SMS, EMAIL, DEVICE_PUSH).
     * <p>
     * The actual type of {@code data} is determined by the generic type {@code T},
     * which must extend {@code NotificationData}.
     */
    protected T data;

    /**
     *
     */
    protected NotificationStatus status;
    protected Date nextRetryTime;
    protected Integer trackCount;

}
