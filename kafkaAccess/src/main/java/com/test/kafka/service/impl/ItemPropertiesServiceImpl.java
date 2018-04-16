package com.test.kafka.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.kafka.persistence.ItemPropertiesMapper;
import com.test.kafka.service.ItemPropertiesService;
import com.test.kafka.vo.ItemProperties;

@Service
@Transactional(readOnly = true)
public class ItemPropertiesServiceImpl implements ItemPropertiesService {
	private static final Logger LOGGER = Logger.getLogger(ItemPropertiesServiceImpl.class);

	@Autowired
	private ItemPropertiesMapper itemPropertiesMapper;

	@Override
	@Transactional(readOnly = false)
	public void save(ItemProperties event) {
		try {
			itemPropertiesMapper.save(event);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

}
