package com.example.tubes_pbp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tubes_pbp.api.ApiRegisterData;
import com.example.tubes_pbp.api.Retroserver;
import com.example.tubes_pbp.model.ResponsModelUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_Panel extends Home_Panel {

    EditText nama,email,password, nohp;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_register);
        nama = (EditText) findViewById(R.id.Welcome);
        email = (EditText) findViewById(R.id.edtEmail);
        password = (EditText) findViewById(R.id.edtPassword);
        nohp = (EditText) findViewById(R.id.edtNohp);
        Button btn = (Button) findViewById(R.id.ButtonUbah);
        TextView linkLogin = (TextView) findViewById(R.id.linkLogin);
        pd = new ProgressDialog(this);

        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_Panel.this, Login_Panel.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickRegister();
            }
        });
    }
    public void OnClickRegister() {
        if(
                nama.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() ||
                        password.getText().toString().isEmpty() ||
                        nohp.getText().toString().isEmpty())

        {
            Toast.makeText(this, "Ada yang belum di isi :(",Toast.LENGTH_SHORT).show();
        }else{
            pd.setMessage("sedang mengirim data ...");
            pd.setCancelable(false);
            pd.show();

            ApiRegisterData api = Retroserver.getClient().create(ApiRegisterData.class);
            Call<ResponsModelUser> UserDAOCALL = api.sendUser(nama.getText().toString(),
                    email.getText().toString(),password.getText().toString(),nohp.getText().toString());

            UserDAOCALL.enqueue(new Callback<ResponsModelUser>() {

                @Override
                public void onResponse(Call<ResponsModelUser> call, Response<ResponsModelUser> response) {
                    Log.d("RETRO", "response : "+ response.body().toString());
                    String kode = response.body().getKode();
                    if(kode.equals("1")){
                        Toast.makeText(Register_Panel.this, "Register berhasil :D",Toast.LENGTH_SHORT).show();
                        pd.hide();
                        startIntent();
                    }else{
                        Toast.makeText(Register_Panel.this,"User gagal ditambah :(",Toast.LENGTH_SHORT).show();
                        pd.hide();
                    }

                }
                @Override
                public  void onFailure(Call<ResponsModelUser> call, Throwable t){
                    pd.hide();
                    Log.d("RETRO", "Failure : " + "Gagal Menambahkan data User :(, cek koneksi");
                    Toast.makeText(Register_Panel.this,"Gagal Menambahkan data User :(, cek koneksi",Toast.LENGTH_SHORT).show();
                }

            });
        }
    }
    private void startIntent() {
        Intent intent= new Intent(getApplicationContext(), HomeAfter_Panel.class);
        startActivity(intent);
    }
}
