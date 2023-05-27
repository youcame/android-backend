package com.neu.edu.android_backend.service;

import com.neu.edu.android_backend.mapper.ApprovalMapper;
import com.neu.edu.android_backend.po.Approval;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdministratorService {
    @Resource
    private ApprovalMapper approvalMapper;
    public boolean changeApproval(String approvalId,String reason,String result){
        Approval approval = approvalMapper.getApprovalById(approvalId);
        if("end".equals(approval.getState())&&"通过".equals(result)&&"null".equals(approval.getSecondResult())){
            approval.setSecondResult("true");
            approvalMapper.updateApproval(approval);
            return true;
        }else if("end".equals(approval.getState())&&"不通过".equals(result)&&"null".equals(approval.getSecondResult())){
            approval.setState("end");
            approval.setRejectReason(reason);
            approval.setSecondResult("false");
            approvalMapper.updateApproval(approval);
            return true;
        } else if ("end".equals(approval.getState())&&"撤销".equals(result)) {
            approval.setSecondResult("null");
            approval.setRejectReason("null");
            approvalMapper.updateApproval(approval);
            return true;
        }
        return false;
    }
}
