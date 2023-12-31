package com.example.hydroponics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
//import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button homeButton, liveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeButton = (Button) findViewById(R.id.homeButton);
        liveButton = (Button) findViewById(R.id.liveButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SelectCrop.class);
                startActivity(i);
            }
        });

        liveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ScrollActivity.class);
                startActivity(i);
            }
        });
        ThingspeakClient client = new ThingspeakClient();
        client.execute("https://api.thingspeak.com/channels/2080835/feeds.json?api_key=SPJO1DKYA6LX64QW&results=3");
    }
}