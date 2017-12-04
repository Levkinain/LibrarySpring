package ru.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
//@Import({ AppSecurityConfig.class })
@ComponentScan(basePackages = "ru.library.controller")
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
          //registry.addResourceHandler("/js/**").addResourceLocations("/META-INF/resources/js");
       // registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/pages/js/");
       // registry.addResourceHandler("/css/**").addResourceLocations("/META-INF/resources/js");
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
        }

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }
}
