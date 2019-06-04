package com.louis.security.oauth.entity;

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
 */
@Setter
@Getter
@Entity
@Table(name = "sys_menu")
public class MenuItem extends TreeEntity<Long> {


    @Column(name = "menu_name")
    private String menuName;

    /**
     * 只有按钮才有url
     */
    @Column(name = "url")
    private String url;


}
