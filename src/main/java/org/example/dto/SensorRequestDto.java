package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.validation.RangeValidation;

@Data
public class SensorRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
    private String name;

    @NotBlank(message = "Model is required")
    @Size(max = 15, message = "Model must not exceed 15 characters")
    private String model;

    @RangeValidation
    private SensorRange range;

    @NotNull(message = "Type is required")
    private Long typeId;

    private Long unitId;

    @Size(max = 40, message = "Location must not exceed 40 characters")
    private String location;

    @Size(max = 200, message = "Description must not exceed 200 characters")
    private String description;
}
