package com.example.tubes_pbp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tubes_pbp.api.ApiRequestBiodata;
import com.example.tubes_pbp.api.Retroserver;
import com.example.tubes_pbp.model.ResponsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditSapi_Panel extends Home_Panel{
    Button btnHapus;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceStata) {

        super.onCreate(savedInstanceStata);
        setContentView(R.layout.panel_edit_sapi);

        Intent data = getIntent();
        final String iddata = data.getStringExtra("id");
        if(iddata != null)
        {
            btnHapus.setVisibility(View.VISIBLE);
        }


        pd = new ProgressDialog(this);
        btnHapus=(Button) findViewById(R.id.btnHapus);
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setMessage("Loading Hapus ...");
                pd.setCancelable(false);
                pd.show();

                ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
                Call<ResponsModel> del = api.deleteData(iddata);
                del.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("Retro","onResponse");
                        Toast.makeText(EditSapi_Panel.this, response.body().getPesan(),Toast.LENGTH_SHORT).show();
                        Intent gotampil = new Intent(EditSapi_Panel.this, HomeAfter_Panel.class);
                        startActivity(gotampil);
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("Retro", "onFailure");
                    }
                });
            }
        });
    }
}
