package com.neu.edu.android_backend.mapper;

import com.neu.edu.android_backend.po.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Insert("INSERT INTO student (id, name, password) VALUES (#{id}, #{name}, #{password})")
    void addStudent(Student student);

    @Delete("DELETE FROM student WHERE id = #{id}")
    void deleteStudent(String id);

    @Update("UPDATE student SET name = #{name}, password = #{password} WHERE id = #{id}")
    void updateStudent(Student student);

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getStudentById(String id);

    @Select("SELECT * FROM student")
    List<Student> getAllStudents();

    @Select("SELECT * FROM student WHERE name = #{name}")
    Student getStudentByName(String name);
}
