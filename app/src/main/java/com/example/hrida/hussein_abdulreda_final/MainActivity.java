package com.example.hrida.hussein_abdulreda_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spCity, spName;
    private Button btFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spCity = (Spinner)findViewById(R.id.spCity);
        spName = (Spinner)findViewById(R.id.spName);
        btFind = (Button)findViewById(R.id.btFind);

        DBHelper db = new DBHelper(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,db.getName());
        spName.setAdapter(adapter);

        Resto online = new Resto(this);
        online.updateLocation(spCity);

        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Location.City = ((TextView)view).getText().toString();
                Location.Longitute = Resto.AllLocations.get(position).getLon();
                Location.Latitude = Resto.AllLocations.get(position).getLat();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Location.Name = ((TextView)view).getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this, FindRestaurant.class);
                startActivity(i1);
            }
        });
    }
}
