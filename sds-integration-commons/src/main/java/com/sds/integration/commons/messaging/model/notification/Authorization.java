package com.sds.integration.commons.messaging.model.notification;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an authorization detail used within the context of notification
 * delivery systems. This class encapsulates the key and value pair that
 * define the authentication or credential information required to authorize
 * specific requests or actions.
 *<p>
 * The {@code Authorization} class is commonly used in scenarios where requests
 * to services, APIs, or other external systems require authentication details.
 * These details may include API keys, tokens, or any other form of credentials.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authorization {
    /**
     * Represents the authorization value used in the context of notification delivery.
     * This value may signify an authentication token, API key, or any other credential
     * required to authorize actions or requests within the notification system.
     */
    private String value;
    /**
     * Represents a unique key identifier associated with the authorization context within
     * a notification system. This key is intended to reference specific configurations or
     * properties tied to the authorization mechanism, providing a means to dynamically
     * retrieve or manage authorization-related data.
     * <p>
     * For http notification this will be part of the header key
     */
    private String key;
}
