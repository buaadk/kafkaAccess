package com.test.kafka.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.kafka.vo.CategoryTree;



/**
 * @name:CategoryTreeMapper.class
 * @description:
 * @author:张晓斌
 * @location:com.jusfoun.web.jingdong.persistence.JDMapper.class
 * Copyright 2015 by Jusfoun.com. All Right Reserved
 */
@Repository
public interface CategoryTreeMapper {
	public void save(CategoryTree categoryTree);

	public List<CategoryTree> queryById(String categoryid);

}
