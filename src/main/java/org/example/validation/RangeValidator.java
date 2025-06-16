package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.dto.SensorRange;
import org.springframework.stereotype.Component;

@Component
public class RangeValidator implements ConstraintValidator<RangeValidation, SensorRange> {
    @Override
    public boolean isValid(SensorRange sensorRange, ConstraintValidatorContext constraintValidatorContext) {
        if (sensorRange.getFrom() != null && sensorRange.getTo() != null) {
            return sensorRange.getFrom() < sensorRange.getTo();
        }
        return true;
    }
}
