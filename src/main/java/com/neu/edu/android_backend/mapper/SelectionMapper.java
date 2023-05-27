package com.neu.edu.android_backend.mapper;

import com.neu.edu.android_backend.po.Selection;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SelectionMapper {

    @Insert("INSERT INTO selection (id, stuName, courseId, studentId, teacherName, courseName) " +
            "VALUES (#{id}, #{stuName}, #{courseId}, #{studentId}, #{teacherName}, #{courseName})")
    void addSelection(Selection selection);

    @Delete("DELETE FROM selection WHERE id = #{id}")
    void deleteSelection(String id);

    @Update("UPDATE selection SET stuName = #{stuName}, courseId = #{courseId}, " +
            "studentId = #{studentId}, teacherName = #{teacherName}, courseName = #{courseName} " +
            "WHERE id = #{id}")
    void updateSelection(Selection selection);

    @Select("SELECT * FROM selection WHERE id = #{id}")
    Selection getSelectionById(String id);

    @Select("SELECT * FROM selection")
    List<Selection> getAllSelections();

    @Select("SELECT * FROM selection WHERE stuName = #{stuName}")
    List<Selection> getSelectionsByStudentName(String stuName);

    @Select("SELECT * FROM selection WHERE courseId = #{courseId}")
    List<Selection> getSelectionsByCourseId(String courseId);

    // 可以根据需要添加其他查询方法
}
