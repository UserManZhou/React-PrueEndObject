package com.gec.amolpsw.service;

import com.gec.amolpsw.entity.UserInf;
import com.sun.istack.internal.NotNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

public interface UserService {

    public List<UserInf> findUser();

    public UserInf findNameAndPassword(UserInf userInf);

    public Boolean incrementUser(List<UserInf> userInf);

    public Boolean deleteUser(List<UserInf> userInf);

    public Boolean updateUser(List<UserInf> userInf);
}
