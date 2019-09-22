package com.example.tubes_pbp;

import android.os.Bundle;
import android.view.WindowManager;

public class EditAkun_Panel extends Home_Panel{
    @Override
    protected void onCreate(Bundle savedInstanceStata) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceStata);
        setContentView(R.layout.panel_edit_akun);}
}
