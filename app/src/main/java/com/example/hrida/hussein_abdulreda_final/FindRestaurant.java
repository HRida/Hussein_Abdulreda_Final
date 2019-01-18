package com.example.hrida.hussein_abdulreda_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FindRestaurant extends AppCompatActivity {

    private ListView ls;
    private Button btCityLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_restaurant);
        DBHelper db = new DBHelper(this);
        ls = (ListView)findViewById(R.id.ls);
        btCityLocation = (Button)findViewById(R.id.btGetMap);
        ArrayList<Restaurant> Restaurants = db.getRestaurant();
        ls.setAdapter(new ArrayAdapter<Restaurant>(this, android.R.layout.simple_list_item_1, Restaurants));

        btCityLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(FindRestaurant.this, ViewCityLocation.class);
                startActivity(i1);
            }
        });
    }
}
