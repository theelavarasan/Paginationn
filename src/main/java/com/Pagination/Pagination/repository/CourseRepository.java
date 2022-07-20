package com.Pagination.Pagination.repository;

import com.Pagination.Pagination.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, String> {

    Optional<Course> findById(Long id);
}
