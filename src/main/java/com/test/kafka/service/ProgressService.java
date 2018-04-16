package com.test.kafka.service;

import com.test.kafka.vo.Progress;

public interface ProgressService {
	public void save(Progress progress);

	public Progress queryByTableName(String tableName);
}
