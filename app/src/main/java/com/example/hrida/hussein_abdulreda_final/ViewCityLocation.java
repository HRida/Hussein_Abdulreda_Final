package com.example.hrida.hussein_abdulreda_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewCityLocation extends AppCompatActivity {

    private Button btClose;
    private TextView text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_city_location);

        btClose = (Button)findViewById(R.id.btClose);
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);

        text1.setText(Location.City);

        String stLongitute = String.valueOf(Location.Longitute);
        String stLatitude = String.valueOf(Location.Latitude);

        text2.setText(stLongitute + "      " + stLatitude);

        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
