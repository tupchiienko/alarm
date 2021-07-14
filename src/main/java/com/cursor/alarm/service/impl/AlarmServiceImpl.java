package com.cursor.alarm.service.impl;

import com.cursor.alarm.model.Alarm;
import com.cursor.alarm.model.AlarmDto;
import com.cursor.alarm.repository.AlarmRepository;
import com.cursor.alarm.service.AlarmService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AlarmServiceImpl implements AlarmService {

    private final AlarmRepository alarmRepository;
    private final ModelMapper modelMapper;

    @Override
    public Alarm create(AlarmDto alarmDto) {
        var alarm = modelMapper.map(alarmDto, Alarm.class);
        return alarmRepository.save(alarm);
    }

    @Override
    public List<Alarm> findAll() {
        return alarmRepository.findAll();
    }

    @Override
    public Alarm edit(String id, AlarmDto alarmDto) throws NoSuchElementException {
        var alarm = alarmRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Element with id:" + id + " does not exist")
                );
        alarm = modelMapper.map(alarmDto, Alarm.class);
        alarm.setId(id);
        return alarmRepository.save(alarm);
    }
}
