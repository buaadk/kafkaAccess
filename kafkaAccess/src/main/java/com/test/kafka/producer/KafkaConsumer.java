package com.test.kafka.producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.test.kafka.service.CatagoryTreeService;
import com.test.kafka.vo.CategoryTree;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class KafkaConsumer extends Thread {
	@Autowired
	private static CatagoryTreeService catagoryTreeService;
	
	@Resource
	public void setCatagoryTreeService(CatagoryTreeService catagoryTreeService) {
		KafkaConsumer.catagoryTreeService = catagoryTreeService;
	}

	private String topic;

	public KafkaConsumer(String topic) {
		this.topic = topic;
	}

	private ConsumerConnector createConsumer() {
		Properties props = new Properties();
		// zookeeper 配置
		// props.put("zookeeper.connect", "cluster1:2181");
		props.put("zookeeper.connect", "192.168.56.121:2181,192.168.56.122:2181,192.168.56.123:2181");

		// group 代表一个消费组
		// props.put("group.id", "jd-group");
		props.put("group.id", "group2");

		// zk连接超时
		props.put("zookeeper.session.timeout.ms", "4000");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");
		props.put("auto.offset.reset", "smallest");
		// 序列化类
		props.put("serializer.class", "kafka.serializer.StringEncoder");

		return Consumer.createJavaConsumerConnector(new ConsumerConfig(props));
	}

	@Override
	public void run() {
		ConsumerConnector consumer = createConsumer();
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, 1); // 一次从主题中获取一个数据
		Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = consumer.createMessageStreams(topicCountMap);
		KafkaStream<byte[], byte[]> stream = messageStreams.get(topic).get(0);// 获取每次接收到的这个数据
		ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
		List<CategoryTree> treeList = new ArrayList<>();
		while (treeList.size() < 5 && iterator.hasNext()) {
			String message = new String(iterator.next().message());
			System.out.println("接收到: " + message);
			JSONObject json = JSONObject.parseObject(message);
			Object category = json.get("categoryid");
			Integer categoryid = Integer.parseInt(category + "");
			CategoryTree categoryTree = new CategoryTree();
			categoryTree.setCategoryid(categoryid);
			Object parent = json.get("parentid");
			Integer parentid = Integer.parseInt(parent + "");
			categoryTree.setParentid(parentid);
			treeList.add(categoryTree);
			System.out.println("-----------------");
			try {
				catagoryTreeService.save(categoryTree);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) throws Exception {
		new KafkaConsumer("mykafka").start();// 使用kafka集群中创建好的主题 test
	}

}
