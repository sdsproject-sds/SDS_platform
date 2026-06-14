package com.sds.integration.commons.messaging.model.notification;


import lombok.*;

import java.net.URI;
import java.net.URL;
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

    /**
     * Represents a collection of authorization details used to authenticate or validate
     * actions performed within the context of HTTP-based notification delivery systems.
     * This list is typically associated with HTTP requests, where each {@link Authorization}
     * object defines a key-value pair representing credential information required for
     * authorization.
     *<p>
     * Authorizations may include API keys, tokens, or custom headers, which are appended
     * to HTTP request headers during the communication process. These details are integral
     * to ensuring secure and authorized communication between systems.
     */
    private List<Authorization> authorizations;
    /**
     * Represents the endpoint URL associated with the HTTP-based notification delivery system.
     * This URL acts as the target destination to which the notification payload will be sent.
     * The value may point to a web server or API endpoint designed to handle incoming
     * HTTP requests for processing notification data.
     */
    private URI url;
    /**
     * Represents an HTTP request object associated with the notification data.
     * This field is used to encapsulate the payload or details of the request
     * being sent or managed within the context of HTTP-based notification delivery.
     * It can store any type of data structure or metadata relevant to the HTTP request,
     * including but not limited to request parameters, payloads, headers, or configurations.
     */
    private Object request;
}
