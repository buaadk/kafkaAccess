package com.test.kafka.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 * 类别树
 */
public class CategoryTree implements Serializable {
	private static final long serialVersionUID = 1L;
	// 类别ID
	private Integer categoryid;
	// 父类ID
	private Integer parentid;

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	
	/*public CategoryTree(String message){
		JSONObject json = JSONObject.parseObject(message);
        Object category = json.get("categoryid");
        Integer categoryid = Integer.parseInt(category+"");
        this.categoryid = categoryid;
        Object parent = json.get("parentid");
        Integer parentid = Integer.parseInt(parent+"");
        this.parentid = parentid;
	}*/
	
}
