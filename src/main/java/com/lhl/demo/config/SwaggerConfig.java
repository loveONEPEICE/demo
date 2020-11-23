package com.lhl.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    http://localhost:8081/swagger-ui.html
// TODO: 2020/11/4 不能正常显示文档，未找到原因
    public static final String PACKAGE = "com.lhl.demo";

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage(PACKAGE))
                .paths(PathSelectors.any())// 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("车辆管理系统API")
                .description("车辆管理系统文档")
                .version("1.0")
                .termsOfServiceUrl("www.baidu.com")
                .build();
    }
}
