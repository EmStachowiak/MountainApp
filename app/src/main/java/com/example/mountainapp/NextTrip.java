package com.example.mountainapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class NextTrip extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexttrip);


        radioGroup = findViewById(R.id.radioGroup);
        RadioButton withChildren = findViewById(R.id.withChildren);
        RadioButton easy = findViewById(R.id.easyTrip);
        RadioButton medium = findViewById(R.id.mediumDiff);
        RadioButton difficult = findViewById(R.id.difficult);
        constraintLayout = findViewById(R.id.next);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == withChildren.getId()) {
                    constraintLayout.setBackgroundColor(Color.parseColor("#2196F3"));
                } if ( checkedId == easy.getId()) {
                    constraintLayout.setBackgroundColor(Color.parseColor("#757575"));
                } if (checkedId == medium.getId()) {
                    constraintLayout.setBackgroundColor(Color.parseColor("#FFAB91"));
                } if (checkedId == difficult.getId()) {
                    constraintLayout.setBackgroundColor(Color.parseColor("#FBC02D"));

                }

            }
        });








        Button back = findViewById(R.id.back);
        back.setOnClickListener(e -> {
            Intent intent = new Intent(NextTrip.this, MainActivity.class);
            startActivity(intent);
        });



    }

    }
