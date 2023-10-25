package com.example.courses.coursesService.repositories;

import com.example.courses.coursesService.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository <Course, Long>{
    List<Course> findByRating(Integer rating);

}
