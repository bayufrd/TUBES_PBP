package com.example.tubes_pbp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes_pbp.Util.SessionManager;
import com.example.tubes_pbp.api.ApiRequestBiodata;
import com.example.tubes_pbp.api.Retroserver;
import com.example.tubes_pbp.model.AdapterData;
import com.example.tubes_pbp.model.ResponsModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAfter_Panel extends Login_Panel {

        TextView nama;
        SessionManager sm;
        private RecyclerView mRecycler;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager mManager;
        private List<SapiDAO> mItems = new ArrayList<>();
        ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceStata) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceStata);
        setContentView(R.layout.panel_home_after);
        sm = new SessionManager(HomeAfter_Panel.this);
        HashMap<String,String> map = sm.getDetailLogin();
        sm.checkLogin();
        nama = (TextView) findViewById(R.id.Welcome);
        Intent data = getIntent();

        nama.setText(map.get(sm.KEY_NAMA));

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

                mAdapter = new AdapterData(HomeAfter_Panel.this,mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });

        ImageView tambah = (ImageView) findViewById(R.id.imageButtonPluss);
        ImageView edit = (ImageView) findViewById(R.id.imageButtonProfil);
        ImageView mysapi = (ImageView) findViewById(R.id.imageButtonSapisaya);

        mysapi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAfter_Panel.this, SapiSaya_Panel.class);
                startActivity(intent);
            }
        });

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAfter_Panel.this, TambahSapi_Panel.class);
                startActivity(intent);
            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAfter_Panel.this, EditAkun_Panel.class);
                startActivity(intent);
            }
        });

       }
}
