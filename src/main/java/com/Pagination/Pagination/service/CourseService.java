package com.Pagination.Pagination.service;

import com.Pagination.Pagination.dto.CourseDto;
import com.Pagination.Pagination.entity.Course;
import com.Pagination.Pagination.exception.AdminException;
import com.Pagination.Pagination.repository.CourseRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Page<Course> getAllCourseInfo(Pageable pageRequest, String Role) throws AdminException {


        if (Role.equals("SUPER_ADMIN")) {
//        Optional<Course> course = courseRepository.findById(id);
            List<Course> courseList = Arrays.asList(
                    new Course("Aws"),
                    new Course("Devops"),
                    new Course("Testing"),
                    new Course("Sap"),
                    new Course("FullStack"),
                    new Course("Java"),
                    new Course("Python"),
                    new Course("WebDevelopment"),
                    new Course("Database"),
                    new Course("Mysql"),
                    new Course(".Net"),
                    new Course("Ui/Ux"),
                    new Course("Design"),
                    new Course("Quality"),
                    new Course("Scrum"));
            courseRepository.saveAll(courseList);

        } else if (!Role.equals("SUPER_ADMIN")) {
            throw new AdminException(HttpStatus.BAD_REQUEST, "You are Not Super_Admin");
        }
        return courseRepository.findAll(pageRequest);
    }
}
