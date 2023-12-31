package com.example.hydroponics;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ThingspeakClient extends AsyncTask<String, String, String> {
    URL url = null;
    InputStream responseStream;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        try {
//            url = new URL();
//        } catch (MalformedURLException ex) {
//            throw new RuntimeException(ex);
//        }
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        try {
            url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            responseStream = connection.getInputStream();

            BufferedReader br1 = new BufferedReader(
                    new InputStreamReader(responseStream));

            StringBuilder response = new StringBuilder();
            String responseSingle = null;

            while ((responseSingle = br1.readLine())
                    != null) {
                response.append(responseSingle);
            }
            return response.toString();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        System.out.println(response);
    }
}
