package com.neu.edu.android_backend.controller;

import com.neu.edu.android_backend.mapper.TeacherMapper;
import com.neu.edu.android_backend.po.Teacher;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@RestController
public class TeacherController {
    @Resource
    TeacherMapper teacherMapper;

    @PostMapping("/teachers")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
        try {
            teacherMapper.addTeacher(teacher);
            return ResponseEntity.status(HttpStatus.CREATED).body("Teacher added successfully");
        } catch (Exception e) {
            log.error("Failed to add teacher", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add teacher");
        }
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable String id) {
        try {
            teacherMapper.deleteTeacher(id);
            return ResponseEntity.status(HttpStatus.OK).body("Teacher deleted successfully");
        } catch (Exception e) {
            log.error("Failed to delete teacher", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete teacher");
        }
    }

    @PutMapping("/teachers")
    public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher) {
        try {
            teacherMapper.updateTeacher(teacher);
            return ResponseEntity.status(HttpStatus.OK).body("Teacher updated successfully");
        } catch (Exception e) {
            log.error("Failed to update teacher", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update teacher");
        }
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable String id) {
        try {
            Teacher teacher = teacherMapper.getTeacherById(id);
            if (teacher != null) {
                return ResponseEntity.status(HttpStatus.OK).body(teacher);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            log.error("Failed to get teacher by id", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        try {
            List<Teacher> teachers = teacherMapper.getAllTeachers();
            return ResponseEntity.status(HttpStatus.OK).body(teachers);
        } catch (Exception e) {
            log.error("Failed to get all teachers", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/teachers/name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name) {
        try {
            Teacher teacher = teacherMapper.getTeacherByName(name);
            if (teacher != null) {
                return ResponseEntity.status(HttpStatus.OK).body(teacher);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            log.error("Failed to get teacher by name", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
