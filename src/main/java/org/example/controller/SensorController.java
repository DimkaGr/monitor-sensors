package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.dto.SensorRequestDto;
import org.example.dto.SensorResponseDto;
import org.example.dto.container.SensorParameterContainer;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/sensors")
@Tag(name = "Sensors API", description = "Operations related to sensors management")
public interface SensorController {
    @GetMapping
    @Operation(summary = "Find list of sensors by provided optional parameters")
    ResponseEntity<List<SensorResponseDto>> findSensors(@ParameterObject SensorParameterContainer container);

    @GetMapping("/{id}")
    @Operation(summary = "Find sensor by provided ID")
    ResponseEntity<SensorResponseDto> findSensor(@PathVariable long id);

    @PostMapping
    @Operation(summary = "Create new sensor record")
    ResponseEntity<SensorResponseDto> createSensor(@Valid @RequestBody SensorRequestDto requestDto);

    @PutMapping("/{id}")
    @Operation(summary = "Update existing sensor record by ID")
    ResponseEntity<SensorResponseDto> updateSensor(@PathVariable long id, @Valid @RequestBody SensorRequestDto requestDto);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete existing sensor record by ID")
    ResponseEntity<Void> deleteSensor(@PathVariable long id);
}
