package com.gec.amolpsw.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-11-01
 */
@Data
@EqualsAndHashCode()
public class DeptInf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("NAME")
    private String name;

    @TableField("REMARK")
    private String remark;


}
