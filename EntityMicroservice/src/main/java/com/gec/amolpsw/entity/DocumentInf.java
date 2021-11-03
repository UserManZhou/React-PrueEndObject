package com.gec.amolpsw.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Blob;
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
public class DocumentInf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("TITLE")
    private String title;

    private String filename;

    private String filetype;

    private Blob filebytes;

    @TableField("REMARK")
    private String remark;

    @TableField("CREATE_DATE")
    private LocalDateTime createDate;

    @TableField("USER_ID")
    private Integer userId;


}
