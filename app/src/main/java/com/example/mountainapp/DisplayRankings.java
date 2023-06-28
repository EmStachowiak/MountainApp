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

        int sumVerticalGain = mountainList.stream().collect(Collectors.summingInt(MountainPeak::getVerticalGain));
        double sumDistance = mountainList.stream().collect(Collectors.summingDouble(s -> s.getDistance()));



        StringBuilder builderDiff = new StringBuilder();
        if (mountainList != null && !mountainList.isEmpty())  {

            List<MountainPeak> mostDifficultTrip  = mountainList.stream()
                    .sorted(Comparator.comparingInt(MountainPeak::getVerticalGain)
                            .thenComparingDouble(MountainPeak::getDistance)
                            .thenComparingInt(MountainPeak::getHeight)
                            .reversed())
                    .limit(1)
                    .collect(Collectors.toList());


            for (MountainPeak peak : mostDifficultTrip) {

                builderDiff.append("ID: ").append(peak.getIdList()).append("\n");
                builderDiff.append("Name: ").append(peak.getMountainPeak()).append("\n");
                builderDiff.append("Height: ").append(peak.getHeight()).append("\n");
                builderDiff.append("Vertical Gain: ").append(peak.getVerticalGain()).append("\n");
                builderDiff.append("Distance: ").append(peak.getDistance()).append("\n");
                builderDiff.append("-------------------").append("\n");

            }
        }




        StringBuilder builderHighest = new StringBuilder();
        if (mountainList != null && !mountainList.isEmpty())  {

            List<MountainPeak> listHighestPeaks = mountainList.stream()
                    .sorted(Comparator.comparingInt(MountainPeak::getHeight).reversed())
                    .limit(3)
                    .collect(Collectors.toList());


            for (MountainPeak peak : listHighestPeaks) {

                builderHighest.append("ID: ").append(peak.getIdList()).append("\n");
                builderHighest.append("Name: ").append(peak.getMountainPeak()).append("\n");
                builderHighest.append("Height: ").append(peak.getHeight()).append("\n");
                builderHighest.append("Vertical Gain: ").append(peak.getVerticalGain()).append("\n");
                builderHighest.append("Distance: ").append(peak.getDistance()).append("\n");
                builderHighest.append("-------------------").append("\n");

            }
        }


        StringBuilder builderVertGains = new StringBuilder();
        if (mountainList != null && !mountainList.isEmpty())  {

            List<MountainPeak> listGreatestVerticalGains  = mountainList.stream()
                    .sorted(Comparator.comparingInt(MountainPeak::getVerticalGain).reversed())
                    .limit(3)
                    .collect(Collectors.toList());


            for (MountainPeak peak : listGreatestVerticalGains ) {

                builderVertGains.append("ID: ").append(peak.getIdList()).append("\n");
                builderVertGains.append("Name: ").append(peak.getMountainPeak()).append("\n");
                builderVertGains.append("Height: ").append(peak.getHeight()).append("\n");
                builderVertGains.append("Vertical Gain: ").append(peak.getVerticalGain()).append("\n");
                builderVertGains.append("Distance: ").append(peak.getDistance()).append("\n");
                builderVertGains.append("-------------------").append("\n");

            }
        }




        StringBuilder builderDistances = new StringBuilder();
        if (mountainList != null && !mountainList.isEmpty())  {

            List<MountainPeak> listGreatestDistances  = mountainList.stream()
                    .sorted(Comparator.comparingDouble(MountainPeak::getDistance).reversed())
                    .limit(3)
                    .collect(Collectors.toList());


            for (MountainPeak peak : listGreatestDistances ) {

                builderDistances.append("ID: ").append(peak.getIdList()).append("\n");
                builderDistances.append("Name: ").append(peak.getMountainPeak()).append("\n");
                builderDistances.append("Height: ").append(peak.getHeight()).append("\n");
                builderDistances.append("Vertical Gain: ").append(peak.getVerticalGain()).append("\n");
                builderDistances.append("Distance: ").append(peak.getDistance()).append("\n");
                builderDistances.append("-------------------").append("\n");

            }
        }







        textView.setText("The number of peaks climbed: " +  MountainPeak.getNumOfTrips() + "\n"
                + "The sum of the mountain elevations covered: " + sumVerticalGain + " meters" + "\n"
                + "The sum of the kilometers traveled: " + (String.format("%.2f", sumDistance) + " kilometers") + "\n"
                + "---------------------------------------------------------------------" + "\n"+ "Three highest peaks: " + "\n" + builderHighest.toString() + "\n"
                + "---------------------------------------------------------------------" + "\n" + "The three peaks with the \nhighest elevation gain of the route: " + "\n" + builderVertGains.toString()
                + "---------------------------------------------------------------------" + "\n" + "Three peaks with the longest route distance: " + "\n" + builderDistances.toString()

                );












        Button back = findViewById(R.id.back);
        back.setOnClickListener(e -> {
            Intent intent = new Intent(DisplayRankings.this, MainActivity.class);
            startActivity(intent);
        });


    }

}
