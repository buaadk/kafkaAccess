package com.test.kafka.persistence;

import org.springframework.stereotype.Repository;

import com.test.kafka.vo.Progress;



/**
 * @name:ProgressMapper.class
 */
@Repository
public interface ProgressMapper {
	public void save(Progress Progress);

	public Progress queryByTableName(String tableName);

}
