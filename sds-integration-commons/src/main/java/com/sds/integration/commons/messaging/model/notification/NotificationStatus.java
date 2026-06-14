package com.sds.integration.commons.messaging.model.notification;


/**
 * @author Joseph.Kibe. Created On 13 Jun 2026 18:28
 */

public enum NotificationStatus {

    /**
     * Indicates that the notification has been successfully delivered
     * to the intended recipient(s). This status confirms the completion
     * of the notification delivery process without any errors or failures.
     */
    DELIVERED,
    /**
     * Represents a state where the notification delivery process was unsuccessful.
     * This status indicates that the intended recipient(s) did not receive the
     * notification due to errors or failures in the delivery mechanism.
     */
    FAILED,
    /**
     * Indicates that the notification is currently awaiting processing or delivery.
     * This status is used when the notification has been created but has not yet been
     * processed or sent to the recipient(s). It represents an intermediate state
     * in the notification lifecycle.
     */
    PENDING,
    /**
     * Indicates that the notification delivery process has encountered a failure,
     * but the system is actively attempting to resend or reprocess the notification.
     * This status represents a state where the notification delivery is in progress,
     * and multiple retry attempts may be made until a final success or failure status
     * is determined.
     */
    RETRYING,
    /**
     * Indicates that the notification delivery process was rejected or negatively acknowledged
     * by the recipient system. This status is used when the recipient explicitly declines
     * to accept the notification, often due to validation errors or incompatible formats.
     */
    NACK,
    /**
     * Indicates that the notification has been newly created and is at its initial state.
     */
    NEW
}
