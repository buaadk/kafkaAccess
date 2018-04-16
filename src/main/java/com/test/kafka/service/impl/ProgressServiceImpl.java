package com.test.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.kafka.persistence.ProgressMapper;
import com.test.kafka.service.ProgressService;
import com.test.kafka.vo.Progress;

public class ProgressServiceImpl implements ProgressService {
	@Autowired
	private ProgressMapper progressMapper;
	
	@Override
	public void save(Progress progress) {
		// TODO Auto-generated method stub
		progressMapper.save(progress);
	}

	@Override
	public Progress queryByTableName(String tableName) {
		// TODO Auto-generated method stub
		return progressMapper.queryByTableName(tableName);
	}

}
