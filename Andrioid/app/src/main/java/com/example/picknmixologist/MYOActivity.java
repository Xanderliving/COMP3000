package com.example.picknmixologist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MYOActivity extends AppCompatActivity {
    private int url2;
    private SeekBar slider;
    private TextView progressText;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myo);

        slider = findViewById(R.id.slider);
        progressText = findViewById(R.id.progressText);
        TextView statusTextView = findViewById(R.id.statustxt);


        fetchData myAsyncTask = new fetchData(statusTextView);
        myAsyncTask.execute();

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText.setText("Shots: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something when tracking starts
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do something when tracking stops
            }
        });

    }


}