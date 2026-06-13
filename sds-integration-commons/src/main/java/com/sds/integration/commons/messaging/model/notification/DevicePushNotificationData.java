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

    private List<String> deviceToken;
    private List<String> deviceId;
    private List<String> userId;
    private DeviceType deviceType;
    private String appVersion;


    private String title;
    private String message;
    private String subtitle;


    public enum DeviceType {
        ANDROID,
        IOS,
        WEB,
        WINDOWS,
        MACOS
    }

    public enum NotificationPriority {
        LOW,
        NORMAL,
        HIGH,
        MAX
    }
}

