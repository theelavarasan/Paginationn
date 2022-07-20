package com.Pagination.Pagination.service;

import com.Pagination.Pagination.dto.CourseDto;
import com.Pagination.Pagination.entity.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterService {
    @Autowired
    private ModelMapper modelMapper;


    public CourseDto convertToDto(Course courseObject) {
        return modelMapper.map(courseObject, CourseDto.class);
    }

    public Course convertToEntity(CourseDto courseDto) {
        return modelMapper.map(courseDto, Course.class);
    }
}
