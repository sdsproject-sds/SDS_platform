package com.sds.integration.commons.messaging.model.notification;


import lombok.*;

import java.util.List;

/**
 * @author Joseph.Kibe. Created On 13 Jun 2026 18:49
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailNotificationData extends NotificationData {
    private List<Authorization> authorizations;
    private String subject;
    private List<String> recipients;
    private String body;
}
