package com.example.mountainapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AddTrip extends AppCompatActivity {

    private EditText mountainName;
    private EditText addHeight;
    private EditText addVerticalGain;
    private EditText addDistance;
    public List<MountainPeak> mountainList = new ArrayList<>();
    public TextView displayTrip;
    private MountainList mountainApp = MountainList.getInstance();

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

            String height = addHeight.getText().toString();
            int heightInt = 0;
            if (!height.isEmpty()) {
                heightInt = Integer.parseInt(height);
            }

            String distance= addDistance.getText().toString();
            int distanceInt = 0;
            if (!distance.isEmpty()) {
                distanceInt = Integer.parseInt(distance);
            }

            String verticalGain= addVerticalGain.getText().toString();
            int verticalGainInt = 0;
            if (!verticalGain.isEmpty()) {
                verticalGainInt = Integer.parseInt(verticalGain);
            }

            MountainPeak newTrip = new MountainPeak(name, heightInt, verticalGainInt, distanceInt);


                mountainList.add(newTrip);
                mountainApp.addMountain(newTrip);
                updateTripList();

                List<MountainPeak> temporaryList = new ArrayList<>(mountainList);
                temporaryList.add(newTrip);

                mountainName.setText("");
                addHeight.setText("");
                addDistance.setText("");
                addVerticalGain.setText("");

                mountainList = temporaryList;


        });

        displayTrip = findViewById(R.id.displayTrip);



        Button back = findViewById(R.id.back);
        back.setOnClickListener(e -> {
            Intent intent = new Intent(AddTrip.this, MainActivity.class);
            intent.putParcelableArrayListExtra("mountainList", new ArrayList<>(mountainList));
            startActivity(intent);
        });




    }
    private void updateTripList() {
        StringBuilder stringBuilder = new StringBuilder();
        MountainPeak lastTrip = mountainList.get(mountainList.size() - 1);

        if (!mountainList.isEmpty() && mountainList != null) {


            stringBuilder.append("Name: ").append(lastTrip.getMountainPeak()).append("\n");
            stringBuilder.append("Height: ").append(lastTrip.getHeight()).append("\n");
            stringBuilder.append("Vertical Gain: ").append(lastTrip.getVerticalGain()).append("\n");
            stringBuilder.append("Distance: ").append(lastTrip.getDistance()).append("\n");
        }

        if ( !(lastTrip.getMountainPeak() == null) && !(lastTrip.getHeight() == 0)
                && !(lastTrip.getVerticalGain() == 0) && !(lastTrip.getDistance() == 0)) {
            displayTrip.setText(stringBuilder.toString());
        } else {
            displayTrip.setText("Data cannot be empty, \nplease try again!");
        }






    }

}