package com.test.kafka.vo;

import java.io.Serializable;
/**
 * 进度表
 */
public class Progress implements Serializable {
	private static final long serialVersionUID = 1L;
	// 表名
	private String tableName;
	// 已读行数
	private String num;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

}
