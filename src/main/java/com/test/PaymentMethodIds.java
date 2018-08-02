package com.test;

public class PaymentMethodIds {

	private String id;
	private boolean is_default;
	private char type;
	private String description;
	
	public PaymentMethodIds(String id, boolean is_default, char type, String description) {
		super();
		this.id = id;
		this.is_default = is_default;
		this.type = type;
		this.description = description;
	}

	
	@Override
	public String toString() {
		return "PaymentMethodIds [id=" + id + ", is_default=" + is_default + ", type=" + type + ", description=" + description + "]";
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isIs_default() {
		return is_default;
	}

	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
