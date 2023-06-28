package com.example.mountainapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DisplayAllTrips extends AppCompatActivity {

    TextView displayTrip;
    MountainList mountainApp = MountainList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayalltrips);

        List<MountainPeak> mountainList = mountainApp.getMountainList();

        displayTrip = findViewById(R.id.displayTrip);


        StringBuilder stringBuilder = new StringBuilder();
        if (mountainList != null && !mountainList.isEmpty())  {
            for (MountainPeak peak : mountainList) {
                stringBuilder.append("ID: ").append(peak.getIdList()).append("\n");
                stringBuilder.append("Name: ").append(peak.getMountainPeak()).append("\n");
                stringBuilder.append("Height: ").append(peak.getHeight()).append("\n");
                stringBuilder.append("Vertical Gain: ").append(peak.getVerticalGain()).append("\n");
                stringBuilder.append("Distance: ").append(peak.getDistance()).append("\n");
                stringBuilder.append("-------------------").append("\n");
            }
        } else {
            stringBuilder.append("The list is empty! \n Go to the mountains!");
            }

            displayTrip.setText(stringBuilder.toString());


            Button back = findViewById(R.id.back);
            back.setOnClickListener(e -> {
                Intent intent = new Intent(DisplayAllTrips.this, MainActivity.class);
                startActivity(intent);
            });


        }


    }

