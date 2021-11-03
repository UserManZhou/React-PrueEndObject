package com.gec.amolpsw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gec.amolpsw.entity.UserInf;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-11-01
 */
@Mapper
@Repository
public interface UserInfMapper extends BaseMapper<UserInf> {

}
