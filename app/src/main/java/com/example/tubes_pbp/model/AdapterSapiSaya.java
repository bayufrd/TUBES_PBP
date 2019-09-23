package com.example.tubes_pbp.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubes_pbp.EditSapi_Panel;
import com.example.tubes_pbp.R;
import com.example.tubes_pbp.SapiDAO;

import java.util.List;

public class AdapterSapiSaya extends RecyclerView.Adapter<AdapterSapiSaya.HolderData> {

    private List<SapiDAO> mList;
    private Context ctx;

    public AdapterSapiSaya (Context ctx, List<SapiDAO> mList)
    {
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AdapterSapiSaya.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.panel_listsapi,parent,false);
        AdapterSapiSaya.HolderData holder = new AdapterSapiSaya.HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSapiSaya.HolderData holder, int position) {
        SapiDAO dm = mList.get(position);
        holder.namapemilik.setText("Nama Pemilik\t: "+dm.getNamapemilik()+"\n");
        holder.nohp.setText("No. Telp\t: "+dm.getNohp()+"\n");
        holder.berat.setText("Berat\t: "+dm.getBerat()+" KG\n");
        holder.warna.setText("Warna\t: "+dm.getWarna()+"\n");
        holder.jenis.setText("Jenis\t: "+dm.getJenis()+"\n");
        holder.jeniskelamin.setText("Jenis Kelamin\t: "+dm.getJeniskelamin()+"\n");
        holder.umur.setText("Umur\t: "+dm.getUmur()+"\n");
        holder.harga.setText("Harga\t: Rp. "+dm.getHarga()+"\n");
        holder.lokasi.setText("Lokasi\t: "+dm.getLokasi()+"\n");

        holder.mParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Edit Sapi Data",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), EditSapi_Panel.class);
                ctx.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends RecyclerView.ViewHolder{
        TextView namapemilik, nohp, berat, warna, jenis, jeniskelamin, umur, harga, lokasi;
        LinearLayout mParent;
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
            mParent=itemView.findViewById(R.id.Parent);
        }
    }
}
