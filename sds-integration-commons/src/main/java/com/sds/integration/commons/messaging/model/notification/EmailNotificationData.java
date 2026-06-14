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
    /**
     * Represents the subject of an email notification.
     */
    private String subject;
    /**
     * Represents a list of recipient email addresses for an email notification.
     * Each entry in the list corresponds to an email address that will receive
     * the notification. This variable is used to specify the target recipients
     * of the email. It may include one or multiple entries, depending on the
     * intended audience for the notification.
     */
    private List<String> recipients;
    /**
     * Represents the main textual content of an email notification.
     * The value stored in this variable corresponds to the body of the email,
     * which is the primary message intended for the recipients.
     * <p>
     * The content in this variable may include plain text, rich text, or
     * HTML-formatted data, depending on the requirements of the email
     * notification being sent. It is used to communicate the essential
     * message or information within the email.
     */
    private String body;
}
