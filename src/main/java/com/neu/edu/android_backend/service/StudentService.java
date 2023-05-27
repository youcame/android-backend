package com.neu.edu.android_backend.service;

import com.neu.edu.android_backend.mapper.ApprovalMapper;
import com.neu.edu.android_backend.mapper.StudentMapper;
import com.neu.edu.android_backend.po.Approval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private final ApprovalMapper approvalMapper;
    private final StudentMapper studentMapper;

    public StudentService(ApprovalMapper approvalMapper, StudentMapper studentMapper) {
        this.approvalMapper = approvalMapper;
        this.studentMapper = studentMapper;
    }

    public boolean giveReason(String approvalId,String reason){
        Approval approval = approvalMapper.getApprovalById(approvalId);
        if(approval.getState().equals("able")){
            approval.setChooseReason(reason);
            approval.setState("unapproved");
            approvalMapper.updateApproval(approval);
            return true;
        }else if(approval.getState().equals("unapproved")){
            approval.setState("able");
            approval.setChooseReason("");
            approvalMapper.updateApproval(approval);
            return true;
        }else if(approval.getState().equals("end")&&!"null".equals(approval.getSecondResult())){
            approval.setConfirm("true");
            approvalMapper.updateApproval(approval);
            return true;
        } else{
            return false;
        }
    }
}
