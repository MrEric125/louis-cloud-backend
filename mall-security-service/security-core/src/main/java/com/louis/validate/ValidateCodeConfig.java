package com.louis.validate;

import com.google.code.kaptcha.Producer;
import com.louis.security.properties.SecurityProperties;
import com.louis.validate.image.ImageCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/18
 * Description:
 */
@Configuration
public class ValidateCodeConfig {


    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private Producer producer;

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        codeGenerator.setCaptchaProducer(producer);
        return codeGenerator;


    }








}
