package com.xm.pojo;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	@Min(value=10,message="id不可以小于10")
	private int id;
	@NotBlank(message="name不能为空")
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	

}
