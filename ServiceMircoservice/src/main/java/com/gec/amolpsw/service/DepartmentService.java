package com.gec.amolpsw.service;

import com.gec.amolpsw.entity.DeptInf;

import java.util.List;

public interface DepartmentService {


    public List<DeptInf> findDepartment();

    public Boolean deleteDepartment(List<DeptInf> deptInf);

    public Boolean updateDepartment(List<DeptInf> deptInf);

    public Boolean incrementDepartment(List<DeptInf> deptInf);

}
