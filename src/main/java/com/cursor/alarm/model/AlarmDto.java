package com.cursor.alarm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlarmDto {

    private LocalTime time;
    private List<DayOfWeek> daysOfWeek;
    private boolean enabled;

}
