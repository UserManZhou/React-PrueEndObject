package com.gec.amolpsw.entity;

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
public class NoticeInf implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String content;


}
