package com.neu.edu.android_backend.mapper;

import com.neu.edu.android_backend.po.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Insert("INSERT INTO teacher (id, password, name, unApprovedCourse) VALUES (#{id}, #{password}, #{name}, #{unApprovedCourse})")
    void addTeacher(Teacher teacher);

    @Delete("DELETE FROM teacher WHERE id = #{id}")
    void deleteTeacher(String id);

    @Update("UPDATE teacher SET password = #{password}, name = #{name}, unApprovedCourse = #{unApprovedCourse} WHERE id = #{id}")
    void updateTeacher(Teacher teacher);

    @Select("SELECT * FROM teacher WHERE id = #{id}")
    Teacher getTeacherById(String id);

    @Select("SELECT * FROM teacher")
    List<Teacher> getAllTeachers();

    @Select("SELECT * FROM teacher WHERE name = #{name}")
    Teacher getTeacherByName(String name);
}
