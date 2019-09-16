package com.example.tubes_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeAfter_Panel extends Home_Panel {

    private TextView btnTambah;
    private Button btnEditAkun;

    @Override
    protected void onCreate(Bundle savedInstanceStata) {

        super.onCreate(savedInstanceStata);
        setContentView(R.layout.panel_home_after);

        btnTambah = (TextView) findViewById(R.id.btnTambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAfter_Panel.this, TambahSapi_Panel.class);
                startActivity(i);
            }
        });

        btnEditAkun = (Button) findViewById(R.id.btnEditAkun);
        btnEditAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAfter_Panel.this, EditAkun_Panel.class);
                startActivity(i);
            }
        });
    }
}
