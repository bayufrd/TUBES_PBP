package com.example.tubes_pbp;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("akun/tampil")
    Call<List<RegisterDAO>> getRegister();

    @GET("akun/cari/{id}")
    Call<RegisterDAO> getRegister(@Path("id") String id);

    @POST("akun/tambah")
    @FormUrlEncoded
    Call<String>addRegister(@Field("nama")String nama,
                            @Field("email")String email,
                            @Field("password")String password,
                            @Field("nohp")String nphp);
}
