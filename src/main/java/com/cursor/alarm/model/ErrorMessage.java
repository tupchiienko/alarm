package com.cursor.alarm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

@Getter
@Setter
@Accessors(chain = true)
public class ErrorMessage {

    private Integer statusCode;
    private String message;
    private Instant timestamp;

}
