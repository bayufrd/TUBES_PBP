package com.example.tubes_pbp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tubes_pbp.api.ApiRequestBiodata;
import com.example.tubes_pbp.api.Retroserver;
import com.example.tubes_pbp.model.ResponsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditSapi_Panel extends Home_Panel {

    EditText namapemilik, nohp, berat, warna, umur, harga, lokasi;
    Spinner jenis, jeniskelamin;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceStata) {

        super.onCreate(savedInstanceStata);
        setContentView(R.layout.panel_edit_sapi);

        namapemilik = (EditText) findViewById(R.id.Welcome1);
        nohp = (EditText) findViewById(R.id.edtNohp);
        berat = (EditText) findViewById(R.id.edtBerat);
        warna = (EditText) findViewById(R.id.edtWarna);
        umur = (EditText) findViewById(R.id.edtBerat);
        harga = (EditText) findViewById(R.id.edtHarga);
        lokasi = (EditText) findViewById(R.id.edtLokasi);
        jenis = (Spinner) findViewById(R.id.jenisSapi);
        jeniskelamin = (Spinner) findViewById(R.id.jenisKelamin);
        ImageView tambah = (ImageView) findViewById(R.id.imageButtonUbah);
        ImageView batal = (ImageView) findViewById(R.id.imageButtonHapus);
        pd = new ProgressDialog(this);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickUbah();
            }
        });
        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditSapi_Panel.this, HomeAfter_Panel.class);
                startActivity(intent);
            }
        });

    }

    public void OnClickUbah() {
        if(
                namapemilik.getText().toString().isEmpty() ||
                        nohp.getText().toString().isEmpty() ||
                        berat.getText().toString().isEmpty() ||
                        warna.getText().toString().isEmpty() ||
                        umur.getText().toString().isEmpty() ||
                        harga.getText().toString().isEmpty() ||
                        lokasi.getText().toString().isEmpty() ||
                        jenis.getSelectedItem().toString().isEmpty() ||
                        jeniskelamin.getSelectedItem().toString().isEmpty())

        {
            Toast.makeText(this, "Ada yang belum di isi :(",Toast.LENGTH_SHORT).show();
        }else{
            pd.setMessage("sedang mengirim data ...");
            pd.setCancelable(false);
            pd.show();

            ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
            Call<ResponsModel> SapiDAOCALL = api.updateDataSapi(namapemilik.getText().toString(),
                    nohp.getText().toString(),berat.getText().toString(),warna.getText().toString(),
                    jenis.getSelectedItem().toString(),jeniskelamin.getSelectedItem().toString(),
                    umur.getText().toString(),harga.getText().toString(),lokasi.getText().toString());

            SapiDAOCALL.enqueue(new Callback<ResponsModel>() {

                @Override
                public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                    pd.hide();
                    Log.d("RETRO", "response : "+ response.body().toString());
                    String kode = response.body().getKode();
                    if(kode.equals("1")){
                        Toast.makeText(EditSapi_Panel.this, "Sapi telah ditambah :D",Toast.LENGTH_SHORT).show();
                        startIntent();
                    }else{
                        Toast.makeText(EditSapi_Panel.this,"Sapi gagal ditambah :(",Toast.LENGTH_SHORT).show();
                    }

                }
                @Override
                public  void onFailure(Call<ResponsModel> call, Throwable t){
                    pd.hide();
                    Log.d("RETRO", "Failure : " + "Gagal Menambahkan data sapi :(, cek koneksi");
                    Toast.makeText(EditSapi_Panel.this,"Gagal Mengedit data sapi :(, cek koneksi",Toast.LENGTH_SHORT).show();
                }

            });
        }
    }
    private void startIntent() {
        Intent intent= new Intent(getApplicationContext(), Home_Panel.class);
        startActivity(intent);
    }
}

