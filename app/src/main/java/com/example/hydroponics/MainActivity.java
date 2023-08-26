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
        // Step 1: Create a neat value object to hold the URL
        URL url = null;
        try {
            url = new URL("https://api.thingspeak.com/channels/2080835/feeds.json?api_key=SPJO1DKYA6LX64QW&results=3");


// Step 2: Open a connection(?) on the URL(??) and cast the response(???)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

// Now it's "open", we can set the request method, headers etc.
            connection.setRequestProperty("accept", "application/json");

// This line makes the request
//            InputStream responseStream = connection.getInputStream();

// Step 3: Manually converting the response body InputStream to
// APOD using Jackson
//            ObjectMapper mapper = new ObjectMapper();

//            APOD apod = mapper.readValue(responseStream, APOD.class);

// Step 5: Finally, display the response we have
//            System.out.println(responseStream);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}