package com.gec.amolpsw.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootConfiguration
@EnableSwagger2WebMvc
public class SwaagerConfig {

    @Bean
    public Docket docket() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("swagger-bootstrap-ui-demo RESTful APIs")
                        .description("# swagger-bootstrap-ui-demo RESTful APIs")
                        .termsOfServiceUrl("http://www.xx.com/")
                        .contact("2830634496@qq.com")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("2.X版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.gec.amolpsw.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

//    @Bean
//    public ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("Swaager-Bootstrap in restful Api")
//                .version("1.0")
//                .description("this is Swaager-Bootstrap Document")
//                .contact("2830634496@qq.com")
//                .build();
//    }

}
