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
    /**
     * Represents a list of recipient identifiers intended for an SMS notification.
     * Each entry in the list corresponds to a recipient's contact detail, such as
     * a phone number, to which the notification will be sent.
     *<p>
     * This variable is used to define the target audience for the SMS notification
     * and may contain one or multiple entries depending on the intended recipients.
     */
    private List<String> recipients;
    /**
     * Represents the message content of an SMS notification.
     * This field stores the textual content that will be delivered
     * as part of the SMS to the specified recipients.
     *<p>
     * The value of this variable can include plain text or structured information
     * formatted appropriately for easy readability and clarity for the recipients.
     */
    private String message;
}
