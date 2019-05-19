package com.louis.order;

import com.louis.core.utils.SwaggerUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Eric
 * @date create in 2019/5/12
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean(name = "swagger_docket")
    public Docket api(Environment env) {
        //测试环境则返回接口信息
        String basePackage = "com.louis.order";
        if( SwaggerUtil.showApi(env) ){
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(basePackage))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(apiInfo())
                    .useDefaultResponseMessages(false);
        }
        //正式环境则不返回接口信息
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.none())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        String title = "订单模块";
        return new ApiInfoBuilder()
                .title(title)
                .description("API 文档")
                .version("2.0.0")
                .build();
    }

}
