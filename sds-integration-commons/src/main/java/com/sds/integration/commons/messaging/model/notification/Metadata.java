package com.sds.integration.commons.messaging.model.notification;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Metadata {
    private String origin;
    private LocalDate timestamp;
    private Map<String, String>  additionalProperties;
}