package com.test.kafka.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.kafka.vo.Event;



/**
 * @name:EventMapper.class
 * @description:
 */
@Repository
public interface EventMapper {
	public void save(Event event);

	public List<Event> queryById(String categoryid);

}
