package com.example.menu_makanan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "dbfood";
    private static final String TABLE_NAME = "menu";

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String DESCRIPT = "descript";
    private static final String PRICE = "price";
    private static final String IMG = "image";


    public Database(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_FOODS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT," + DESCRIPT + " TEXT," + PRICE + " INTEGER,"
                + IMG + " INTEGER" + ")";
        sqLiteDatabase.execSQL(CREATE_FOODS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void InsertData (Food food){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, food.title);
        values.put(DESCRIPT, food.descript);
        values.put(PRICE, food.price);
        values.put(IMG, food.img);


        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public ArrayList<Food> getFoods(Context context) {

        ArrayList<Food> foodList = new ArrayList<Food>();
        // Select All Query
        String query = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        int i = 0;
        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(1);
                String descript = cursor.getString(2);
                int price = cursor.getInt(3);
                Drawable image = context.getDrawable(cursor.getInt(4));
                int imgInt = cursor.getInt(4);

                Food food = new Food(title,descript,price,image,imgInt);

                foodList.add(food);
                i++;
            } while (cursor.moveToNext());
        }

        // return food list
        return foodList;
    }
}
