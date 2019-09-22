package com.example.tubes_pbp.api;

import com.example.tubes_pbp.model.ResponsModelUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiRegisterData {

    //@GET("api/{email}/{password}")
    //Call<Login> authenticate(@Path("email") String email, @Path("password") String password);
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponsModelUser> loginRequest(@Field("email") String email,
                                    @Field("password") String password);
    //@GET("read.php")
    //Call<SapiDAO> getBiodata(@Path("id") String id);

    @POST("register.php")
    @FormUrlEncoded
    Call<ResponsModelUser> sendUser(@Field("nama") String nama,
                                   @Field("email") String email,
                                   @Field("password") String password,
                                   @Field("nohp") String nohp);
}
