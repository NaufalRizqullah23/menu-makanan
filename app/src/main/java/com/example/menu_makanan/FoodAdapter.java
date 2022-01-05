package com.example.menu_makanan;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ListViewAutoScrollHelper;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ListViewHolder> {
    private ArrayList<Food> foodDatas;

    FoodAdapter(ArrayList<Food> list){
        this.foodDatas = list;
    }

    @NonNull
    @Override
    public FoodAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_f,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ListViewHolder holder, int position) {
        Food food = foodDatas.get(position);
        holder.title.setText(food.title);
        holder.price.setText(String.valueOf(food.price));
        holder.gambar.setImageDrawable(food.gambar);

    }

    @Override
    public int getItemCount() {
        return foodDatas.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView gambar;
        public TextView title,price;
        public ListViewHolder(View itemView){
            super(itemView);
            gambar = itemView.findViewById(R.id.food_photo);
            title = itemView.findViewById(R.id.food_title);
            price = itemView.findViewById(R.id.food_cost);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int selected = getLayoutPosition();
            Intent intent = new Intent(view.getContext(),Detail.class);
            intent.putExtra("id",selected);
            view.getContext().startActivity(intent);
        }
    }
}