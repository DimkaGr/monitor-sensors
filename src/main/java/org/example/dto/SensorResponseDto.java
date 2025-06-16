package org.example.dto;

public record SensorResponseDto(long id, String name, String model, SensorRange range, String type,
                                String unit, String location, String description) {
}
