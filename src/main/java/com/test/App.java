package com.test;

import java.lang.reflect.Field;
import java.util.List;

import com.mercadolibre.sdk.Meli;

/**
 * fuente: https://github.com/fedecoraglio/meli-java-example
 */
public class App {
	public static void main(String[] args) throws Exception {

		final List<Site> sites = SiteHandler.getInstance().getAllMeliSite();
		for (final Site site : sites) { System.out.println(site); }
		
		
		MLA mla = SiteHandler.getInstance().getAllMeliSiteMLA();
		System.out.println(mla.toString());

		
		
		PaymentMethodIds ids = SiteHandler.getInstance().getPaymentMethodIds("MLATB");
		System.out.println(ids.toString());
		
		
//		Meli meli = new Meli(2961716189437531l, "dB17C9lX1ybRjNxFBCZHo54O5uL1NJwT");
//		System.out.println(meli.get("/payment_methods/MLATB").getResponseBody());
	}
}
