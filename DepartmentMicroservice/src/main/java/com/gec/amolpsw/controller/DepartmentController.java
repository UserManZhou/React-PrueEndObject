package com.gec.amolpsw.controller;

import com.gec.amolpsw.entity.DeptInf;
import com.gec.amolpsw.service.DepartmentService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@RestController
//@Api(description = "Department Controller is Microservice",value = "Department Controller")
@ApiSupport(author = "Zhou",order = 2)
@Slf4j
@RequestMapping("DepartmentManage")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "find Department return List<Dept_inf> ",tags = "查询部门",httpMethod = "GET",code = 200,response = java.lang.String.class)
    @ApiOperationSupport(order = 1,author = "Zhou",includeParameters = "null")
    @GetMapping("findDepartment")
    @ResponseBody
    /**
     * @date: 2021/11/9 AM14:24
     * @apiNote  findDepartment this DepartmentManage Controller and Note
     * @deprecated find Department is find Dept_inf table data
     */
    public List<DeptInf> findDepartment(){
        return departmentService.findDepartment();
    }

    @ApiOperation(value = "increment Department Api add table dept_inf data return JSON String",tags = "添加部门",response = java.lang.String.class,code = 200,httpMethod = "POST")
    @ApiOperationSupport(order = 2,author = "Zhou",includeParameters = {"DeptInf.class"})
    @PostMapping("incrementDepartment")
    @ResponseBody
    /**
     * @date 2021/11/9 AM:15:17
     * @deprecated incrementDepartment is Operation table dept_inf insert data
     * @apiNote incrementDepartment this DepartmentManage Controller and note
     */
    public String incrmentDepartment(@ApiParam(value = "deptInf",type = "List") List<DeptInf> deptInf){
        Boolean aBoolean = departmentService.incrementDepartment(deptInf);
        return  aBoolean ? "OK" : "Please Again Operation";
    };

    @ApiOperation(value = "deleteDepartment api delete table dept_inf data return JSON String",tags = "删除部门",httpMethod = "POST",code = 200,response = java.lang.String.class)
    @ApiOperationSupport(order = 3,author = "Zhou",includeParameters = {"DeptInf.class"})
    @PostMapping("deleteDepartment")
    @ResponseBody
    /**
     * @date 2021/11/9 AM:15:22
     * @deprecated deleteDeaprtment is Operation table dept_inf delete data
     * @apiNote deleteDeaprtment this DepartmentManage Controller and note
     */
    public String deleteDeaprtment(@ApiParam(value = "deptInf",type = "List") List<DeptInf> deptInf){
        Boolean aBoolean = departmentService.deleteDepartment(deptInf);
        return aBoolean ? "OK" : "Please Again Operation";
    }

    @ApiOperation(value = "updateDepartment api update table dept_inf data return JSON String",tags = "修改部门",httpMethod = "POST",response = java.lang.String.class,code = 200)
    @ApiOperationSupport(order = 4,author = "Zhou",includeParameters = {"DeptInf.class"})
    @PostMapping("updateDepartment")
    @ResponseBody
    /**
     * @date 2021/11/9 AM:15:25
     * @deprecated updateDepartment is Operation table dept_inf update data
     * @apiNote updateDepartment this DepartmentManage Controller and note
     */
    public String updateDepartment(@ApiParam(value = "deptInf",type = "List") List<DeptInf> deptInf){
        Boolean aBoolean = departmentService.updateDepartment(deptInf);
        return aBoolean ? "OK" : "Please Again Opertaion";
    }


}
