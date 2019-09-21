package com.example.tubes_pbp;

import java.util.List;

public class SapiDAO {
    String namapemilik,nohp,berat,warna,jenis,jeniskelamin,umur,harga,lokasi;


    public SapiDAO(HomeAfter_Panel homeAfter_panel, List<SapiDAO> mItems) {
        this.namapemilik = namapemilik;
        this.nohp = nohp;
        this.berat= berat;
        this.warna = warna;
        this.jenis = jenis;
        this.jeniskelamin = jeniskelamin;
        this.umur = umur;
        this.harga = harga;
        this.lokasi = lokasi;
    }

    public String getNamapemilik() {return namapemilik;}
    public void setNamapemilik(String namapemilik){
        this.namapemilik = namapemilik;
    }
    public String getNohp() {return nohp;}
    public void setNohp(String nohp){
        this.nohp = nohp;
    }
    public String getBerat() {return berat;}
    public void setBerat(String berat){
        this.berat = berat;
    }
    public String getWarna() {return warna;}
    public void setWarna(String warna){
        this.warna = warna;
    }
    public String getJenis() {return jenis;}
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    public String getJeniskelamin() {return jeniskelamin;}
    public void setJeniskelamin(String jeniskelamin){
        this.jeniskelamin = jeniskelamin;
    }
    public String getUmur() {return umur;}
    public void setUmur(String umur){
        this.umur = umur;
    }
    public String getHarga() {return harga;}
    public void setHarga(String harga){
        this.harga = harga;
    }
    public String getLokasi() {return lokasi;}
    public void setLokasi(String lokasi){
        this.lokasi = lokasi;
    }

    public SapiDAO(String namapemilik,String nohp,String berat,String warna,String jenis,String jeniskelamin,
                      String umur, String harga, String lokasi){
        this.namapemilik = namapemilik;
        this.nohp = nohp;
        this.berat= berat;
        this.warna = warna;
        this.jenis = jenis;
        this.jeniskelamin = jeniskelamin;
        this.umur = umur;
        this.harga = harga;
        this.lokasi = lokasi;
    }
}
