package org.example.service;

import org.example.dto.container.SensorParameterContainer;
import org.example.model.Sensor;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service for {@link Sensor} bean.
 */
public interface SensorService {
    /**
     * Finds {@link Sensor} bean by the provided id.
     * Throws {@link NoSuchElementException} if no bean was found.
     *
     * @param id - id of the {@link Sensor} bean
     * @return @link Sensor}
     */
    Sensor findById(long id);

    /**
     * Finds {@link Sensor} beans, based on the {@link SensorParameterContainer} parameters, if provided.
     *
     * @param container - {@link SensorParameterContainer}
     * @return list of {@link Sensor}
     */
    List<Sensor> findAll(SensorParameterContainer container);

    /**
     * Creates new {@link Sensor} bean.
     *
     * @param sensor - new {@link Sensor} bean to save
     * @return saved {@link Sensor} bean
     */
    Sensor create(Sensor sensor);

    /**
     * Creates existing {@link Sensor} bean.
     *
     * @param id - id of the existing {@link Sensor} bean
     * @param sensor - {@link Sensor} bean to save
     * @return updated {@link Sensor} bean
     */
    Sensor update(long id, Sensor sensor);

    /**
     * Deletes {@link Sensor} bean by the provided id
     *
     * @param id - id of the {@link Sensor} bean to delete
     */
    void delete(long id);
}
