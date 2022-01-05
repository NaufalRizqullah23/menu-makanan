package com.example.menu_makanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra("id",-1);

        ArrayList<Food> list = FoodData.getData(getApplicationContext());
        Food food = list.get(id);

        if(food != null){
            TextView judulPan = findViewById(R.id.detail_judul);
            TextView hargaPan = findViewById(R.id.detail_harga);
            TextView descPan = findViewById(R.id.detail_desc);
            ImageView image = findViewById(R.id.detail_image);

            judulPan.setText(food.title);
            hargaPan.setText(String.valueOf(food.price));
            descPan.setText(food.descript);
            image.setImageDrawable(food.gambar);

        }
    }
}