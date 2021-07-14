package com.cursor.alarm.repository;

import com.cursor.alarm.model.Alarm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlarmRepository extends MongoRepository<Alarm, String> {
}
