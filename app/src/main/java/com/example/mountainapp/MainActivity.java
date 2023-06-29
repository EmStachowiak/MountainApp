package com.example.mountainapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    MountainList mountainList = MountainList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTrip = findViewById(R.id.addTrip);
        Button displayAllTrips = findViewById(R.id.displayAllTrips);
        Button displayRankings = findViewById(R.id.displayRankings);
        Button deleteOneTrip = findViewById(R.id.deleteOneTrip);
        Button clearList = findViewById(R.id.clearList);
        Button edit = findViewById(R.id.edit);

        addTrip.setOnClickListener(a -> {
            Intent intent = new Intent(MainActivity.this, AddTrip.class);
            startActivity(intent);
        });

        edit.setOnClickListener( a -> {
            Intent intent = new Intent(MainActivity.this, EditTrip.class);
            startActivity(intent);
        });


        displayAllTrips.setOnClickListener( a -> {
            List<MountainPeak> mountainList = getIntent().getParcelableArrayListExtra("mountainList");
            Intent intent = new Intent(MainActivity.this, DisplayAllTrips.class);
            startActivity(intent);
        });

        displayRankings.setOnClickListener( a -> {
            Intent intent = new Intent(MainActivity.this, DisplayRankings.class);
            startActivity(intent);
        });



        deleteOneTrip.setOnClickListener( a -> {
            Intent intent = new Intent(MainActivity.this, DeleteOneTrip.class);
            startActivity(intent);
        });


        clearList.setOnClickListener( a -> {
            Intent intent = new Intent(MainActivity.this, ClearList.class);
            startActivity(intent);
        });




    }



}