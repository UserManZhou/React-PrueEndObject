package com.gec.amolpsw.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@Data
@EqualsAndHashCode()
public class EmployeeInf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("DEPT_ID")
    private Integer deptId;

    @TableField("JOB_ID")
    private Integer jobId;

    @TableField("NAME")
    private String name;

    @TableField("CARD_ID")
    private String cardId;

    @TableField("ADDRESS")
    private String address;

    @TableField("POST_CODE")
    private String postCode;

    @TableField("TEL")
    private String tel;

    @TableField("PHONE")
    private String phone;

    @TableField("QQ_NUM")
    private String qqNum;

    @TableField("EMAIL")
    private String email;

    @TableField("SEX")
    private Integer sex;

    @TableField("PARTY")
    private String party;

    @TableField("BIRTHDAY")
    private LocalDateTime birthday;

    @TableField("RACE")
    private String race;

    @TableField("EDUCATION")
    private String education;

    @TableField("SPECIALITY")
    private String speciality;

    @TableField("HOBBY")
    private String hobby;

    @TableField("REMARK")
    private String remark;

    @TableField("CREATE_DATE")
    private LocalDateTime createDate;


}
