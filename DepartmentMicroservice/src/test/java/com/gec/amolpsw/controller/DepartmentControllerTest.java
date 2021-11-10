package com.gec.amolpsw.controller;

import com.gec.amolpsw.entity.DeptInf;
import com.gec.amolpsw.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentControllerTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void test(){
        List<DeptInf> department = departmentService.findDepartment();
        department.forEach(x -> System.out.println(x.toString()));
    }

}