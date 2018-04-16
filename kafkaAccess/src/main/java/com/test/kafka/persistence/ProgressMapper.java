package com.test.kafka.persistence;

import org.springframework.stereotype.Repository;

import com.test.kafka.vo.Progress;



/**
 * @name:ProgressMapper.class
 * @description:
 * @author:张晓斌
 * @location:com.jusfoun.web.jingdong.persistence.JDMapper.class
 * Copyright 2015 by Jusfoun.com. All Right Reserved
 */
@Repository
public interface ProgressMapper {
	public void save(Progress Progress);

	public Progress queryByTableName(String tableName);

}
