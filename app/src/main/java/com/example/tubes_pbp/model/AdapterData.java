package com.example.tubes_pbp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes_pbp.R;
import com.example.tubes_pbp.SapiDAO;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    private List<SapiDAO> mList;
    private Context ctx;

    public AdapterData (Context ctx, List<SapiDAO> mList)
    {
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.panel_listsapi,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        SapiDAO dm = mList.get(position);
        holder.namapemilik.setText(dm.getNamapemilik());
        holder.nohp.setText(dm.getNohp());
        holder.berat.setText(dm.getBerat());
        holder.warna.setText(dm.getWarna());
        holder.jenis.setText(dm.getJenis());
        holder.jeniskelamin.setText(dm.getJeniskelamin());
        holder.umur.setText(dm.getUmur());
        holder.harga.setText(dm.getHarga());
        holder.lokasi.setText(dm.getLokasi());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends RecyclerView.ViewHolder{
        TextView namapemilik, nohp, berat, warna, jenis, jeniskelamin, umur, harga, lokasi;
        public HolderData (View view){

            super(view);
            namapemilik = (TextView) view.findViewById(R.id.Bnamapemilik);
            nohp = (TextView) view.findViewById(R.id.Bnohp);
            berat= (TextView) view.findViewById(R.id.Bberat);
            warna = (TextView) view.findViewById(R.id.Bwarna);
            jenis = (TextView) view.findViewById(R.id.Bjenis);
            jeniskelamin= (TextView) view.findViewById(R.id.Bjeniskelamin);
            umur = (TextView) view.findViewById(R.id.Bumur);
            harga= (TextView) view.findViewById(R.id.Bharga);
            lokasi= (TextView) view.findViewById(R.id.Blokasi);

        }
    }
}
