package com.neu.edu.android_backend.mapper;

import com.neu.edu.android_backend.po.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Insert("INSERT INTO course (id, name, date, teacherName) VALUES (#{id}, #{name}, #{date}, #{teacherName})")
    void addCourse(Course course);

    @Delete("DELETE FROM course WHERE id = #{id}")
    void deleteCourse(String id);

    @Update("UPDATE course SET name = #{name}, date = #{date}, teacherName = #{teacherName} WHERE id = #{id}")
    void updateCourse(Course course);

    @Select("SELECT * FROM course WHERE id = #{id}")
    Course getCourseById(String id);

    @Select("SELECT * FROM course")
    List<Course> getAllCourses();

    @Select("SELECT * FROM course WHERE name = #{name}")
    Course getCourseByName(String name);
}
