package org.example.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.dto.container.SensorParameterContainer;
import org.example.model.Sensor;
import org.example.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link SensorService}.
 */
@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;

    @Override
    public Sensor findById(long id) {
        return sensorRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Sensor> findAll(SensorParameterContainer container) {
        return sensorRepository.findAll(container);
    }

    @Override
    @Transactional
    public Sensor create(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    @Transactional
    public Sensor update(long id, Sensor sensor) {
        Sensor existing = findById(id);
        existing.setName(sensor.getName());
        existing.setModel(sensor.getModel());
        existing.setRangeFrom(sensor.getRangeFrom());
        existing.setRangeTo(sensor.getRangeTo());
        existing.setType(sensor.getType());
        existing.setUnit(sensor.getUnit());
        existing.setLocation(sensor.getLocation());
        existing.setDescription(sensor.getDescription());

        return sensorRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(long id) {
        sensorRepository.deleteById(id);
    }
}
