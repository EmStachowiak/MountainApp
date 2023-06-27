package com.example.mountainapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTrip = findViewById(R.id.addTrip);
        Button displayAllTrips = findViewById(R.id.displayAllTrips);
        Button displayRankings = findViewById(R.id.displayRankings);
        Button deleteOneTrip = findViewById(R.id.deleteOneTrip);
        Button clearList = findViewById(R.id.clearList);
        Button gallery = findViewById(R.id.gallery);

        addTrip.setOnClickListener(a -> {
            Intent intent = new Intent(MainActivity.this, AddTrip.class);
            startActivity(intent);
        });

        displayAllTrips.setOnClickListener( a -> {
            Intent intent = new Intent(MainActivity.this, DisplayAllTrips.class);
            startActivity(intent);
        });










    }



}