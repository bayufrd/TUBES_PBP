package com.example.tubes_pbp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retroserver {

    //server1 https://bayufarid.000webhostapp.com/tubespbp/
    //server2 http://bayufarid.dx.am/tubespbp/

    private static final String base_url = "http://bayufarid.dx.am/tubespbp/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static ApiRegisterData getRequestService() { return getClient().create(ApiRegisterData.class);}
}
