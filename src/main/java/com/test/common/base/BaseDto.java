package com.test.common.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 基础实体
 *
 */
public abstract class BaseDto<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	
	protected String id;

	protected String extra; // 备注
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getRegenerator() {
		return regenerator;
	}

	public void setRegenerator(String regenerator) {
		this.regenerator = regenerator;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	protected String creator; // 创建者
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	protected Date createDate; // 创建日期
	protected String regenerator; // 更新者
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	protected Date updateDate; // 更新日期
	protected Integer delFlag; // 删除标识
	


	public BaseDto() {
		this.delFlag = STATUS_NORMAL;
	}

	public BaseDto(String id) {
		this();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 状态（0：正常；1：删除）
	 */
	public static final Integer STATUS_NORMAL = 0;
	public static final Integer STATUS_DELETE = 1;

}
