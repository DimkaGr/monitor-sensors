package org.example.repository;

import org.example.dto.container.SensorParameterContainer;
import org.example.model.Sensor;

import java.util.List;

/**
 * Repository, containing custom methods for {@link Sensor} bean.
 */
public interface CustomSensorRepository {
    /**
     * Finds {@link Sensor} beans, based on the {@link SensorParameterContainer} parameters, if provided.
     *
     * @param container - {@link SensorParameterContainer}
     * @return list of {@link Sensor}
     */
    List<Sensor> findAll(SensorParameterContainer container);
}
