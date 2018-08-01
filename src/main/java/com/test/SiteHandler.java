package com.test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;

public class SiteHandler {
	 //Nombre de los campos que vamos a obtener informacion
    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    //Creamos una unica instancia de Meli.
    private final Meli meli;

    private static final SiteHandler instance = new SiteHandler();

    private SiteHandler() {
        //Aca creamos el objecto Meli con la información de su aplicación.
        meli = new Meli(2961716189437531l , "dB17C9lX1ybRjNxFBCZHo54O5uL1NJwT");
    }

    public static SiteHandler getInstance() {
        return instance;
    }

    public List<Site> getAllMeliSite()  {
        //Todos los sites.
        final List<Site> newSites = new ArrayList<Site>();
        try {
            //Aqui realizamos la consulta de todos los sites.
            final Response response = meli.get("/sites/");
            //Objeto gson que sirve para "parsear" los resultados.
            final Gson gson = new Gson();
            //Convertimos desde JSON a Java creando una lista de StringMap
            final List<StringMap<String>> sites = gson.fromJson(response.getResponseBody(), List.class);
            //Convertimos los objectos StringMap a Site.
            for (final StringMap<String> entries : sites) {
                newSites.add(new Site(entries.get(ID_KEY), entries.get(NAME_KEY)));
            }
        } catch (MeliException ex) {
            //Logger error en la respuesta
            System.out.println("Error " + ex.getMessage());
        } catch (IOException e) {
            //Logger error en la transformacion usando de gson.
            System.out.println("Error " + e.getMessage());
        }
        return newSites;
    }

    public MLA getAllMeliSiteMLA(){
    	 //Todos los sites.
    	 final MLA mla ;
        try {
            //Aqui realizamos la consulta de todos los sites.
            final Response response = meli.get("/sites/MLA");
            //Objeto gson que sirve para "parsear" los resultados.
            final Gson gson = new Gson();
            //Convertimos desde JSON a Java creando una lista de StringMap
            System.out.println(response.getResponseBody());
            mla = gson.fromJson(response.getResponseBody(), MLA.class);
            //Convertimos los objectos StringMap a Site.
            Field field[] = MLA.class.getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
   				//System.out.println(field[i].getName());
   			}
            
            return mla;
        } catch (MeliException ex) {
            //Logger error en la respuesta
            System.out.println("Error " + ex.getMessage());
        } catch (IOException e) {
            //Logger error en la transformacion usando de gson.
            System.out.println("Error " + e.getMessage());
        }
        return null;
    }
    
}
