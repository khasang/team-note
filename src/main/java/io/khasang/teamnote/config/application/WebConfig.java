package io.khasang.teamnote.config.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"io.khasang.teamnote.config", "io.khasang.teamnote.controller", "io.khasang.teamnote.model",
        "io.khasang.teamnote.service", "io.khasang.teamnote.dao"})
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
       // viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/static/");
        viewResolver.setSuffix("");
        viewResolver.setContentType("text/html; charset=UTF-8");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/views/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/views/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/views/js/");
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
    }


}
