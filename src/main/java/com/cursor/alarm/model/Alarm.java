package com.cursor.alarm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Alarm {

    @Id
    private String id;
    private LocalTime time;
    private List<DayOfWeek> daysOfWeek;
    private boolean enabled;

}
