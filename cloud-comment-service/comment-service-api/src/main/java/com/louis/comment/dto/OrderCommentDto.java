package com.louis.comment.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/20
 * Description:
 */

@Setter
@Getter
@NoArgsConstructor
public class OrderCommentDto extends BaseDto<Long> {


    private Long orderId;

    private long commentUserId;

    private Date commentTime;

    private Date updateTime;

    private String goodsName;

    private long goodsId;

    private String content;

    private String title;

    private String picPath;
}
