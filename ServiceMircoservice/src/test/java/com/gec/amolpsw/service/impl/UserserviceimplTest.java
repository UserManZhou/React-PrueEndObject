package com.gec.amolpsw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gec.amolpsw.entity.UserInf;
import com.gec.amolpsw.mapper.UserInfMapper;
import com.gec.amolpsw.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class UserserviceimplTest {

    @Autowired(required = false)
    private UserService userService;


    @Autowired(required = false)
    private UserInfMapper userInfMapper;

    @Test
    public void test(){
        List<UserInf> user = userService.findUser();
        for (UserInf userInf : user) {
            System.out.println("userInf = " + userInf.toString());
        }
    }

    @Test
    public void test2(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("id","loginname","password").eq("loginname", "admin");
        UserInf userInf = userInfMapper.selectOne(queryWrapper);
        System.out.println("userInf = " + userInf.toString());
    }

    @Test
    public void test3(){
        userService.incrementUser(null);
    }
}