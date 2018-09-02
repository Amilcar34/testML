package com.modelo;

import java.util.Arrays;

public class MLA {
	
    private String id;
    private String name;
    private String country_id;
    private String sale_fees_mode;
    private int mercadopago_version;
    private String default_currency_id;
    private String immediate_payment;
    private String[] payment_method_ids;
    
	public MLA(String id, String name, String country_id, String sale_fees_mode, int mercadopago_version,
			String default_currency_id, String immediate_payment, String[] payment_method_ids) {
		super();
		this.id = id;
		this.name = name;
		this.country_id = country_id;
		this.sale_fees_mode = sale_fees_mode;
		this.mercadopago_version = mercadopago_version;
		this.default_currency_id = default_currency_id;
		this.immediate_payment = immediate_payment;
		this.payment_method_ids = payment_method_ids;
	}

	@Override
	public String toString() {
		return "MLA [id=" + id + ", name=" + name + ", country_id=" + country_id + ", sale_fees_mode=" + sale_fees_mode
				+ ", mercadopago_version=" + mercadopago_version + ", default_currency_id=" + default_currency_id
				+ ", immediate_payment=" + immediate_payment + ", payment_method_ids="
				+ Arrays.toString(payment_method_ids) + "]";
	}



	public String getId() {
		return id;
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

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getSale_fees_mode() {
		return sale_fees_mode;
	}

	public void setSale_fees_mode(String sale_fees_mode) {
		this.sale_fees_mode = sale_fees_mode;
	}

	public int getMercadopago_version() {
		return mercadopago_version;
	}

	public void setMercadopago_version(int mercadopago_version) {
		this.mercadopago_version = mercadopago_version;
	}

	public String getDefault_currency_id() {
		return default_currency_id;
	}

	public void setDefault_currency_id(String default_currency_id) {
		this.default_currency_id = default_currency_id;
	}

	public String getImmediate_payment() {
		return immediate_payment;
	}

	public void setImmediate_payment(String immediate_payment) {
		this.immediate_payment = immediate_payment;
	}

	public String[] getPayment_method_ids() {
		return payment_method_ids;
	}

	public void setPayment_method_ids(String[] payment_method_ids) {
		this.payment_method_ids = payment_method_ids;
	}


    
	
    
    
}
