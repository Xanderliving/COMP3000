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

    private WeakReference<TextView> statusTextView;
    public int[] Shots = {1,2,3,4,5,6};
    fetchData(TextView statusTextView) {
        this.statusTextView = new WeakReference<>(statusTextView);
    }

    @Override
    protected String doInBackground(Void... voids) {
        return null;
    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        TextView textView = statusTextView.get();
        if (textView != null) {
            if (result != null) {

                try {

                    String status = new JSONObject(result).getString("status");
                    textView.setText(status);
                } catch (JSONException e) {
                    Log.e("JSON Parsing", "Error", e);
                }
            } else {
                textView.setText("Shots: 0");
            }
        }
    }
}
