package com.example.mountainapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class EditTrip extends AppCompatActivity {
    MountainList mountainApp = MountainList.getInstance();
    List<MountainPeak> mountainList = mountainApp.getMountainList();

    private LinearLayout editLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittrip);


        EditText id = findViewById(R.id.editByIdEditText);
        EditText nameEditT = findViewById(R.id.editByNameEditText);

        Button editByIdButton = findViewById(R.id.editTripById);
        Button editByNameButton = findViewById(R.id.editTripByName);

        TextView text = findViewById(R.id.textViewEdit);

        editLayout = findViewById(R.id.editLayout);
        editLayout.setVisibility(View.GONE);




        editByIdButton.setOnClickListener(a -> {

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
                if (editPeak != null && idToEdit != null) {

                    editLayout.setVisibility(View.VISIBLE);
                    text.setText("You want to edit tour by id: " + idToEdit +
                            " \n[Name: " + editPeak.getMountainPeak() +
                            "   /Hight: " + editPeak.getHeight() +
                            "   /Vertical gain: " + editPeak.getVerticalGain() +
                            "  /Distance: " + editPeak.getDistance() + " ]");


                    EditText editNameEditText = findViewById(R.id.editNameEditText);
                    EditText editHeightEditText = findViewById(R.id.editHeightEditText);
                    EditText editVerticalGainEditText = findViewById(R.id.editVerticalGainEditText);
                    EditText editDistanceEditText = findViewById(R.id.editDistanceEditText);
                    Button updateButton = findViewById(R.id.updateButton);

                    MountainPeak finalEditPeak = editPeak;
                    updateButton.setOnClickListener(v -> {
                        String name = editNameEditText.getText().toString();
                        String heightText = editHeightEditText.getText().toString();
                        String verticalGainText = editVerticalGainEditText.getText().toString();
                        String distanceText = editDistanceEditText.getText().toString();

                        if (name != null && !name.isEmpty()) {
                            finalEditPeak.setMountainPeak(name);
                        }
                        if (heightText != null && !heightText.isEmpty()) {
                            int height = Integer.parseInt(heightText);
                            finalEditPeak.setHeight(height);
                        }
                        if (verticalGainText != null && !verticalGainText.isEmpty()) {
                            int verticalGain = Integer.parseInt(verticalGainText);
                            finalEditPeak.setVerticalGain(verticalGain);
                        }
                        if (distanceText != null && !distanceText.isEmpty()) {
                            int distance = Integer.parseInt(distanceText);
                            finalEditPeak.setDistance(distance);
                        }
                            Toast.makeText(EditTrip.this, "Changes have been made!", Toast.LENGTH_SHORT).show();

                    });




                } else {
                    editLayout.setVisibility(View.GONE);
                    text.setText("There is no such trip on the list.");
                }
            } else {
                editLayout.setVisibility(View.GONE);
                text.setText("The list is empty.");
            }
        });




        editByNameButton.setOnClickListener(a -> {

            String nameToEdit = nameEditT.getText().toString();

            if (mountainList != null && !mountainList.isEmpty()) {

                MountainPeak editPeak = null;
                for (MountainPeak peak : mountainList) {
                    if (peak.getMountainPeak().equalsIgnoreCase(nameToEdit)) {
                        editPeak = peak;
                        break;
                    }
                }
                if (editPeak != null && nameToEdit != null) {

                    editLayout.setVisibility(View.VISIBLE);
                    text.setText("You want to edit tour by name of the peak: " + nameToEdit +
                            " \n[Name: " + editPeak.getMountainPeak() +
                            "   /Hight: " + editPeak.getHeight() +
                            "   /Vertical gain: " + editPeak.getVerticalGain() +
                            "  /Distance: " + editPeak.getDistance() + " ]");


                    EditText editNameEditText = findViewById(R.id.editNameEditText);
                    EditText editHeightEditText = findViewById(R.id.editHeightEditText);
                    EditText editVerticalGainEditText = findViewById(R.id.editVerticalGainEditText);
                    EditText editDistanceEditText = findViewById(R.id.editDistanceEditText);
                    Button updateButton = findViewById(R.id.updateButton);

                    MountainPeak finalEditPeak = editPeak;
                    updateButton.setOnClickListener(v -> {
                        String name = editNameEditText.getText().toString();
                        String heightText = editHeightEditText.getText().toString();
                        String verticalGainText = editVerticalGainEditText.getText().toString();
                        String distanceText = editDistanceEditText.getText().toString();

                        if (name != null && !name.isEmpty()) {
                            finalEditPeak.setMountainPeak(name);
                        }
                        if (heightText != null && !heightText.isEmpty()) {
                            int height = Integer.parseInt(heightText);
                            finalEditPeak.setHeight(height);
                        }
                        if (verticalGainText != null && !verticalGainText.isEmpty()) {
                            int verticalGain = Integer.parseInt(verticalGainText);
                            finalEditPeak.setVerticalGain(verticalGain);
                        }
                        if (distanceText != null && !distanceText.isEmpty()) {
                            int distance = Integer.parseInt(distanceText);
                            finalEditPeak.setDistance(distance);
                        }
                            Toast.makeText(EditTrip.this, "Changes have been made!", Toast.LENGTH_SHORT).show();

                    });




                } else {
                    editLayout.setVisibility(View.GONE);
                    text.setText("There is no such trip on the list.");
                }
            } else {
                editLayout.setVisibility(View.GONE);
                text.setText("The list is empty.");
            }
        });






        Button back = findViewById(R.id.back);
        back.setOnClickListener(e -> {
            Intent intent = new Intent(EditTrip.this, MainActivity.class);
            startActivity(intent);
        });


    }
}


