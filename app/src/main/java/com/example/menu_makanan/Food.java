package com.example.menu_makanan;

import android.graphics.drawable.Drawable;

public class Food {
    String title;
    String descript;
    int price;
    Drawable gambar;
    int img;

    Food(String title,String descript,int price,Drawable gambar, int img){
        this.title = title;
        this.descript = descript;
        this.price = price;
        this.gambar = gambar;
        this.img = img;
    }
}