package com.test.kafka.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.kafka.persistence.CategoryTreeMapper;
import com.test.kafka.service.CatagoryTreeService;
import com.test.kafka.vo.CategoryTree;

@Service
@Transactional(readOnly = true)
public class CatagoryTreeServiceImpl implements CatagoryTreeService {
	private static final Logger LOGGER = Logger.getLogger(CatagoryTreeServiceImpl.class);

	@Autowired
	private CategoryTreeMapper categoryTreeMapper;

	@Override
	@Transactional(readOnly = false)
	public void save(CategoryTree categoryTree) {
		try {
			categoryTreeMapper.save(categoryTree);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Override
	public List<CategoryTree> queryById(String categoryid) throws Exception {
		// TODO Auto-generated method stub
		return categoryTreeMapper.queryById(categoryid);
	}

}
