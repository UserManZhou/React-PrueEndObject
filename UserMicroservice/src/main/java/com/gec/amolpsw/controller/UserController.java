package com.gec.amolpsw.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gec.amolpsw.entity.UserInf;
import com.gec.amolpsw.service.UserService;
import com.gec.amolpsw.token.TokenIncrement;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("UserManage")
@ApiSupport(author = "Zhou",order = 1)
@Api(value = "User Microservice",description = "this is User Description Microservice")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "User Manage and Message")
    @GetMapping("findUser")
    @ResponseBody
    @ApiOperationSupport(author = "Zhou",order = 2,includeParameters = {"HttpServletRequest"})
    /**
     * @date 2021/11/3 PM19:33
     * @apiNote this findUser is UserControler Node
     * @deprecated Search User rentur entity UserPojo
     */
    public Map findUser(HttpServletRequest request){
        Map map = new HashMap();
        map.put("User", userService.findUser());
        map.put("token", request.getHeader("header"));
        return map;
    }

    @ApiOperation(value = "User login")
    @PostMapping("login")
    @ResponseBody
    @ApiOperationSupport(author = "Zhou",order = 3,includeParameters = {"loginname","password"})
    /**
     * @date 2021/11/3 PM19:35
     * @apiNote this Login is UserController Node
     * @deprecated Login User if Not User renturn JSON data
     */
    public String login(UserInf userInf) throws JsonProcessingException {
        System.out.println("userInf = " + userInf.toString());
        UserInf user = userService.findNameAndPassword(userInf);
        Map map = new HashMap();
        if (user == null){
            map.put("Message", "Not Token");
        }
        map.put("token", TokenIncrement.getToken(userInf));
        return new ObjectMapper().writeValueAsString(map);
    }

    @ApiOperation(value = "User Error Login")
    @GetMapping("error")
    @ResponseBody
    @ApiResponse(message = "error",response = java.lang.String.class,code = 200)
    /**
     * @date 2021/11/3 PM19:37
     * @apiNote this Error is UserController Node
     * @deprecated Error Not Login Hint User Again Login
     */
    public String Error(){
        return "Please User Login";
    }

    @ApiOperation(value = "Increment User",tags = "添加用户",httpMethod = "POST",response = java.lang.String.class,code = 200)
    @PostMapping("incrementUser")
    @ResponseBody
    public String incrementUser(@ApiParam(value = "user_inf") UserInf userInf){
        userService.incrementUser(null);
        return  "";
    }


}
