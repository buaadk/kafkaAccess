package com.test.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * 初始化数据
 * 实际环境中删除
 * 
 * @author 陈 志斌
 * @delete
 */
public class InitUserUtil {
    
    private static Logger LOG = Logger.getLogger(InitUserUtil.class);
    
    /**
     * 初始化用户
     * @param context
     */
    public static void initUsers(ApplicationContext context) {
//        UserMapper userMapper = context.getBean(UserMapper.class);
//
//        if (userMapper.list() == null || userMapper.list().isEmpty()) {
//            LOG.info("初始数据不存在，插入50条用户数据");
//            for (int i = 0; i < 50; i++) {
//                User user = new User();
//                userMapper.add(user);
//            }
//        }
    }

}