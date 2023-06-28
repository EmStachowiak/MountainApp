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
        Button gallery = findViewById(R.id.gallery);

        addTrip.setOnClickListener(a -> {
            Intent intent = new Intent(MainActivity.this, AddTrip.class);
            startActivity(intent);
        });


        displayAllTrips.setOnClickListener( a -> {
            List<MountainPeak> mountainList = getIntent().getParcelableArrayListExtra("mountainList");
            Intent intent = new Intent(MainActivity.this, DisplayAllTrips.class);

            //intent.putParcelableArrayListExtra("mountainList", new ArrayList<>(mountainList));
            startActivity(intent);
        });

        displayRankings.setOnClickListener( a -> {
            Intent intent = new Intent(MainActivity.this, DisplayRankings.class);
            startActivity(intent);
        });



        clearList.setOnClickListener( a -> {
            mountainList.clearMountainList();
            Toast.makeText(MainActivity.this,
                    "You cleared the whole list, \nyou have to go to the mountains!", Toast.LENGTH_SHORT).show();
        });







    }



}