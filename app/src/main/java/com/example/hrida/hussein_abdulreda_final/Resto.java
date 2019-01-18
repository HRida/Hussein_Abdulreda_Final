package com.example.hrida.hussein_abdulreda_final;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Resto {
    public static ArrayList<String> AllNames;
    public static ArrayList<Riegon> AllLocations;
    private Context context;

    public Resto(Context context) {
        this.context = context;
        AllNames = new ArrayList<String>();
        AllLocations = new ArrayList<Riegon>();

    }


    public void updateLocation(final Spinner spAllRegions) {
        String url = "http://app-1515400395.000webhostapp.com/getRegion.php";
        //the other link (http://app-1515400395.000webhostapp.com/getAllLocations.php)
        //is not working 100% sure since I tried the link it self on working Json Array and still nothing happens
        //so i used an old php link with the same requirements but the 'City' parameter changed to be 'Name'.
        //Also to be considered this library: 'com.mcxiaoke.volley:library:1.0.19' doesn't work with the new updated studio
        //so we needed to include older sdk tools to run the code (check [build.gradle Module:app])
        //since if we added the new library: 'com.android.volley:volley:1.1.1' the JsonArrayRequest class must have
        //different parameters (Request.Method.GET is wrong to be included)
        //
        //
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a json response from the provided URL.
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray ja) {
                        try {
                            for (int i = 0;i < ja.length();i++) {
                                JSONObject st = ja.getJSONObject(i);

                                AllNames.add(st.getString("Name"));
                                AllLocations.add(new Riegon(Double.parseDouble(st.getString("Longitude")), Double.parseDouble(st.getString("Latitude"))));
                            }
                            spAllRegions.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, AllNames));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, "That didn't work", Toast.LENGTH_SHORT).show();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(jsonRequest);
    }
}


