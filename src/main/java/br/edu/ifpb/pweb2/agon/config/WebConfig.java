package br.edu.ifpb.pweb2.agon.config;

import br.edu.ifpb.pweb2.agon.interceptors.AdminInterceptor;
import br.edu.ifpb.pweb2.agon.interceptors.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/css/**", "/js/**", "/images/**");

        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/race/create", "/race/*/edit", "/race/*/questions/**");
    }
}