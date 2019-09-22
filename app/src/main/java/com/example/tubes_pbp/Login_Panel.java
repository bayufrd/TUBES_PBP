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

import androidx.appcompat.app.AppCompatActivity;

import com.example.tubes_pbp.Util.SessionManager;
import com.example.tubes_pbp.api.ApiRegisterData;
import com.example.tubes_pbp.api.Retroserver;
import com.example.tubes_pbp.model.ResponsModelUser;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Panel extends AppCompatActivity {
    private EditText edtEmail,edtPassword;
    private Button login;
    private ProgressDialog pd;
    private static final String TAG = Login_Panel.class.getSimpleName();
    private SessionManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_login);

        sm = new SessionManager(Login_Panel.this);
        HashMap<String,String> map = sm.getDetailLogin();
        sm.checkLogin();
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        login = (Button) findViewById(R.id.login);
        pd = new ProgressDialog(Login_Panel.this);
        pd.setMessage("Loading ...");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickDaftar();
            }

            private void OnClickDaftar() {
                {
                    ApiRegisterData Api = Retroserver.getRequestService();
                    pd.show();
                    Call<ResponsModelUser> login = Api.login(edtEmail.getText().toString(),edtPassword.getText().toString());
                    login.enqueue(new Callback<ResponsModelUser>() {
                        @Override
                        public void onResponse(Call<ResponsModelUser> call, Response<ResponsModelUser> response) {
                            pd.dismiss();
                            Log.d(TAG, "response : "+ response.toString());
                            ResponsModelUser res = response.body();
                            List<UserDAO> user = res.getResult();
                            if(res.getKode().equals("1")){
                                sm.storeLogin(user.get(0).getEmail(),user.get(0).getNama());
                                Toast.makeText(Login_Panel.this, "email/password ditemukan! Login sukses!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login_Panel.this, HomeAfter_Panel.class);
                                intent.putExtra("email",user.get(0).getEmail());
                                intent.putExtra("nama",user.get(0).getNama());
                                startActivity(intent);
                            }else
                            {
                                Toast.makeText(Login_Panel.this, "email/password tidak cocok!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponsModelUser> call, Throwable t) {
                            Toast.makeText(Login_Panel.this, "Login gagal! Cek Koneksi", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });



        TextView daftar = (TextView) findViewById(R.id.linkDaftar);

        daftar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Login_Panel.this, Register_Panel.class);
                startActivity(intent);
            }
        });
    }
}
