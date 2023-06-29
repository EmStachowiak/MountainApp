package com.example.mountainapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class EditTrip extends AppCompatActivity {
    MountainList mountainApp = MountainList.getInstance();
    List<MountainPeak> mountainList = mountainApp.getMountainList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittrip);


        EditText id = findViewById(R.id.editByIdEditText);
        EditText Name = findViewById(R.id.editByNameEditText);

        Button ediByIdButton = findViewById(R.id.editTripById);
        Button editByNameButton = findViewById(R.id.editTripByName);

        TextView text = findViewById(R.id.textViewEdit);


        ediByIdButton.setOnClickListener(a -> {

            String idToEdit = id.getText().toString();

            if (mountainList != null && !mountainList.isEmpty()) {
                int idToEditInt = Integer.parseInt(idToEdit);
                MountainPeak editPeak = null;
                for (MountainPeak peak : mountainList) {
                    if (peak.getIdList() == idToEditInt) {
                        editPeak = peak;
                        break;
                    }
                }
                if (editPeak != null) {
                    mountainList.remove(editPeak);


                    //deleteText.setText("You have deleted the trip with ID " + idDelete + "\n[" + editPeak.getMountainPeak() + "]");
                } else {
                    // deleteText.setText("There is no such trip on the list.");
                }
            } else {
                //deleteText.setText("The list is empty.");
            }
        });


        Button back = findViewById(R.id.back);
        back.setOnClickListener(e -> {
            Intent intent = new Intent(EditTrip.this, MainActivity.class);
            startActivity(intent);
        });


    }
}

