package com.example.tubes_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home_Panel extends AppCompatActivity {
    private TextView linkLogin;
    private TextView linkRegister;

    @Override
    protected void onCreate(Bundle savedInstanceStata) {

        super.onCreate(savedInstanceStata);
        setContentView(R.layout.panel_home);

        linkLogin = (TextView) findViewById(R.id.linkLogin);
        linkLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i= new Intent(Home_Panel.this, Login_Panel.class);
                startActivity(i);
            }
        });

        linkRegister = (TextView) findViewById(R.id.linkRegister);
        linkRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent j= new Intent(Home_Panel.this, Register_Panel.class);
                startActivity(j);
            }
        });
    }
}
