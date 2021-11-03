package com.gec.amolpsw.service.impl;

import com.gec.amolpsw.mapper.UserInfMapper;
import com.gec.amolpsw.service.UserService;
import com.gec.amolpsw.entity.UserInf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class Userserviceimpl implements UserService {

    @Autowired
    private UserInfMapper userInfMapper;

    @Override
    public List<UserInf> findUser() {
        return userInfMapper.selectList(null);
    }

    @Override
    public UserInf findNameAndPassword(UserInf userInf) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("loginname", userInf.getLoginname());
        map.put("password",userInf.getPassword());
        List<UserInf> userInfs = userInfMapper.selectByMap(map);
        System.out.println("userInf = " + userInfs.toString());
        return userInfs.get(0);
    }

    @Override
    public Boolean incrementUser(UserInf userInf) {
        int insert = userInfMapper.insert(userInf);
        return insert > 0;
    }
}
