package com.gec.amolpsw.mapper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.amolpsw.mapper.JobInfMapper;
import com.gec.amolpsw.mapper.service.IJobInfService;
import com.gec.amolpsw.entity.JobInf;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-11-01
 */
@Service("JobInfServiceImpl")
public class JobInfServiceImpl extends ServiceImpl<JobInfMapper, JobInf> implements IJobInfService {

}
