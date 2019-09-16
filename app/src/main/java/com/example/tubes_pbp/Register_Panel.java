package com.example.tubes_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register_Panel extends Login_Panel{

    private TextView linkLogin;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_register);

        linkLogin = (TextView) findViewById(R.id.linkLogin);
        linkLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i= new Intent(Register_Panel.this, Login_Panel.class);
                startActivity(i);
            }
        });

        btnDaftar = (Button)findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register_Panel.this, Login_Panel.class);
                startActivity(i);
            }
        });
    }
}
