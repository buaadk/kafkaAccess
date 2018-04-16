package com.test.kafka.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.kafka.vo.Event;
import com.test.kafka.vo.ItemProperties;



/**
 * @name:EventMapper.class
 * @description:
 * @author:张晓斌
 * @location:com.jusfoun.web.jingdong.persistence.JDMapper.class
 * Copyright 2015 by Jusfoun.com. All Right Reserved
 */
@Repository
public interface ItemPropertiesMapper {
	public void save(ItemProperties itemProperties);

}
