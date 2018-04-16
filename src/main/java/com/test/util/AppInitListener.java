package com.test.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 
 *初始化数据库操作
 */
@Component
public class AppInitListener implements ApplicationListener<ContextRefreshedEvent> {
	
    @Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		InitUserUtil.initUsers(event.getApplicationContext());
	}

}
