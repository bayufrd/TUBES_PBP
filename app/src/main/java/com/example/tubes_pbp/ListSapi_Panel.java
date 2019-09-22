package com.example.tubes_pbp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes_pbp.api.ApiRequestBiodata;
import com.example.tubes_pbp.api.Retroserver;
import com.example.tubes_pbp.model.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListSapi_Panel extends HomeAfter_Panel {
    private List<SapiDAO> mListSapi = new ArrayList<>();
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_listsapi);

        mListSapi= new ArrayList<>();
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.panel_listsapi);
        recycleAdapter = new RecycleAdapter(this,mListSapi);
        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycleAdapter);
        setRecycleView();
    }

    private void setRecycleView() {
        ApiRequestBiodata apiService = Retroserver.getClient().create(ApiRequestBiodata.class);
        Call<List<SapiDAO>> SapiDAOCall = apiService.getBiodata();

        SapiDAOCall.enqueue(new Callback<List<SapiDAO>>() {
            @Override
            public void onResponse(Call<List<SapiDAO>> call, Response<List<SapiDAO>> response) {
                mListSapi.addAll(response.body());
                recycleAdapter.notifyDataSetChanged();
                Toast.makeText(ListSapi_Panel.this,"Selamat Datang",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<SapiDAO>> call, Throwable t) {
                Toast.makeText(ListSapi_Panel.this,"Kesalahan Jaringan",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
