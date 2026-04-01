package br.edu.ifpb.pweb2.agon.config;

import br.edu.ifpb.pweb2.agon.interceptors.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**")          // intercepta tudo
                .excludePathPatterns("/login",   // exceto login
                        "/css/**",  // e assets estáticos
                        "/js/**",
                        "/images/**");
    }
}