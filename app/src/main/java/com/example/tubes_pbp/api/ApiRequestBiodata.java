package com.example.tubes_pbp.api;

import com.example.tubes_pbp.SapiDAO;
import com.example.tubes_pbp.model.ResponsModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequestBiodata {
    @GET("read.php")
    Call<List<SapiDAO>> getBiodata();

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

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseBody> deleteData(@Field("id") String id);
}
