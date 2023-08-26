package com.example.hydroponics;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LiveStatus extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_live_statue);
        String cropName = getIntent().getStringExtra("cropName");

        TextView cropNameTextView = (TextView) findViewById(R.id.cropNameTextView);
        cropNameTextView.setText(cropName);
    }
}