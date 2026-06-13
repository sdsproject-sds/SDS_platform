package com.sds.integration.commons.messaging.model.notification;


import lombok.*;

import java.util.List;

/**
 * @author Joseph.Kibe. Created On 13 Jun 2026 19:41
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SmsNotificationData extends NotificationData {
    private List<Authorization> authorizations;
    private List<String> recipients;
    private String message;
}
