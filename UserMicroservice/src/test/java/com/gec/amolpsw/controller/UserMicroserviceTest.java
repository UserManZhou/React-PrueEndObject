package com.gec.amolpsw.controller;

import com.gec.amolpsw.mapper.UserInfMapper;
import com.gec.amolpsw.service.UserService;
import com.gec.amolpsw.entity.UserInf;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMicroserviceTest {


    @Autowired
    private UserService userService;

    @Autowired
    private UserInfMapper userInfMapper;

    @Test
    public void test(){
        List<UserInf> user = userService.findUser();
        System.out.println("user.toString() = " + user.toString());
    }

    @Test
    public void test2(){
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.select("id","loginname","password").eq("id",1);
//        UserInf userInf = userInfMapper.selectOne(queryWrapper);
//        System.out.println("userInf = " + userInf.toString());
        Map<String,Object> map = new HashedMap();
        map.put("id", 1);
        List<UserInf> userInfs = userInfMapper.selectByMap(map);
        System.out.println("userInf = " + userInfs.toString());
    }

//    @Test
//    public void token(){
//        Calendar calendar = Calendar.getInstance();
//
//        calendar.add(Calendar.SECOND, 1800);
//
//        Map<String,Object> map = new HashedMap();
//        String sign = JWT.create()
//                .withHeader(map)
//                .withClaim("palyload", 2)
//                .withExpiresAt(calendar.getTime())
//                .sign(Algorithm.HMAC256("dawadawd"));
//        System.out.println("sign = " + sign);
//    }
//    @Test
//    public void gettoKen(){
//        JWTVerifier dawadawd = JWT.require(Algorithm.HMAC256("dawadawd")).build();
//        DecodedJWT verify = dawadawd.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYWx5bG9hZCI6MiwiZXhwIjoxNjM1ODQ1MDM2fQ.CZWHn0Qebd8I5_h0VVAmu9kejYhzqy4SStrk9hcq3RA");
//        System.out.println("verify.getPayload() = " + verify.getPayload());
//        System.out.println("verify.getHeader() = " + verify.getHeader());
//        System.out.println("verify.getClaim(\"palyload\") = " + verify.getClaim("palyload").asInt());
//    }

    @Test
    public void test3(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        System.out.println("encode = " + encode);
    }

    @Test
    public void test4(){
     userService.incrementUser(null);
    }
}