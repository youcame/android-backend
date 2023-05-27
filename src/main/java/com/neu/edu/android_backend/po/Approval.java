package com.neu.edu.android_backend.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Approval {
    private String studentId;
    private String teacherId;
    private String id;
    private String state;
    private String result;
    private String beginTime;
    private String endTime;
    private String courseName;
    private String rejectReason;
    private String chooseReason;
    private String confirm;
    private String secondResult;

}
