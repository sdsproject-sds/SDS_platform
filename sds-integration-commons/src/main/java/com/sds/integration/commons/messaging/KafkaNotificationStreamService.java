package com.sds.integration.commons.messaging;


import com.sds.integration.commons.messaging.exception.NotificationMessageStreamException;
import com.sds.integration.commons.messaging.model.notification.NotificationTopic;
import tools.jackson.databind.ObjectMapper;
import com.sds.integration.commons.messaging.model.notification.AbstractNotification;
import com.sds.integration.commons.messaging.model.notification.NotificationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.util.MimeType;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.HexFormat;


/**
 * @author Joseph.Kibe. Created On 13 Jun 2026 17:48
 */

@Slf4j
public class KafkaNotificationStreamService <T extends NotificationData> {

    /**
     * Publishes a Notification event to a Kafka topic using the provided StreamBridge.
     *
     * @param topic       The Kafka topic to which the notification event should be published.
     * @param message     The notification message containing the notification data and metadata to be published.
     * @param streamBridge The StreamBridge instance used to send the message to the Kafka topic.
     * @param mimeType    The MIME type of the message being sent to the Kafka topic.
     * @param serviceKey  The service key used to generate the MAC-SHA256 signature for message validation.
     * @throws NotificationMessageStreamException If an error occurs during the publishing of the message to the Kafka topic.
     */
    public void publishTransactionReportEvent(NotificationTopic topic, AbstractNotification<T> message, StreamBridge streamBridge, MimeType mimeType, String serviceKey) {
        try {

            log.info("Publishing Notification message to Kafka topic: {}  notificationId {}", topic, message.getNotificationId());
            message.setSignature(getMacSha256Signature(message, serviceKey));

            topic = topic == null ? NotificationTopic.PUSH_NOTIFICATIONS : topic;

            streamBridge.send(topic.name(), message, mimeType);
            log.info("Notification message published to Kafka topic: {}  notificationId {}", topic, message.getNotificationId());
        } catch (Exception e) {
            throw new NotificationMessageStreamException("Failed to publish message to Kafka topic: " + topic);
        }
    }

    public String getMacSha256Signature(AbstractNotification<T> message, String key) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        var messageString = objectMapper.writeValueAsString(message);

        byte[] bytesKey = key.getBytes();
        byte[] bytesMessage = messageString.getBytes();

        String algorithm = "HmacSHA512";
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(bytesKey, algorithm));
        mac.update(bytesMessage);
        byte[] result = mac.doFinal();
        HexFormat hexFormat = HexFormat.of();
        return hexFormat.formatHex(result);

    }

}
