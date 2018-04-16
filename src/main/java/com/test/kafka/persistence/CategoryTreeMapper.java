package com.test.kafka.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.kafka.vo.CategoryTree;



/**
 * @name:CategoryTreeMapper.class
 */
@Repository
public interface CategoryTreeMapper {
	public void save(CategoryTree categoryTree);

	public List<CategoryTree> queryById(String categoryid);

}
