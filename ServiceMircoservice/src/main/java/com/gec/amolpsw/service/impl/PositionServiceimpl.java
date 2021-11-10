package com.gec.amolpsw.service.impl;

import com.gec.amolpsw.entity.JobInf;
import com.gec.amolpsw.mapper.service.IJobInfService;
import com.gec.amolpsw.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceimpl implements PositionService {

    @Autowired
    @Qualifier("JobInfServiceImpl")
    private IJobInfService iJobInfService;

    @Override
    public List<JobInf> findPosition() {
        return iJobInfService.list();
    }

    @Override
    public Boolean incrementPosition(List<JobInf> jobInf) {
        return iJobInfService.saveBatch(jobInf);
    }

    @Override
    public Boolean updatePosition(List<JobInf> jobInf) {
        return iJobInfService.updateBatchById(jobInf);
    }

    @Override
    public Boolean deletePosition(List<JobInf> jobInf) {
        return iJobInfService.removeByIds(jobInf);
    }
}
