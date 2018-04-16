package com.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.test.config.MybatisConfig;
import com.test.util.AppInitListener;

@SpringBootApplication
@Configuration
@Import({ AppInitListener.class, MybatisConfig.class })

@ComponentScan(basePackages = { "com.test" })
@EnableAutoConfiguration

public class Starter extends SpringBootServletInitializer{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Starter.class);
    }
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Starter.class, args);
	}	
}
