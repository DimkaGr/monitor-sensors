package org.example.repository;

import org.example.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Sensor} bean.
 */
public interface SensorRepository extends JpaRepository<Sensor, Long>, CustomSensorRepository{
}
