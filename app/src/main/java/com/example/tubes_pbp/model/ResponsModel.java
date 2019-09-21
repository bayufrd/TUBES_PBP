package com.example.tubes_pbp.model;

import com.example.tubes_pbp.SapiDAO;

import java.util.List;

public class ResponsModel {

    String kode, pesan;
    List<SapiDAO> result;

    public List<SapiDAO> getResult() {
        return result;
    }

    public void setResult(List<SapiDAO> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode){
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan){
        this.pesan = pesan;
    }
}
