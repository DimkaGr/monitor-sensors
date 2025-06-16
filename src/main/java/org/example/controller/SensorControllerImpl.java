package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.SensorRequestDto;
import org.example.dto.SensorResponseDto;
import org.example.dto.container.SensorParameterContainer;
import org.example.mapper.SensorMapper;
import org.example.model.Sensor;
import org.example.service.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SensorControllerImpl implements SensorController {
    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    @Override
    public ResponseEntity<List<SensorResponseDto>> findSensors(SensorParameterContainer container) {
        List<SensorResponseDto> responseDtoList = sensorService.findAll(container).stream().map(sensorMapper::toDto).toList();
        return ResponseEntity.ok(responseDtoList);
    }

    @Override
    public ResponseEntity<SensorResponseDto> findSensor(long id) {
        SensorResponseDto responseDto = sensorMapper.toDto(sensorService.findById(id));
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<SensorResponseDto> createSensor(SensorRequestDto requestDto) {
        Sensor saved = sensorService.create(sensorMapper.fromDto(requestDto));
        SensorResponseDto responseDto = sensorMapper.toDto(saved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SensorResponseDto> updateSensor(long id, SensorRequestDto requestDto) {
        Sensor saved = sensorService.update(id, sensorMapper.fromDto(requestDto));
        SensorResponseDto responseDto = sensorMapper.toDto(saved);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<Void> deleteSensor(long id) {
        sensorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
