package com.sist.jobgem.mapper;

import com.sist.jobgem.dto.BoardDto;
import com.sist.jobgem.dto.JobseekerDto;
import com.sist.jobgem.entity.Board;
import com.sist.jobgem.entity.Jobseeker;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JobseekerMapper {
    JobseekerMapper INSTANCE = Mappers.getMapper(JobseekerMapper.class);

    JobseekerDto toDto(Jobseeker jobseeker);

    Jobseeker toEntity(JobseekerDto jobseekerDto);

    List<JobseekerDto> toDtoList(List<Jobseeker> list);
}
