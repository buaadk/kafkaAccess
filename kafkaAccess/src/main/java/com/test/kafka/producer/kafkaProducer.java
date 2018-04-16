package com.test.kafka.producer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class kafkaProducer implements Runnable {

	private static final String TOPIC = "mykafka";

	private final String BROKER_LIST = "192.168.56.121:9092,192.168.56.122:9092,192.168.56.123:9092";
	private final String SERIALIZER_CLASS = "kafka.serializer.StringEncoder";
	private final String ZK_CONNECT = "192.168.56.121:2181,192.168.56.122:2181,192.168.56.123:2181";
	private static int Count = 10000;
	private int number = 10;
	Properties props;
	Producer<String, String> producer;

	public kafkaProducer() {
		props = new Properties();
		props.put("zk.connect", ZK_CONNECT);
		props.put("serializer.class", SERIALIZER_CLASS);
		props.put("bootstrap.servers", BROKER_LIST);
		props.put("request.required.acks", "1");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<String, String>(props);
	}

	public void publishMessage(String topic, int count) {
		// String runtime = new Date().toString();
		File file = new File("D:/data/dataset/category_tree.csv");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			Integer line = 1;
			String first = null;
			String second = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				String[] splStr = tempString.split(",");
				if (line.equals(1)) {
					first = splStr[0];
					second = splStr[1];
				} else {
					String name = "0";
					String value = "0";
					if (splStr.length > 1) {
						name = splStr[0];
						value = splStr[1];
					}
					String msg = "{\"" + first + "\":" + "\"" + name + "\"" + ",\"" + second + "\":" + "\"" + value
							+ "\"}";
					ProducerRecord<String, String> data = new ProducerRecord<String, String>(topic, msg);
					producer.send(data);
					System.out.println("第"+line+"行， "+"msg = " + msg);
				}

				Thread.sleep(100);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		producer.close();
	}

	@Override
	public void run() {
		publishMessage(TOPIC, Count);
	}

	public static void main(String[] args) {
		kafkaProducer kp = new kafkaProducer();// 使用kafka集群中创建好的主题 mykafka
		new Thread(kp, "A").start();

	}

}
