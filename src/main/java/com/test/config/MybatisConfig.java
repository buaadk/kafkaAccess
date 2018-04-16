package com.test.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.github.miemiedev.mybatis.paginator.OffsetLimitInterceptor;

@Configuration
@MapperScan(basePackages = "com.*.*.persistence")
public class MybatisConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactory sqlSessionFactory = null;
		try {
			final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
			sessionFactory.setDataSource(dataSource);
//			sessionFactory.setConfigLocation(new InputStreamResource(this.getClass().getResourceAsStream("/mybatis-config.xml")));
			Interceptor[] interceptor = {offsetLimitInterceptor()};  
			sessionFactory.setPlugins(interceptor);
			 ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			 sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));
			sqlSessionFactory = sessionFactory.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
	
	
	public OffsetLimitInterceptor offsetLimitInterceptor() throws Exception {
		OffsetLimitInterceptor offsetLimitInterceptor = new OffsetLimitInterceptor();
		offsetLimitInterceptor.setDialectClass("com.github.miemiedev.mybatis.paginator.dialect.MySQLDialect");
		return offsetLimitInterceptor;
	}
}
