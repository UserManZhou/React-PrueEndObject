package com.gec.amolpsw.mapper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.amolpsw.mapper.UserInfMapper;
import com.gec.amolpsw.mapper.service.IUserInfService;
import com.gec.amolpsw.entity.UserInf;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-11-01
 */
@Service("UserInfServiceImpl")
public class UserInfServiceImpl extends ServiceImpl<UserInfMapper, UserInf> implements IUserInfService {

}
