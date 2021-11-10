package com.gec.amolpsw.service.impl;

import com.gec.amolpsw.entity.DeptInf;
import com.gec.amolpsw.mapper.service.IDeptInfService;
import com.gec.amolpsw.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceimpl implements DepartmentService {

    @Autowired
    @Qualifier("DeptInfServiceImpl")
    private IDeptInfService iDeptInfService;

    @Override
    public List<DeptInf> findDepartment() {
        return iDeptInfService.list();
    }

    @Override
    public Boolean deleteDepartment(List<DeptInf> deptInf) {
        return iDeptInfService.removeByIds(deptInf);
    }

    @Override
    public Boolean updateDepartment(List<DeptInf> deptInf) {
        return iDeptInfService.updateBatchById(deptInf);
    }

    @Override
    public Boolean incrementDepartment(List<DeptInf> deptInf) {
        return iDeptInfService.saveBatch(deptInf);
    }
}
