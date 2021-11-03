package com.gec.amolpsw.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-11-01
 */
@ApiModel(description = "User Entity")
@Data
@EqualsAndHashCode()
public class UserInf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(name = "User id and Auto_increment table is clounm",value = "User table id ",required = false,position = 1)
    private int id;

    @TableField("loginname")
    @ApiModelProperty(name = "User loginname and table is clounm" ,value = "User login name",required = false,position = 2,example = "登录账号")
    private String loginname;

    @TableField("PASSWORD")
    @ApiModelProperty(name = "User login password and table is password clounm",value = "User login password",required = false,position = 3,example = "登录密码")
    private String password;

    @TableField("STATUS")
    @ApiModelProperty(name = "User Status and table is status clounm",value = "User Status",required = false,position = 4,example = "用户状态")
    private Integer status;

    @TableField("createdate")
    @ApiModelProperty(name = "User Createdate and table is createdate clounm",value = "User Createdate",required = false,position = 5,example = "创建时间")
    private LocalDateTime createdate;

    @TableField("username")
    @ApiModelProperty(name = "User Username and table is username clounm",value = "UserName",required = false,position = 6,example = "用户名")
    private String username;


}
