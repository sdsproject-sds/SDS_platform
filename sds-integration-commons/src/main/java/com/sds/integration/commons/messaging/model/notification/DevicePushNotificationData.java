package com.sds.integration.commons.messaging.model.notification;


import lombok.*;

import java.util.List;

/**
 * @author Joseph.Kibe. Created On 13 Jun 2026 19:01
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DevicePushNotificationData extends NotificationData{

    /**
     * Represents a list of device tokens associated with push notifications.
     * Each entry in the list corresponds to a unique device token, which identifies
     * a specific device capable of receiving push notifications.
     * <p>
     * This field is used in the context of device-based push notifications to specify
     * the target devices that should receive the notification. Device tokens are
     * typically unique identifiers provided by the notification service or platform
     * (e.g., Firebase for Android, APNs for iOS).
     */
    private List<String> deviceToken;

    /**
     * Represents a list of device IDs associated with the notification system.
     * Each entry in the list corresponds to a unique identifier for a device,
     * which may be used to specify the exact devices involved in the context
     * of notifications or system processes.
     *<p>
     * This field may be used in scenarios where actions or notifications are
     * targeted to specific devices, tracking device-specific attributes, or storing
     * device-related metadata.
     */
    private List<String> deviceId;
    /**
     * Represents a list of user identifiers associated with the device push notification.
     * This list is used to specify the target users who will receive the notification.
     * Each entry in the list corresponds to a unique user identifier.
     */
    private List<String> userId;
    private DeviceType deviceType;
    private String appVersion;


    /**
     * Message titile
     */
    private String title;
    /**
     * The notification message
     */
    private String message;
    /**
     * The notification  sub title
     */
    private String subtitle;


    /**
     * Enum representing different types of devices that can receive notifications.
     *<p>
     * The {@code DeviceType} enum is used to specify the platform or operating system
     * to which a notification should be sent. Each enum constant corresponds to a
     * specific device type or platform.
     * <p>
     * - ANDROID: Represents Android devices.
     * - IOS: Represents Apple iOS devices.
     * - WEB: Represents web-based or browser environments.
     * - WINDOWS: Represents devices running the Windows operating system.
     * - MACOS: Represents devices running the macOS operating system.
     */
    public enum DeviceType {
        ANDROID,
        IOS,
        WEB,
        WINDOWS,
        MACOS
    }

    /**
     * Represents the priority levels for notifications.
     * <p>
     * The {@code NotificationPriority} enum is used to define the urgency or importance
     * of a notification. These levels can help categorize notifications and determine
     * how they should be processed or displayed to the user.
     * <p>
     * - {@code LOW}: Indicates that the notification is of low importance or urgency.
     * - {@code NORMAL}: Represents a standard priority level for a notification.
     * - {@code HIGH}: Denotes that the notification is important and requires immediate attention.
     * - {@code MAX}: Signifies the highest priority level, often used for critical or time-sensitive notifications.
     */
    public enum NotificationPriority {
        LOW,
        NORMAL,
        HIGH,
        MAX
    }
}

