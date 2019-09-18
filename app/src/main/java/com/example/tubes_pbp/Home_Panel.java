package com.example.tubes_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home_Panel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceStata) {

        super.onCreate(savedInstanceStata);
        setContentView(R.layout.panel_home);

        ImageView tambah = (ImageView) findViewById(R.id.imageButtonPluss);
        ImageView masuk = (ImageView) findViewById(R.id.imageButtonMasuk);
        ImageView daftar = (ImageView) findViewById(R.id.imageButtonDaftar);

        masuk.setOnClickListener(new View.OnClickListener() {
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
    public void buttonGambar(View view) {
        Toast.makeText(getApplicationContext(), "Anda belum masuk sebagai User", Toast.LENGTH_LONG).show();
    }
}
