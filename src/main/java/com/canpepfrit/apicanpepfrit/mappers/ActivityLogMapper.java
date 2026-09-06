package com.canpepfrit.apicanpepfrit.mappers;

import com.canpepfrit.apicanpepfrit.DTOS.ActivityLogDTO;
import com.canpepfrit.apicanpepfrit.DTOS.ActivityLogRequestDTO;
import com.canpepfrit.apicanpepfrit.models.ActivityLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ActivityLogMapper {
    ActivityLogDTO toDTO(ActivityLog logRegistry);

    List<ActivityLogDTO> toDTOList(List<ActivityLog> logs);

    @Mapping(target = "accommodation", ignore = true)
    @Mapping(target = "employee", ignore = true)
    ActivityLog toEntity(ActivityLogRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accommodation", ignore = true)
    @Mapping(target = "employee", ignore = true)
    void updateEntityFromDTO(ActivityLogRequestDTO dto, @MappingTarget ActivityLog entity);

    List<ActivityLog> toEntityList(List<ActivityLogRequestDTO> logsDTO);

    ActivityLog toEntityFromDTO(ActivityLogDTO dto);

    List<ActivityLog> toEntityListFromDTO(List<ActivityLogDTO> dtos);


}
