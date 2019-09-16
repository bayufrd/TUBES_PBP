import com.example.tubes_pbp.apihelper.BaseApiService;
import com.example.tubes_pbp.apihelper.RetrofitClient;

//package com.example.tubes_pbp.apihelper;

public class UtilsApi {
    // bayufarid.000webhostapp.com ini adalah localhost.
    public static final String BASE_URL_API = "http://bayufarid.000webhostapp.com/tubespbp/db_akun";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }

}
