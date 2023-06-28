package com.example.mountainapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DisplayRankings extends AppCompatActivity {

    TextView textView;
    MountainList mountainApp = MountainList.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayrankings);

       textView = findViewById(R.id.displayRankings);

       List<MountainPeak> mountainList = mountainApp.getMountainList();

        StringBuilder stringBuilder = new StringBuilder();
        if (mountainList != null && !mountainList.isEmpty())  {

            List<MountainPeak> listHighestPeaks = mountainList.stream()
                    .sorted(Comparator.comparingInt(MountainPeak::getHeight).reversed())
                    .limit(3)
                    .collect(Collectors.toList());


            for (MountainPeak peak : listHighestPeaks) {

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

        textView.setText(stringBuilder.toString());












        Button back = findViewById(R.id.back);
        back.setOnClickListener(e -> {
            Intent intent = new Intent(DisplayRankings.this, MainActivity.class);
            startActivity(intent);
        });


    }

}
