package com.neu.edu.android_backend.mapper;

import com.neu.edu.android_backend.po.Approval;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalMapper {
    @Insert("INSERT INTO approval (id, studentId, teacherId, state, result, beginTime, endTime, courseName, confirm, secondResult) " +
            "VALUES (#{id}, #{studentId}, #{teacherId}, #{state}, #{result}, #{beginTime}, #{endTime}, #{courseName}, #{confirm}, #{secondResult})")
    void addApproval(Approval approval);

    @Delete("DELETE FROM approval WHERE id = #{id}")
    void deleteApproval(String id);

    @Update("UPDATE approval SET studentId = #{studentId}, teacherId = #{teacherId}, state = #{state}, result = #{result}, " +
            "beginTime = #{beginTime}, endTime = #{endTime}, courseName = #{courseName}, chooseReason = #{chooseReason}, " +
            "rejectReason = #{rejectReason}, confirm = #{confirm}, secondResult = #{secondResult} WHERE id = #{id}")
    void updateApproval(Approval approval);

    @Select("SELECT * FROM approval WHERE id = #{id}")
    Approval getApprovalById(String id);

    @Select("SELECT * FROM approval")
    List<Approval> getAllApprovals();

    @Select("SELECT * FROM approval WHERE ${type} = #{content} AND studentId = #{studentId}")
    List<Approval> getApprovalsByType(@Param("type") String type, @Param("content") String content, @Param("studentId") String studentId);
}
