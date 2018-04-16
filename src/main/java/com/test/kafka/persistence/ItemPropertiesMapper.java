package com.test.kafka.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.kafka.vo.Event;
import com.test.kafka.vo.ItemProperties;



/**
 * @name:EventMapper.class
 * @description
 */
@Repository
public interface ItemPropertiesMapper {
	public void save(ItemProperties itemProperties);

}
