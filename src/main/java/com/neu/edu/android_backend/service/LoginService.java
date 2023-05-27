package com.neu.edu.android_backend.service;

import com.neu.edu.android_backend.mapper.AdministratorMapper;
import com.neu.edu.android_backend.mapper.StudentMapper;
import com.neu.edu.android_backend.mapper.TeacherMapper;
import com.neu.edu.android_backend.po.Administrator;
import com.neu.edu.android_backend.po.Student;
import com.neu.edu.android_backend.po.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    private final AdministratorMapper administratorMapper;

    @Autowired
    public LoginService(StudentMapper studentMapper, TeacherMapper teacherMapper, AdministratorMapper administratorMapper) {
        this.studentMapper = studentMapper;
        this.teacherMapper = teacherMapper;
        this.administratorMapper = administratorMapper;
    }

    public String login(String username, String password) {
        // Check if it is a student
        Student student = studentMapper.getStudentByName(username);
        if (student != null && student.getPassword().equals(password)) {
            return "student";
        }

        // Check if it is a teacher
        Teacher teacher = teacherMapper.getTeacherByName(username);
        if (teacher != null && teacher.getPassword().equals(password)) {
            return "teacher";
        }

        // Check if it is an administrator
        Administrator administrator = administratorMapper.getAdministratorByName(username);
        if (administrator != null && administrator.getPassword().equals(password)) {
            return "administrator";
        }

        // If no match found, return null
        return null;
    }
}
