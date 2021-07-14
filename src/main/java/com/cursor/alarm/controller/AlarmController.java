package com.cursor.alarm.controller;

import com.cursor.alarm.model.Alarm;
import com.cursor.alarm.model.AlarmDto;
import com.cursor.alarm.model.ErrorMessage;
import com.cursor.alarm.service.AlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/alarms")
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmService alarmService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Alarm> createAlarm(@RequestBody AlarmDto alarmDto) {
        var alarm = alarmService.create(alarmDto);
        return ResponseEntity.ok(alarm);
    }

    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Alarm> editAlarm(
            @PathVariable String id,
            @RequestBody AlarmDto alarmDto
    ) {
        var alarm = alarmService.edit(id, alarmDto);
        return ResponseEntity.ok(alarm);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Alarm>> getAllAlarms() {
        return ResponseEntity.ok(alarmService.findAll());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorMessage noSuchElementExceptionHandler(NoSuchElementException exception) {
        return new ErrorMessage()
                .setStatusCode(HttpStatus.NOT_FOUND.value())
                .setMessage(exception.getMessage())
                .setTimestamp(Instant.now());
    }

}
