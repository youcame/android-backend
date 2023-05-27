package com.neu.edu.android_backend.extraController;

import com.neu.edu.android_backend.mapper.ApprovalMapper;
import com.neu.edu.android_backend.mapper.StudentMapper;
import com.neu.edu.android_backend.service.AdministratorService;
import com.neu.edu.android_backend.service.StudentService;
import com.neu.edu.android_backend.service.TeacherService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Log4j2
@RestController
public class ChangeApprovalController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdministratorService administratorService;

    @PutMapping("/students/chooseApproval")
    public ResponseEntity<Boolean> updateApprovalReason(
            @RequestParam String approvalId,
            @RequestParam String reason
    ) {
        try {
            boolean success = studentService.giveReason(approvalId, reason);
            return ResponseEntity.ok(success);
        } catch (Exception e) {
            log.error("Failed to update approval reason", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/teachers/changeApproval")
    public ResponseEntity<Boolean> updateTeacherApproval(
            @RequestParam String approvalId,
            @RequestParam String reason,
            @RequestParam String result
    ) {
        try {
            boolean success = teacherService.changeApproval(approvalId, reason,result);
            return ResponseEntity.ok(success);
        } catch (Exception e) {
            log.error("Failed to update approval reason", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/administrators/changeApproval")
    public ResponseEntity<Boolean> updateAdministratorApproval(
            @RequestParam String approvalId,
            @RequestParam String reason,
            @RequestParam String result
    ) {
        try {
            boolean success = administratorService.changeApproval(approvalId,reason,result);
            return ResponseEntity.ok(success);
        } catch (Exception e) {
            log.error("Failed to update approval reason", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
