package com.example.tubes_pbp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes_pbp.R;
import com.example.tubes_pbp.SapiDAO;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>{
    private Context context;
    private List<SapiDAO> result;

    public RecycleAdapter(Context context, List<SapiDAO> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.panel_listsapi, parent,false);
        final MyViewHolder holder =new MyViewHolder(itemView);
        return holder;
    }
    public void onBindViewHolder (@NonNull MyViewHolder holder, int position){
        SapiDAO SapiDAO=result.get(position);
        holder.namapemilik.setText("Nama Pemilik\t: "+SapiDAO.getNamapemilik()+"\n");
        holder.nohp.setText("No. Telp\t: "+SapiDAO.getNohp()+"\n");
        holder.berat.setText("Berat\t: "+SapiDAO.getBerat()+" KG\n");
        holder.warna.setText("Warna\t: "+SapiDAO.getWarna()+"\n");
        holder.jenis.setText("Jenis\t: "+SapiDAO.getJenis()+"\n");
        holder.jeniskelamin.setText("Jenis Kelamin\t: "+SapiDAO.getJeniskelamin()+"\n");
        holder.umur.setText("Umur\t: "+SapiDAO.getUmur()+"\n");
        holder.harga.setText("Harga\t: Rp. "+SapiDAO.getHarga()+",-\n");
        holder.lokasi.setText("Lokasi\t: "+SapiDAO.getLokasi()+"\n");


        holder.mParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Oh You touch Me",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public int getItemCount() {
        return result.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView namapemilik, nohp, berat, warna, jenis, jeniskelamin, umur, harga, lokasi;
        private LinearLayout mParent;

        public MyViewHolder (@NonNull View itemView)
        {
            super(itemView);
            namapemilik=itemView.findViewById(R.id.Bnamapemilik);
            nohp=itemView.findViewById(R.id.Bnohp);
            berat=itemView.findViewById(R.id.Bberat);
            warna=itemView.findViewById(R.id.Bwarna);
            jenis=itemView.findViewById(R.id.Bjenis);
            jeniskelamin=itemView.findViewById(R.id.Bjeniskelamin);
            umur=itemView.findViewById(R.id.Bumur);
            harga=itemView.findViewById(R.id.Bharga);
            lokasi=itemView.findViewById(R.id.Blokasi);

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context,"Bentar belum ku buat",Toast.LENGTH_SHORT).show();
        }
    }
}
