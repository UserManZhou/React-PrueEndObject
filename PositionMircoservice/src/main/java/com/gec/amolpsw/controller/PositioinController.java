package com.gec.amolpsw.controller;

import com.gec.amolpsw.entity.JobInf;
import com.gec.amolpsw.service.PositionService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiSupport(author = "Zhou",order = 3)
@RequestMapping("PositionManage")
public class PositioinController {

    @Autowired
    private PositionService positionService;

    @ApiOperation(value = "findPosition return List<JobInf>",tags = "查询职位",response = java.util.List.class,httpMethod = "GET",code = 200)
    @ApiOperationSupport(order = 1,author = "Zhou",includeParameters = "null")
    @GetMapping("findPosition")
    @ResponseBody
    /**
     * @date 2021/11/10 PM20:18
     * @apiNote findPosition is PositionManage Controller note
     * @deprecated findPosition find Table Job_inf Data
     */
    public List<JobInf> findPosition(){
        return  positionService.findPosition();
    }

    @ApiOperation(value = "incrmentPosition return String JSON",tags = "添加职位",response = java.lang.String.class,code = 200,httpMethod = "POST")
    @ApiOperationSupport(order = 2,author = "Zhou",includeParameters = {"List<JobInf>"})
    @PostMapping("incrmentPosition")
    @ResponseBody
    /**
     * @date 2021/11/10 PM20:23
     * @apiNote incrmentPosition is PositionManage Controller note
     * @deprecated incrmentPosition save from Table Job_inf Data
     */
    public String incrmentPosition(@ApiParam(value = "jobInf",type = "List") List<JobInf> jobInf){
        Boolean aBoolean = positionService.incrementPosition(jobInf);
        return  aBoolean ? "OK" : "Please Again Operation";
    }

    @ApiOperation(value = "updatePosition return String JSON",tags = "修改职位信息",response = java.lang.String.class,httpMethod = "POST",code = 200)
    @ApiOperationSupport(order = 3,author = "Zhou",includeParameters = {"List<JobInf>"})
    @PostMapping("updatePosition")
    @ResponseBody
    /**
     * @date 2021/11/10 PM20:26
     * @apiNote updatePosition is PositionManage Controller note
     * @deprecated updatePosition update from Table Job_inf Data
     */
    public String updatePosition(@ApiParam(value = "jobInf",type = "List") List<JobInf> jobInf){
        Boolean aBoolean = positionService.updatePosition(jobInf);
        return  aBoolean ? "OK" : "Please Again Operation";
    }

    @ApiOperation(value = "deletePosition return String JSON",tags = "删除职位信息",response = java.lang.String.class,httpMethod = "POST",code = 200)
    @ApiOperationSupport(order = 4,author = "Zhou",includeParameters = {"List<JobInf>"})
    @PostMapping("deletePosition")
    @ResponseBody
    /**
     * @date 2021/11/10 PM20:28
     * @apiNote deletePosition is PositionManage Controller note
     * @deprecated deletePosition delete from Table Job_inf Data
     */
    public String deletePosition(List<JobInf> jobInf){
        Boolean aBoolean = positionService.deletePosition(jobInf);
        return  aBoolean ? "OK" : "Please Again Operation";
    }
}
