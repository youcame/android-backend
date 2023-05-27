package com.neu.edu.android_backend.service;

import com.neu.edu.android_backend.mapper.ApprovalMapper;
import com.neu.edu.android_backend.po.Approval;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherService {
    @Resource
    private ApprovalMapper approvalMapper;

    public boolean changeApproval(String approvalId,String reason,String result){
        Approval approval = approvalMapper.getApprovalById(approvalId);
        if("unapproved".equals(approval.getState())&&"通过".equals(result)){
            approval.setState("end");
            approval.setResult("true");
            approvalMapper.updateApproval(approval);
            return true;
        }else if("unapproved".equals(approval.getState())&&"不通过".equals(result)){
            approval.setState("end");
            approval.setRejectReason(reason);
            approval.setResult("false");
            approvalMapper.updateApproval(approval);
            return true;
        } else if ("end".equals(approval.getState())&&"撤销".equals(result)) {
            approval.setState("unapproved");
            approval.setResult("null");
            approvalMapper.updateApproval(approval);
            return true;
        }
        return false;
    }

}
