package com.louis.validate.image;
import com.google.code.kaptcha.Producer;
import com.louis.security.properties.SecurityProperties;
import com.louis.validate.ValidateCode;
import com.louis.validate.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.image.BufferedImage;

/**
 * @author louis
 * <p>
 * Date: 2019/6/18
 * Description: 图片验证码生成器
 */
public class ImageCodeGenerator  implements ValidateCodeGenerator {
    private Producer captchaProducer;
    private SecurityProperties securityProperties;



    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String text = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(text);
        return new ImageCode(image, text, securityProperties.getCode().getImage().getExpireIn());
    }

    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
