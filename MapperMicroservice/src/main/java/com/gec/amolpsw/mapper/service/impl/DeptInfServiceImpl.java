package com.gec.amolpsw.mapper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.amolpsw.mapper.DeptInfMapper;
import com.gec.amolpsw.mapper.service.IDeptInfService;
import com.gec.amolpsw.entity.DeptInf;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-11-01
 */
@Service("DeptInfServiceImpl")
public class DeptInfServiceImpl extends ServiceImpl<DeptInfMapper, DeptInf> implements IDeptInfService {

}
