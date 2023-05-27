package com.neu.edu.android_backend.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Selection {
    private String id;
    private String stuName;
    private String courseId;
    private String studentId;
    private String teacherName;
    private String courseName;

}

