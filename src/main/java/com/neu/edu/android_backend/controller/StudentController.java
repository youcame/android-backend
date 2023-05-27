package com.neu.edu.android_backend.controller;

import com.neu.edu.android_backend.mapper.StudentMapper;
import com.neu.edu.android_backend.po.Student;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@RestController
public class StudentController {
    @Resource
    StudentMapper studentMapper;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> students = studentMapper.getAllStudents();
            return ResponseEntity.status(HttpStatus.OK).body(students);
        } catch (Exception e) {
            log.error("Failed to get students", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        try {
            Student student = studentMapper.getStudentById(id);
            if (student != null) {
                return ResponseEntity.status(HttpStatus.OK).body(student);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            log.error("Failed to get student by ID: " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/students/name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
        try {
            Student student = studentMapper.getStudentByName(name);
            if (student != null) {
                return ResponseEntity.status(HttpStatus.OK).body(student);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            log.error("Failed to get student by name: " + name, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        try {
            studentMapper.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully");
        } catch (Exception e) {
            log.error("Failed to add student", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add student");
        }
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable String id, @RequestBody Student student) {
        try {
            student.setId(id);
            studentMapper.updateStudent(student);
            return ResponseEntity.status(HttpStatus.OK).body("Student updated successfully");
        } catch (Exception e) {
            log.error("Failed to update student with ID: " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update student");
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        try {
            studentMapper.deleteStudent(id);
            return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");
        } catch (Exception e) {
            log.error("Failed to delete student with ID: " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete student");
        }
    }
}
