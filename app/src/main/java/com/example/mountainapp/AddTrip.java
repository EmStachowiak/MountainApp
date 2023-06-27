package com.example.mountainapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AddTrip extends AppCompatActivity {

    EditText mountainName;
    EditText addHeight;
    EditText addVerticalGain;
    EditText addDistance;
    public List<MountainPeak> mountainList = new ArrayList<>();
    TextView displayTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtrip);


        mountainName = findViewById(R.id.addName);
        addHeight = findViewById(R.id.addHeight);
        addVerticalGain = findViewById(R.id.addVerticalGain);
        addDistance = findViewById(R.id.addDistance);


        Button addTrip = findViewById(R.id.addTrip);




        addTrip.setOnClickListener(a -> {
            String name =  mountainName.getText().toString();
//            finalHeightInt = heightInt;
//            finalVerticalGainInt = verticalGainInt;
//            finalDistanceInt = distanceInt;

            String height = addHeight.getText().toString();
            int heightInt = 0;
            if (!height.isEmpty()) {
                heightInt = Integer.parseInt(height);
            }

            String distance= addDistance.getText().toString();
            int distanceInt = 0;
            if (!height.isEmpty()) {
                distanceInt = Integer.parseInt(distance);
            }

            String verticalGain= addVerticalGain.getText().toString();
            int verticalGainInt = 0;
            if (!height.isEmpty()) {
                verticalGainInt = Integer.parseInt(verticalGain);
            }


            mountainList.add(new MountainPeak(name, heightInt, verticalGainInt, distanceInt));
            updateTripList();
        });

        displayTrip = findViewById(R.id.displayTrip);



    }
    private void updateTripList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (MountainPeak peak : mountainList) {
            stringBuilder.append("Name: ").append(peak.getMountainPeak()).append("\n");
            stringBuilder.append("Height: ").append(peak.getHeight()).append("\n");
            stringBuilder.append("Vertical Gain: ").append(peak.getVerticalGain()).append("\n");
            stringBuilder.append("Distance: ").append(peak.getDistance()).append("\n");
        }
        displayTrip.setText(stringBuilder.toString());
    }


}
