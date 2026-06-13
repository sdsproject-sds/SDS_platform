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
public abstract class AbstractNotification <T extends NotificationData> {
    protected String notificationId;
    protected Date notificationEntryTime;
    protected String notificationRef;
    protected NotificationChannel notificationChannel;
    protected String clientId;
    protected int count;
    protected int delay;
    protected String contentType;
    protected Metadata metadata;
    protected String signature;

    protected T data;
    protected NotificationStatus status;
    protected Date nextRetryTime;
    protected Integer trackCount;

}
