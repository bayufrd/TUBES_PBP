package com.example.tubes_pbp.model;

import com.example.tubes_pbp.UserDAO;

import java.util.List;

public class ResponsModelUser {
    String kode,pesan;

    List<UserDAO> result;

    public List<UserDAO> getResult() {
        return result;
    }

    public void setResult(List<UserDAO> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
