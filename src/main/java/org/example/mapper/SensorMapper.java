package org.example.mapper;

import org.example.dto.SensorRequestDto;
import org.example.dto.SensorResponseDto;
import org.example.model.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SensorMapper {
    @Mapping(target = "range.from", source = "rangeFrom")
    @Mapping(target = "range.to", source = "rangeTo")
    @Mapping(target = "type", source = "type.name")
    @Mapping(target = "unit", source = "unit.name")
    SensorResponseDto toDto(Sensor sensor);

    @Mapping(target = "rangeFrom", source = "range.from")
    @Mapping(target = "rangeTo", source = "range.to")
    @Mapping(target = "type.id", source = "typeId")
    @Mapping(target = "unit.id", source = "unitId")
    Sensor fromDto(SensorRequestDto sensor);
}
