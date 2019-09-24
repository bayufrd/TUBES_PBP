package com.example.tubes_pbp;

import android.os.Bundle;

public class EditSapi_Panel extends Home_Panel {
    //Button btnEdit;
    //EditText namapemilik, nohp, berat, warna, umur, harga, lokasi;
    //Spinner jenis, jeniskelamin;
    //ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_edit_sapi);
/*
        nohp = (EditText) findViewById(R.id.edtNohp);
        berat = (EditText) findViewById(R.id.edtBerat);
        warna = (EditText) findViewById(R.id.edtWarna);
        umur = (EditText) findViewById(R.id.edtBerat);
        harga = (EditText) findViewById(R.id.edtHarga);
        lokasi = (EditText) findViewById(R.id.edtLokasi);
        jenis = (Spinner) findViewById(R.id.jenisSapi);
        jeniskelamin = (Spinner) findViewById(R.id.jenisKelamin);
        ImageView batal = (ImageView) findViewById(R.id.imageButtonBatal);
        pd = new ProgressDialog(this);


        btnEdit = (Button) findViewById(R.id.imageButtonUbah);


        Intent data = getIntent();
        final String iddata = data.getStringExtra("namapemilik");
        if(iddata !=null){
            btnEdit.setVisibility(View.VISIBLE );
            namapemilik.setText(data.getStringExtra("namapemilik"));
            nohp.setText(data.getStringExtra("nohp"));
            berat.setText(data.getStringExtra("berat"));
            warna.setText(data.getStringExtra("warna"));
            umur.setText(data.getStringExtra("umur"));
            harga.setText(data.getStringExtra("harga"));
            lokasi.setText(data.getStringExtra("lokasi"));
            // jenis.setDropDownVerticalOffset("jenis");
            // jeniskelamin.setOnItemSelectedListener(this);
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setMessage("update ....");
                pd.setCancelable(false);
                pd.show();
                ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
                Call<ResponsModel> updateData = api.updateData(iddata, namapemilik.getText().toString(),
                        nohp.getText().toString(),berat.getText().toString(),warna.getText().toString(),
                        jenis.getSelectedItem().toString(),jeniskelamin.getSelectedItem().toString(),
                        umur.getText().toString(),harga.getText().toString(),lokasi.getText().toString());
                updateData.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("Retro", "Response");
                        Toast.makeText(EditSapi_Panel.this,response.body().getPesan(),Toast.LENGTH_SHORT).show();
                        pd.hide();
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        Log.d("Retro", "OnFailure");
                        pd.hide();
                    }
                });
            }
        }); */
    }
}

