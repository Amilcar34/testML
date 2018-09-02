package com.modelo;

import java.util.List;

public class Attribute {

	private String id;
	private String name;
	private Tag tags;
	private Value[] values;
	private String type;
	
	public String getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Tag getTags() {
		return tags;
	}
	public void setTags(Tag tags) {
		this.tags = tags;
	}
	public Value[] getValues() {
		return values;
	}
	public void setValues(Value[] values) {
		this.values = values;
	}
}
