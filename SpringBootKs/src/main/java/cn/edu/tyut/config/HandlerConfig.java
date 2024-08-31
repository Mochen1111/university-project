package cn.edu.tyut.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class HandlerConfig extends WebMvcConfigurerAdapter {
    @Value("${dirPath}")
    private String dirPath;
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/UpLoadFiles/**").addResourceLocations("file:"+dirPath);
    }
}
