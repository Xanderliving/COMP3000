package com.example.picknmixologist;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class fetchData extends AsyncTask<Void, Void, String> {
    // Use WeakReference to avoid potential memory leaks
    private WeakReference<TextView> statusTextView;

    fetchData(TextView statusTextView) {
        this.statusTextView = new WeakReference<>(statusTextView);
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL("http://172.20.10.4:8000/book/1");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            try {
                InputStream in = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                return stringBuilder.toString();
            } finally {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            Log.e("HTTP Request", "Error", e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        TextView textView = statusTextView.get();
        if (textView != null) {
            if (result != null) {
                // Parse the JSON response and extract the "Status" data
                // Assuming the response is in JSON format
                try {
                    // Replace this with your JSON parsing logic
                    // For simplicity, assuming the "Status" key is at the top level
                    String status = new JSONObject(result).getString("Status");
                    textView.setText(status);
                } catch (JSONException e) {
                    Log.e("JSON Parsing", "Error", e);
                }
            } else {
                textView.setText("Failed to get data from the server.");
            }
        }
    }
}
