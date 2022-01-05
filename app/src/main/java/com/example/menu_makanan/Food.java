package com.example.menu_makanan;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;

import java.io.File;

public class Food {
    String title;
    String descript;
    int price;
    Drawable gambar;

    Food(String title,String descript,int price,Drawable gambar){
        this.title = title;
        this.descript = descript;
        this.price = price;
        this.gambar = gambar;
    }
}