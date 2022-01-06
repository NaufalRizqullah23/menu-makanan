package com.example.menu_makanan;

import android.content.Context;

import java.util.ArrayList;

public class FoodData{
    public static ArrayList<Food> getData(Context context){
        ArrayList<Food> list = new ArrayList<Food>();
        list.add(new Food("Cheesecake","Cheesecake adalah kue yang biasanya dimakan sebagai hidangan penutup, dibuat dengan mencampurkan keju yang bertekstur lembut, telur, susu, dan gula.",35000, context.getDrawable(R.drawable.cheesecake),R.drawable.cheesecake));
        list.add(new Food("Cireng","Makanan ini merupakan salah satu jajanan yang berbahan dasar tepung kanji. Cireng berasal dari kata 'aci' yang 'digoreng'.",2000,context.getDrawable(R.drawable.cireng),R.drawable.cireng));
        list.add(new Food("Donut","Donat adalah makanan yang digoreng, dibuat dari adonan tepung terigu, gula, telur, dan mentega",5000,context.getDrawable(R.drawable.donut),R.drawable.donut));
        list.add(new Food("Mie Goreng","Mie Goreng berarti 'Mie yang digoreng' adalah makanan yang berasal dari Indonesia yang populer dan juga digemari di Malaysia, dan Singapura. Mie Goreng juga mirip dengan Yakisoba dari Jepang",8000,context.getDrawable(R.drawable.mie_goreng),R.drawable.mie_goreng));
        list.add(new Food("Kopi Hitam","Minuman yang berasal dari bijij tumbuhan ini bisa disajikan dalam versi dingin maupun panas, bisa dicampur dengan berbagai bahan lain seperti susu dan gula, bisa disajikan begitu saja hanya perlu diseduh",7500,context.getDrawable(R.drawable.kopi_hitam),R.drawable.kopi_hitam));
        list.add(new Food("Batagor","Dibuat dari tahu yang dilebutkan dan diisi dengan adonan berbahan ikan tenggiri dan tepung tapioka lalu dibentuk menyerupai bola yang digoreng dalam minyak panas selama beberapa menit hingga matang",10000,context.getDrawable(R.drawable.batagor),R.drawable.batagor));
        list.add(new Food("Black Salad","Kandungan Charcoal yang memiliki fungsi yang baik untuk tubuh kita, antara lain mencegah kembung dan menurunkan kolesterol",13000,context.getDrawable(R.drawable.black_salad),R.drawable.black_salad));
        list.add(new Food("Cappuccino","Cappuccino adalah minuman khas Italia yang dibuat dari espresso dan susu.",8000,context.getDrawable(R.drawable.cappuchino),R.drawable.cappuchino));
        list.add(new Food("Nasi Goreng","Nasi Goreng adalah suatu makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng atau margarin, biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu - bumbu lainnya, seperti telur, ayam, dan kerupuk",13000,context.getDrawable(R.drawable.nasigoreng),R.drawable.nasigoreng));
        list.add(new Food("Sparklin Tea","Segarnya soda berpadu dengan lemon dan daun mint. Cocok dinikmati saat siang hari",9000,context.getDrawable(R.drawable.sparkling_tea),R.drawable.sparkling_tea));
        return list;
    }
    
    public static void tambahData(Context context){
        Database database = new Database(context);
        ArrayList<Food> foods = getData(context);

        for (Food food:foods) {
            database.InsertData(food);
        }
    }
}