package com.neu.edu.android_backend.controller;

import com.neu.edu.android_backend.mapper.CourseMapper;
import com.neu.edu.android_backend.po.Course;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@RestController
public class CourseController {
    @Resource
    CourseMapper courseMapper;

    @PostMapping("/courses")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        try {
            courseMapper.addCourse(course);
            return ResponseEntity.status(HttpStatus.CREATED).body("Course added successfully");
        } catch (Exception e) {
            log.error("Failed to add course", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add course");
        }
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable String id) {
        try {
            courseMapper.deleteCourse(id);
            return ResponseEntity.status(HttpStatus.OK).body("Course deleted successfully");
        } catch (Exception e) {
            log.error("Failed to delete course", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete course");
        }
    }

    @PutMapping("/courses")
    public ResponseEntity<String> updateCourse(@RequestBody Course course) {
        try {
            courseMapper.updateCourse(course);
            return ResponseEntity.status(HttpStatus.OK).body("Course updated successfully");
        } catch (Exception e) {
            log.error("Failed to update course", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update course");
        }
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        try {
            Course course = courseMapper.getCourseById(id);
            if (course != null) {
                return ResponseEntity.status(HttpStatus.OK).body(course);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            log.error("Failed to get course by id", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        try {
            List<Course> courses = courseMapper.getAllCourses();
            return ResponseEntity.status(HttpStatus.OK).body(courses);
        } catch (Exception e) {
            log.error("Failed to get all courses", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/courses/name/{name}")
    public ResponseEntity<Course> getCourseByName(@PathVariable String name) {
        try {
            Course course = courseMapper.getCourseByName(name);
            if (course != null) {
                return ResponseEntity.status(HttpStatus.OK).body(course);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            log.error("Failed to get course by name", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
