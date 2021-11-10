package com.gec.amolpsw.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Department Entity",description = "Table deptInf",subTypes = Serializable.class)
public class DeptInf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    @ApiModelProperty(name = "Department id and Auto_increment table is column",value = "deptInf table id primary key",required = false,dataType = "int",position = 1,example = "部门ID")
    private int id;

    @TableField("NAME")
    @ApiModelProperty(name = "Department name is deptInf table is column",value = "deptInf table name ",required = false,dataType = "String",position = 2,example = "部门名字")
    private String name;

    @TableField("REMARK")
    @ApiModelProperty(name = "Department remark is deptInf table is column",value = "deptInf table remark",required = false,dataType = "String",position = 3,example = "部门备注")
    private String remark;


}
