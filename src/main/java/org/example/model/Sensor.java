package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String model;
    private int rangeFrom;
    private int rangeTo;
    private String location;
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private SensorType type;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private SensorUnit unit;
}
