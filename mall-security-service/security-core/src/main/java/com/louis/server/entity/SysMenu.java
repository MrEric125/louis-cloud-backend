package com.louis.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.louis.core.entity.TreeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/4
 * Description:
 * 首页菜单列表
 */
@Setter
@Getter
@Entity
@Table(name = "sys_menu")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysMenu extends TreeEntity<Long> {

    public static final int DISABLE = 0;
    public static final int CANUSE = 1;



    private static final long serialVersionUID = 3382613089219814040L;


    /**
     * 菜单编码
     */
    @Column(name = "menu_code")
    private String menuCode;

    @Column(name = "menu_name")
    private String menuName;

    /**
     * 状态,1为可用，0位禁用
     */
    private int status;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 序号
     */
    private Integer number;

    /**
     * 备注
     */
    private String remark;
    /**
     * 系统ID
     */
    @Column(name = "application_id")
    private Long applicationId;







}
