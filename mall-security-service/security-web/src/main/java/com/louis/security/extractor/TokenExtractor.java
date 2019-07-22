package com.louis.security.extractor;

/**
 * 实现这个接口应该返回原Base-64编码
 * * 表示Token
 *
 * @author John·Louis
 * @date create in 2019/4/14
 */
public interface TokenExtractor {

    String extract(String payload);
}
