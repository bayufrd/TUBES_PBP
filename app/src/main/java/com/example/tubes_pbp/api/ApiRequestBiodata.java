package com.example.tubes_pbp.api;

import com.example.tubes_pbp.model.ResponsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequestBiodata {
    @GET("read.php")
    Call<ResponsModel> getBiodata();

    //@GET("read.php")
    //Call<SapiDAO> getBiodata(@Path("id") String id);

    @POST("insert.php")
    @FormUrlEncoded
    Call<ResponsModel> sendBiodata(@Field("namapemilik") String namapemilik,
                                   @Field("nohp") String nohp,
                                   @Field("berat") String berat,
                                   @Field("warna") String warna,
                                   @Field("jenis") String jenis,
                                   @Field("jeniskelamin") String jeniskelamin,
                                   @Field("umur") String umur,
                                   @Field("harga") String harga,
                                   @Field("lokasi") String lokasi);

    @POST("update.php")
    @FormUrlEncoded
    Call<ResponsModel> updateData(@Field("nama") String nama,
                                  @Field("email") String email,
                                  @Field("password") String password,
                                  @Field("nohp") String nohp);

    @POST("update.php")
    @FormUrlEncoded
    Call<ResponsModel> updateDataSapi(@Field("namapemilik") String namapemilik,
                                   @Field("nohp") String nohp,
                                   @Field("berat") String berat,
                                   @Field("warna") String warna,
                                   @Field("jenis") String jenis,
                                   @Field("jeniskelamin") String jeniskelamin,
                                   @Field("umur") String umur,
                                   @Field("harga") String harga,
                                   @Field("lokasi") String lokasi);
}
