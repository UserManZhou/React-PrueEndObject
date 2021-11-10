package com.gec.amolpsw.config;

import com.gec.amolpsw.intercpector.JWTIntercopector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Component
public class JWTConfig implements WebMvcConfigurer {

    @Autowired
    private JWTIntercopector intercopector;

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("/UserManage/login")
//                .allowedMethods("POST","GET","PUT","DELETE","OPTIONS")
//                .allowCredentials(true)
//                .maxAge(3000);
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(intercopector)
                .addPathPatterns("/**").
                excludePathPatterns("/UserManage/login","/swagger-resources/**", "/webjars/**", "/v2/**", "/doc.html/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
//
//    private CorsConfiguration corsConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        /* 请求常用的三种配置，*代表允许所有，当时你也可以自定义属性（比如header只能带什么，只能是post方式等等）
//         */
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.setMaxAge(3600L);
//        return corsConfiguration;
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig());
//        return new CorsFilter((CorsConfigurationSource) source);
//    }
}
