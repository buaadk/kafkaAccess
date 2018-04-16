package com.test.kafka.service;

import java.util.List;

import com.test.kafka.vo.CategoryTree;

public interface CatagoryTreeService {
	public void save(CategoryTree categoryTree);

	public List<CategoryTree> queryById(String categoryid) throws Exception;
}
