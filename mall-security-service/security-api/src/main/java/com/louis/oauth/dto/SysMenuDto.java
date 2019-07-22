package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Setter
@Getter
public class SysMenuDto extends BaseDto<Long> {

    /**
     * 菜单编码
     */
    private String menuCode;

    private String menuName;

    private boolean hasChildren = Boolean.FALSE;

    private Long parentId;

    private Date createTime;

    private Date updateTime;

    private List<SysMenuDto> SysMenuDtoList;




    /**
     * 状态
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
    private Long applicationId;
}
