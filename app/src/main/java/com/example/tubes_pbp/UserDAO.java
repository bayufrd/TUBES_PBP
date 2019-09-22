package com.example.tubes_pbp;

import java.util.List;

public class UserDAO {
    String nama, email, password, nohp;


    public UserDAO(Home_Panel home_panel, List<UserDAO> mItems) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.nohp = nohp;
    }

    public String getNama() {return nama;}
    public void setNama(String nama){
        this.nama= nama;
    }
    public String getEmail() {return email;}
    public void setEmail(String email){
        this.email= email;
    }
    public String getPassword() {return password;}
    public void setPassword(String password){
        this.password= password;
    }
    public String getNohp() {return nohp;}
    public void setNohp(String nohp){
        this.nohp= nohp;
    }


    public UserDAO(String nama, String email, String password, String nohp){
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.nohp = nohp;
    }
}
