package com.Pagination.Pagination.dto;

import com.Pagination.Pagination.Enum.TypesOfRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CourseDto {
    private Long id;
    private String courseName;
    private TypesOfRole typesOfRole;
}
