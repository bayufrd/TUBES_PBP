package com.example.tubes_pbp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes_pbp.api.ApiRequestBiodata;
import com.example.tubes_pbp.api.Retroserver;
import com.example.tubes_pbp.model.AdapterSapiSaya;
import com.example.tubes_pbp.model.ResponsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SapiSaya_Panel extends AppCompatActivity {

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<SapiDAO> mItems = new ArrayList<>();
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_sapisaya);
        pd = new ProgressDialog(this);
        mRecycler = (RecyclerView) findViewById(R.id.RecyclerTemp);
        mManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();

        ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
        Call<ResponsModel> getdata = api.getBiodata();
        getdata.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                pd.hide();
                Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                mItems = response.body().getResult();

                mAdapter = new AdapterSapiSaya(SapiSaya_Panel.this,mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });

        ImageView batal = (ImageView) findViewById(R.id.imageButtonBatal);

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SapiSaya_Panel.this, HomeAfter_Panel.class);
                startActivity(intent);
            }
        });
    }
}
