package com.Pagination.Pagination.controller;

import com.Pagination.Pagination.entity.Course;
import com.Pagination.Pagination.exception.AdminException;
import com.Pagination.Pagination.service.ConverterService;
import com.Pagination.Pagination.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courseInfo")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private ConverterService converterService;

    @GetMapping(value = "/allcourse", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Course> getCourseInfo(@RequestParam("page") Integer page, @RequestParam("size") Integer size,@RequestParam  String Role) throws AdminException {
        PageRequest pagerequest = PageRequest.of(page,size);
        Page<Course> coursePage = courseService.getAllCourseInfo(pagerequest, Role);
        List<Course> courseResultList = coursePage.getContent();
        courseResultList = courseResultList.stream().map(courseObj -> {
            converterService.convertToDto(courseObj);
            return courseObj;
        }).collect(Collectors.toList());

        Page<Course> courseDtoPage = new PageImpl<>(courseResultList, pagerequest, coursePage.getTotalElements());
        return courseDtoPage;
    }


}
