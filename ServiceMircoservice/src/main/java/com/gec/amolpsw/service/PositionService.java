package com.gec.amolpsw.service;

import com.gec.amolpsw.entity.JobInf;

import java.util.List;

public interface PositionService {

    public List<JobInf> findPosition();

    public Boolean incrementPosition(List<JobInf> jobInf);

    public Boolean updatePosition(List<JobInf> jobInf);

    public Boolean deletePosition(List<JobInf> jobInf);
}
