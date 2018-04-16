package com.jusfoun.util;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 使用Jackson转换Object和字符串
 *
 */
public class JSONUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtils.class);
	
	/**
	 * Eager模式单例
	 */
	private static ObjectMapper om = new ObjectMapper();
	
	private JSONUtils(){
		//对外关闭构造
	}
	
	/**
	 * 开放对外接口
	 * @return
	 */
	public static ObjectMapper getObjectMapper(){		
		return om;
	}	
	
	/**
	 * 
	 * 通用JSON字符转换程序（Jackson）
	 * 通用Object用（包含List等）
	 * JSON标准字符串
	 * 
	 * @param o
	 * @return 结果JSON字符串
	 */
	public static String toString(Object o){
		
		String rslt = "";		
		
		synchronized(om){
			try {
				rslt = om.writeValueAsString(o);
			} catch (JsonProcessingException e) {
				LOGGER.info("Json字符串转换错误{}", e);
			}
		}
		
		return rslt;
	}
	
	/**
	 * Iterator非标准JSON字符串
	 * 打印，展示等使用
	 * 
	 * @param o
	 * @return 结果JSON字符串
	 */
	public static String toString(Iterator<?> o){
		
		String rslt = "";
		
		synchronized(om){
			try {
				while(o.hasNext()){
					rslt += om.writeValueAsString(o.next());
				}
				rslt += "\n";
				
			} catch (JsonProcessingException e) {
				LOGGER.info("Json字符串转换错误{}", e);
			}
		}
		
		return rslt;
	}

}
