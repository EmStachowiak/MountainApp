package com.example.mountainapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DeleteOneTrip extends AppCompatActivity {

    MountainList mountainApp = MountainList.getInstance();
    List<MountainPeak> mountainList = mountainApp.getMountainList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteonetrip);


        EditText id = findViewById(R.id.deleteByIdEditText);


        EditText name = findViewById(R.id.deleteByNameEditText);
        TextView deleteText = findViewById(R.id.deleteText);


        Button deleteByIdButton = findViewById(R.id.deleteOneTripById);
        deleteByIdButton.setOnClickListener(a -> {

            String idDelete = id.getText().toString();
            if (mountainList != null && !mountainList.isEmpty()) {
                int idToDelete = Integer.parseInt(idDelete);
                MountainPeak deletedPeak = null;
                for (MountainPeak peak : mountainList) {
                    if (peak.getIdList() == idToDelete) {
                        deletedPeak = peak;
                        break;
                    }
                }
                if (deletedPeak != null) {
                    mountainList.remove(deletedPeak);
                    deleteText.setText("You have deleted the trip with ID " + idDelete + "\n[" + deletedPeak.getMountainPeak() + "]");
                } else {
                    deleteText.setText("There is no such trip on the list.");
                }
            } else {
                deleteText.setText("The list is empty.");
            }
        });

        Button deleteByName = findViewById(R.id.deleteOneTripByName);
        deleteByName.setOnClickListener(a -> {
            String peakToDelete = name.getText().toString();

            if (mountainList != null && !mountainList.isEmpty()) {
                MountainPeak deletedPeak = null;
                for (MountainPeak peak : mountainList) {
                    if (peak.getMountainPeak().equals(peakToDelete)) {
                        deletedPeak = peak;

                        //mountainList.remove(peak.getMountainPeak().equals(name));

                        mountainList.remove(deletedPeak);
                        deleteText.setText("You have deleted the trip: " + "\n" +peakToDelete);
                        break;

                    } else {
                        deleteText.setText("There is no such trip on the list.");
                    }

                }

            } else {
                deleteText.setText("The list is empty.");
            }
        });















        Button back = findViewById(R.id.back);
        back.setOnClickListener(e -> {
            Intent intent = new Intent(DeleteOneTrip.this, MainActivity.class);
            startActivity(intent);
        });





    }
}
