package com.example.tubes_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Home_Panel extends AppCompatActivity {

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_home);

        mRecycler = (RecyclerView) findViewById(R.id.RecyclerTemp);

        ImageView login = (ImageView) findViewById(R.id.imageButtonMasuk);
        ImageView daftar = (ImageView) findViewById(R.id.imageButtonDaftar);
        TextView guest = (TextView) findViewById(R.id.linkHomeAfter);

        guest.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Home_Panel.this, HomeAfter_Panel.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Panel.this, Login_Panel.class);
                startActivity(intent);
            }
        });
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Panel.this, Register_Panel.class);
                startActivity(intent);
            }
        });

    }
}
