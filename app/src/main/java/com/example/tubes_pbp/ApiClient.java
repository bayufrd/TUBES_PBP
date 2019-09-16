package com.example.tubes_pbp;

public class ApiClient {

    public static final String BASE_URL ="#belum dibuat";
    public static Retrofit retrofit= null;
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
