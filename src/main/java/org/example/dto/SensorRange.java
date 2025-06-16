package org.example.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SensorRange {
    @Positive(message = "Range from must be a positive number")
    @NotNull(message = "Range from is required")
    private Integer from;

    @Positive(message = "Range to must be a positive number")
    @NotNull(message = "Range to is required")
    private Integer to;

    @AssertTrue(message = "Range from must be less than range to")
    private boolean isValidRange() {
        return from < to;

    }
}
