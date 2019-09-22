package com.example.tubes_pbp.api;

import com.example.tubes_pbp.UserDAO;
import com.example.tubes_pbp.model.ResponsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRegisterData {
    @GET("userlist.php")
    Call<List<UserDAO>> getUser();

    //@GET("read.php")
    //Call<SapiDAO> getBiodata(@Path("id") String id);

    @POST("register.php")
    @FormUrlEncoded
    Call<ResponsModel> sendUser(@Field("nama") String nama,
                                   @Field("email") String email,
                                   @Field("password") String password,
                                   @Field("nohp") String nohp);
}
