package com.test.kafka.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.kafka.persistence.EventMapper;
import com.test.kafka.service.EventService;
import com.test.kafka.vo.Event;

@Service
@Transactional(readOnly = true)
public class EventServiceImpl implements EventService {
	private static final Logger LOGGER = Logger.getLogger(EventServiceImpl.class);

	@Autowired
	private EventMapper eventMapper;

	@Override
	@Transactional(readOnly = false)
	public void save(Event event) {
		try {
			eventMapper.save(event);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info(e);
		}
	}

	@Override
	public List<Event> queryById(String eventId) throws Exception {
		// TODO Auto-generated method stub
		return eventMapper.queryById(eventId);
	}

}
