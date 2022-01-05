package com.example.menu_makanan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Home extends AppCompatActivity{

    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayList<Food> data = FoodData.getData(getApplicationContext());
        database = new Database(getApplicationContext());
//        ArrayList<Food> data = database.getFoods(getApplicationContext());
        FoodData.tambahData(getApplicationContext());
        RecyclerView recyclerView = findViewById(R.id.item_list);
        FoodAdapter adapter = new FoodAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.Logout_menu:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}