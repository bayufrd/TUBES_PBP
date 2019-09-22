package com.example.tubes_pbp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeAfter_Panel extends Login_Panel {

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

        pd = new ProgressDialog(this);
        mRecycler = (RecyclerView) findViewById(R.id.panel_listsapi);
        mManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycler.setLayoutManager(mManager);
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
