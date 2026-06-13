package com.sds.integration.commons.messaging.model.notification;


import lombok.*;

import java.util.List;

/**
 * @author Joseph.Kibe. Created On 13 Jun 2026 18:48
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HttpNotificationData extends NotificationData {

    private List<Authorization> authorizations;
    private Object url;
    private Object request;
}
