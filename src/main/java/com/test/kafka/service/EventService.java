package com.test.kafka.service;

import java.util.List;

import com.test.kafka.vo.Event;

public interface EventService {
	public void save(Event event);

	public List<Event> queryById(String categoryid) throws Exception;
}
