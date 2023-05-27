package com.neu.edu.android_backend.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    private String name;
    private String date;
    private String teacherName;
    private String id;

}
