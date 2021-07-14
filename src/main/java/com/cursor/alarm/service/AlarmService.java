package com.cursor.alarm.service;

import com.cursor.alarm.model.Alarm;
import com.cursor.alarm.model.AlarmDto;

import java.util.List;
import java.util.NoSuchElementException;

public interface AlarmService {

    Alarm create(AlarmDto alarmDto);

    List<Alarm> findAll();

    Alarm edit(String id, AlarmDto alarmDto) throws NoSuchElementException;

}
