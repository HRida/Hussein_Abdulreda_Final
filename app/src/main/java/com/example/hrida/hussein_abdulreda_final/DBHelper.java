package com.example.hrida.hussein_abdulreda_final;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Restaurant.db";
    public static final int DATABASE_VERSION = 1;
    // define constants for students table
    public static final String Restaurant_TABLE_NAME = "Restaurant";
    public static final String Restaurant_COLUMN_PHONE = "phone";
    public static final String Restaurant_COLUMN_NAME = "name";
    public static final String Restaurant_COLUMN_EMAIL = "email";
    public static final String Restaurant_COLUMN_CITY = "city";
    public String rest;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table students
        db.execSQL("create table " + Restaurant_TABLE_NAME + " (" +
                Restaurant_COLUMN_PHONE + " char(8) primary key, " +
                Restaurant_COLUMN_NAME + " varchar(50) not null, " +
                Restaurant_COLUMN_EMAIL + " varchar(100) not null, " +
                Restaurant_COLUMN_CITY + " varchar(100) not null)"
        );

        // insert some initial data into table courses
        db.execSQL("insert into " + Restaurant_TABLE_NAME + " values ('70606070', 'MCDonalds', 'MCDonalds_Baabda@mobile.com', 'Beirut')");
        db.execSQL("insert into " + Restaurant_TABLE_NAME + " values ('71989987', 'BurgerKing', 'BurgerKing_Joonieh@mobile.com', 'Tripoli')");
        db.execSQL("insert into " + Restaurant_TABLE_NAME + " values ('03885554', 'PizzaHut', 'PizzaHut_Saida@mobile.com', 'Beirut')");
        db.execSQL("insert into " + Restaurant_TABLE_NAME + " values ('71900801', 'MCDonalds', 'MCDonalds_Hamra@mobile.com', 'Beirut')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Restaurant_TABLE_NAME);
        onCreate(db);
    }

    //This is not mentioned in the exam to be added
    public ArrayList<String> getName() {
        ArrayList<String> array_name = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select name from " + Restaurant_TABLE_NAME , null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_name.add(res.getString(res.getColumnIndex(Restaurant_COLUMN_NAME)));
            res.moveToNext();
        }
        db.close();
        return array_name;
    }

    public ArrayList<Restaurant> getRestaurant() {
        ArrayList<Restaurant> array_list = new ArrayList<Restaurant>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from " + Restaurant_TABLE_NAME + " where city = '" + Location.City + "' and name = '" + Location.Name + "'", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(new Restaurant(res.getString(0), res.getString(1),res.getString(2),res.getString(3)));
            res.moveToNext();
        }
        db.close();
        return array_list;
    }
}


