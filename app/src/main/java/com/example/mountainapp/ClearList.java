package com.example.mountainapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ClearList extends AppCompatActivity {
    MountainList mountainList = MountainList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clearlist);

        Button clearList = findViewById(R.id.yes);
        clearList.setOnClickListener(a -> {
            mountainList.clearMountainList();
            Toast.makeText(ClearList.this,
                    "You cleared the entired list, \nyou have to go to the mountains!", Toast.LENGTH_SHORT).show();
        });



        Button back = findViewById(R.id.back);
        back.setOnClickListener(e -> {
            Intent intent = new Intent(ClearList.this, MainActivity.class);
            startActivity(intent);
        });

    }
}
