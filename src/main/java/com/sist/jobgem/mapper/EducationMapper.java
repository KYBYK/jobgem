package com.sist.jobgem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.sist.jobgem.dto.EducationDto;
import com.sist.jobgem.entity.Education;

import java.util.List;
@Mapper
public interface EducationMapper {
    EducationMapper INSTANCE = Mappers.getMapper(EducationMapper.class);

    Education toEntity(EducationDto educationDto);

    EducationDto toDto(Education education);

    List<EducationDto> toDtoList(List<Education> education);
    
    List<Education> toEntityList(List<EducationDto> educationDtos);
}