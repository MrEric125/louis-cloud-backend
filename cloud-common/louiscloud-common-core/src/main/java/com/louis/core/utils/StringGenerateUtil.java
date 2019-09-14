package com.louis.core.utils;

import com.louis.core.utils.DateUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author louis
 * <p>
 * Date: 2019/8/30
 * Description:
 */
public class StringGenerateUtil {


    /**
     *
     * @param pre 前缀
     * @param date 传入的日期
     * @param num Code总长度
     * @return
     */
    public static String generateCode(String pre,Date date, int num) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return DateUtils.DateToStr(DateUtils.YYYYMMDDHHMMSSSSS, date)
                .concat(uuid.substring(0, num - DateUtils.YYYYMMDDHHMMSSSSS.length()));
    }


}
