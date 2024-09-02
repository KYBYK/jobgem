package com.sist.jobgem.mapper;

import com.sist.jobgem.dto.ReviewDto;
import com.sist.jobgem.entity.Review;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    ReviewDto toDto(Review review);

    Review toEntity(ReviewDto reviewDto);
}