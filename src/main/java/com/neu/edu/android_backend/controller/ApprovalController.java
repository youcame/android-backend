package com.neu.edu.android_backend.controller;

import com.neu.edu.android_backend.mapper.ApprovalMapper;
import com.neu.edu.android_backend.po.Approval;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@RestController
public class ApprovalController {
    @Resource
    ApprovalMapper approvalMapper;

    @PostMapping("/approvals")
    public ResponseEntity<Void> addApproval(@RequestBody Approval approval) {
        try {
            approvalMapper.addApproval(approval);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("Failed to add approval", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/approvals/{id}")
    public ResponseEntity<Void> deleteApproval(@PathVariable String id) {
        try {
            approvalMapper.deleteApproval(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Failed to delete approval", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/approvals/{id}")
    public ResponseEntity<Void> updateApproval(@PathVariable String id, @RequestBody Approval approval) {
        try {
            approval.setId(id);
            approvalMapper.updateApproval(approval);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Failed to update approval", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/approvals/{id}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable String id) {
        try {
            Approval approval = approvalMapper.getApprovalById(id);
            if (approval != null) {
                return ResponseEntity.ok(approval);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error("Failed to get approval by id", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/approvals")
    public ResponseEntity<List<Approval>> getAllApprovals() {
        try {
            List<Approval> approvals = approvalMapper.getAllApprovals();
            return ResponseEntity.ok(approvals);
        } catch (Exception e) {
            log.error("Failed to get all approvals", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/approvals/search")
    public ResponseEntity<List<Approval>> getApprovalsByType(@RequestParam String type, @RequestParam String content, @RequestParam String studentId) {
        try {
            List<Approval> approvals = approvalMapper.getApprovalsByType(type, content, studentId);
            return ResponseEntity.ok(approvals);
        } catch (Exception e) {
            log.error("Failed to get approvals by type", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
