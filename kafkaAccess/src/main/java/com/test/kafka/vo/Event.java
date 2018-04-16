package com.test.kafka.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户行为表
 */
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	// 行为时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date timestamp;
	// 用户ID
	private Integer visitorid;
	// 事情事件
	private String event;
	// 商品ID
	private Integer itemid;
	// 交易ID
	private String transactionid;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getVisitorid() {
		return visitorid;
	}

	public void setVisitorid(Integer visitorid) {
		this.visitorid = visitorid;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

}
