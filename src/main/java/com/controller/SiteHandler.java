package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.modelo.Attribute;
import com.modelo.MLA;
import com.modelo.PaymentMethodIds;
import com.modelo.Site;
import com.modelo.Tag;
import com.modelo.Value;
import com.ning.http.client.Response;

public class SiteHandler {
	private static final String ID_KEY = "id";
	private static final String NAME_KEY = "name";
	private final Meli meli;
	private Response response;
	private Gson gson = new Gson();
	private static final SiteHandler instance = new SiteHandler();

	public List<Site> getAllMeliSite() {
		final List<Site> newSites = new ArrayList<Site>();
		try {

			response = meli.get("/sites/");
			final List<StringMap<String>> sites = gson.fromJson(response.getResponseBody(), List.class);
			for (final StringMap<String> entries : sites) {
				newSites.add(new Site(entries.get(ID_KEY), entries.get(NAME_KEY)));
			}
		} catch (MeliException ex) {
			System.out.println("Error " + ex.getMessage());
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}
		return newSites;
	}

	public List<Attribute> getAttributesRequieredByCategorie(String categorie) {
		final List<Attribute> listAttributeRequiered = new ArrayList<Attribute>();
		final List<Attribute> listAttribute = new ArrayList<>();
		final List<Value> values = new ArrayList<Value>();
		try {
			response = meli.get("/categories/" + categorie+ "/attributes");
			final Attribute[] listMapAttributes = gson.fromJson(response.getResponseBody(), Attribute[].class);

			System.out.println(listMapAttributes.length);
			for (Attribute attribute : listMapAttributes) {
				System.out.print(attribute.getTags().isRequired());
				if (attribute.getTags().isRequired())
					listAttributeRequiered.add(attribute);
				listAttribute.add(attribute);
			}
			System.out.println();
			System.out.println(listAttributeRequiered.size());
			for (Attribute attribute : listAttributeRequiered) {
				System.out.println(attribute.getName() + " " + attribute.getType());
				Value[] list = attribute.getValues();
				for (Value value : list) {
					System.out.println(value.getName() + " " + value.getId());
				}
				System.out.println("-------------------------------------------------");
			}
			for (Attribute attribute : listAttribute) {
				System.out.println(attribute.getName() + " " + attribute.getValues());
				if (attribute.getValues() != null) {
					for (Value value : attribute.getValues()) {
						System.out.println(value.getName() + " " + value.getId());
					}
				}
				System.out.println("-------------------------------------------------");

			}

		} catch (MeliException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public MLA getAllMeliSiteMLA() {
		final MLA mla;
		try {
			response = meli.get("/sites/MLA");
			mla = gson.fromJson(response.getResponseBody(), MLA.class);
			System.out.println("------------------------------------------------");
			return mla;
		} catch (MeliException ex) {
			System.out.println("Error " + ex.getMessage());
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}
		return null;
	}

	private SiteHandler() {
		meli = new Meli(2961716189437531l, "dB17C9lX1ybRjNxFBCZHo54O5uL1NJwT");
	}

	public static SiteHandler getInstance() {
		return instance;
	}

	public PaymentMethodIds getPaymentMethodIds(String payment_method_ids) {
		final PaymentMethodIds paymentMethodIds;
		try {
			response = meli.get("/payment_methods/" + payment_method_ids);
			paymentMethodIds = gson.fromJson(response.getResponseBody(), PaymentMethodIds.class);
			System.out.println("------------------------------------------------");
			return paymentMethodIds;
		} catch (MeliException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
