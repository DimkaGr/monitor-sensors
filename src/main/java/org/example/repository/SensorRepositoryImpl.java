package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.example.dto.container.SensorParameterContainer;
import org.example.model.Sensor;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link CustomSensorRepository}.
 */
public class SensorRepositoryImpl implements CustomSensorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Sensor> findAll(SensorParameterContainer container) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sensor> cq = cb.createQuery(Sensor.class);
        Root<Sensor> product = cq.from(Sensor.class);

        List<Predicate> predicates = new ArrayList<>();

        if (container != null) {
            if (StringUtils.isNotEmpty(container.name())) {
                predicates.add(cb.like(cb.lower(product.get("name")),
                        "%" + container.name().toLowerCase() + "%"));
            }
            if (StringUtils.isNotEmpty(container.model())) {
                predicates.add(cb.like(cb.lower(product.get("model")),
                        "%" + container.model().toLowerCase() + "%"));
            }
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
