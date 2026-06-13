package com.sds.integration.commons.messaging.model.notification;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Joseph.Kibe. Created On 13 Jun 2026 18:50
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authorization {
    private String value;
    private String key;
}
