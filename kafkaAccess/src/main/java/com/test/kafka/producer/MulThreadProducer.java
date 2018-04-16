package com.test.kafka.producer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MulThreadProducer implements Runnable {

	private static final String TOPIC = "multipleSource";

	private final String BROKER_LIST = "192.168.56.121:9092,192.168.56.122:9092,192.168.56.123:9092";
	private final String SERIALIZER_CLASS = "kafka.serializer.StringEncoder";
	private final String ZK_CONNECT = "192.168.56.121:2181,192.168.56.122:2181,192.168.56.123:2181";
	Properties props;
	Producer<String, String> producer;

	public MulThreadProducer() {
		props = new Properties();
		props.put("zk.connect", ZK_CONNECT);
		props.put("serializer.class", SERIALIZER_CLASS);
		props.put("bootstrap.servers", BROKER_LIST);
		props.put("request.required.acks", "1");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<String, String>(props);
	}

	public synchronized void publishMessage(String topic) {
		// String runtime = new Date().toString();
		File file = new File("D:/data/dataset/events.csv");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			Integer line = 1;
			String timestamp = null;
			String visitorid = null;
			String event = null;
			String itemid = null;
			String transactionid = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				String[] splStr = tempString.split(",");
				if (line.equals(1)) {
					timestamp = splStr[0];
					visitorid = splStr[1];
					event = splStr[2];
					itemid = splStr[3];
					transactionid = splStr[4];
				} else {
					String value0 = "0";
					String value1 = "0";
					String value2 = "0";
					String value3 = "0";
					String value4 = "0";
					if (splStr.length == 5) {
						value0 = splStr[0];
						value1 = splStr[1];
						value2 = splStr[2];
						value3 = splStr[3];
						value4 = splStr[4];
					}else if (splStr.length == 4) {
						value0 = splStr[0];
						value1 = splStr[1];
						value2 = splStr[2];
						value3 = splStr[3];
					}
					String msg = "{\"" + timestamp + "\":" + "\"" + value0 + "\"" 
					+ ",\"" + visitorid + "\":" + "\"" + value1 + "\"" 
					+ ",\"" + event + "\":" + "\"" + value2 + "\""
					+ ",\"" + itemid + "\":" + "\"" + value3 + "\""
					+ ",\"" + transactionid + "\":" + "\"" + value4 
					+ "\"}";
					ProducerRecord<String, String> data = new ProducerRecord<String, String>(topic, msg);
					producer.send(data);
					System.out.println("线程名："+Thread.currentThread().getName() + " : "+"第"+line+"行， "+"msg = " + msg);
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
	
	public synchronized void m4t2() {  
        int i = 5;  
        while( i-- > 0) {  
             System.out.println(Thread.currentThread().getName() + " : " + i);  
             try {  
                  Thread.sleep(500);  
             } catch (InterruptedException ie) {  
             }  
        }  
   }
	
	@Override
	public void run() {
		publishMessage(TOPIC);
		//m4t2();
	}

	public static void main(String[] args) {
		MulThreadProducer kp = new MulThreadProducer();// 使用kafka集群中创建好的主题 multipleSource
		new Thread(kp, "B").start();
		//new Thread(kp, "C").start();

	}

}
