package com.example.ethan.pageloader;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {

    private static String downloadUrl(String myurl) throws IOException {
        InputStream inputStream = null;
        HttpURLConnection conn = null;

        try {
            URL url = new URL(myurl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            // Start the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("downloadURL", "The response is: " + response);
            inputStream = conn.getInputStream();

            // Convert the InputStream into a string
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) // Read line by line
                sb.append(line + "\n");

            String resString = sb.toString(); // Result is here

            return resString;

            // Close the InputStream and connection
        } finally {
            conn.disconnect();
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }


}
