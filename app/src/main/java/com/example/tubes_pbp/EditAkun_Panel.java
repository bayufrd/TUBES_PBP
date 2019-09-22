package com.example.tubes_pbp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tubes_pbp.api.ApiRequestBiodata;
import com.example.tubes_pbp.api.Retroserver;
import com.example.tubes_pbp.model.ResponsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditAkun_Panel extends Home_Panel{
    EditText nama,email,password, nohp;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceStata) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceStata);
        setContentView(R.layout.panel_edit_akun);
        nama = (EditText) findViewById(R.id.edtNama);
        email = (EditText) findViewById(R.id.edtEmail);
        password = (EditText) findViewById(R.id.edtPassword);
        nohp = (EditText) findViewById(R.id.edtNohp);
        Button btn = (Button) findViewById(R.id.buttonUbah);
        pd = new ProgressDialog(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditAkun_Panel.this, Home_Panel.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickUbah();
            }
        });
    }

    public void OnClickUbah() {
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

            ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
            Call<ResponsModel> UserDAOCALL = api.updateData(nama.getText().toString(),
                    email.getText().toString(),password.getText().toString(),nohp.getText().toString());

            UserDAOCALL.enqueue(new Callback<ResponsModel>() {

                @Override
                public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                    Log.d("RETRO", "response : "+ response.body().toString());
                    String kode = response.body().getKode();
                    if(kode.equals("1")){
                        Toast.makeText(EditAkun_Panel.this, "Edit berhasil :D",Toast.LENGTH_SHORT).show();
                        pd.hide();
                        startIntent();
                    }else{
                        Toast.makeText(EditAkun_Panel.this,"Edit User gagal :(",Toast.LENGTH_SHORT).show();
                        pd.hide();
                    }

                }
                @Override
                public  void onFailure(Call<ResponsModel> call, Throwable t){
                    pd.hide();
                    Log.d("RETRO", "Failure : " + "Gagal Mengedit data User :(, cek koneksi");
                    Toast.makeText(EditAkun_Panel.this,"Gagal Mengedit data User :(, cek koneksi",Toast.LENGTH_SHORT).show();
                }

            });
        }
    }
    private void startIntent() {
        Intent intent= new Intent(getApplicationContext(), Home_Panel.class);
        startActivity(intent);
    }
}