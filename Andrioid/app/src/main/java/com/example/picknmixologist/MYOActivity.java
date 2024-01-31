package com.example.picknmixologist;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

import java.nio.charset.StandardCharsets;

public class MYOActivity extends AppCompatActivity {
    private int url2;
    private SeekBar slider;
    private TextView progressText, progressText2, progressText3, progressText4, progressText5, progressText6;
    private String Pump1, Pump2, Pump3, Pump4, Pump5, Pump6;
    private RequestQueue requestQueue;
    private Button sendButton;

    public void onButtonClick(View view) {
        PutRequest.changeStatusOff(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myo);

        //Slider for pump1
        slider = findViewById(R.id.Pump1);
        progressText = findViewById(R.id.Pump1Shots);
        TextView Shot1 = findViewById(R.id.Pump1Shots);
        fetchData myAsyncTask = new fetchData(Shot1);
        myAsyncTask.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText.setText("Shots: " + progress);
                Pump1 = String.valueOf(progress);
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

        //Slider for pump2
        slider = findViewById(R.id.Pump2);
        progressText2 = findViewById(R.id.Pump2Shots);
        TextView Shot2 = findViewById(R.id.Pump2Shots);
        fetchData Task2 = new fetchData(Shot2);
        Task2.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText2.setText("Shots: " + progress);
                Pump2 = String.valueOf(progress);
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

        //Slider for pump3
        slider = findViewById(R.id.Pump3);
        progressText3 = findViewById(R.id.Pump3Shots);
        TextView Shot3 = findViewById(R.id.Pump3Shots);
        fetchData Task3 = new fetchData(Shot3);
        Task3.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText3.setText("Shots: " + progress);
                Pump3 = String.valueOf(progress);
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

        //Slider for pump4
        slider = findViewById(R.id.Pump4);
        progressText4 = findViewById(R.id.Pump4Shots);
        TextView Shot4 = findViewById(R.id.Pump4Shots);
        fetchData Task4 = new fetchData(Shot4);
        Task4.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText4.setText("Shots: " + progress);
                Pump4 = String.valueOf(progress);
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

        //Slider for pump5
        slider = findViewById(R.id.Pump5);
        progressText5 = findViewById(R.id.Pump5Shots);
        TextView Shot5 = findViewById(R.id.Pump5Shots);
        fetchData Task5 = new fetchData(Shot5);
        Task5.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText5.setText("Shots: " + progress);
                Pump5 = String.valueOf(progress);
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

        //Slider for pump6
        slider = findViewById(R.id.Pump6);
        progressText6 = findViewById(R.id.Pump6Shots);
        TextView Shot6 = findViewById(R.id.Pump6Shots);
        fetchData Task6 = new fetchData(Shot6);
        Task6.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText6.setText("Shots: " + progress);
                Pump6 = String.valueOf(progress);
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


        sendButton = findViewById(R.id.submitbtn);
        requestQueue = Volley.newRequestQueue(this);


    }













        /*
        sendButton = findViewById(R.id.Sendbtn);
        requestQueue = Volley.newRequestQueue(this);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sendDataToAPI(progress)
                String Total = Pump1 + Pump2 + Pump3 + Pump4 + Pump5 + Pump6;
                Toast.makeText(MYOActivity.this, Total, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void sendDataToAPI(int value) {
        JSONObject requestData = new JSONObject();
        try {
            requestData.put("value", value);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://192.168.0.33:8000/book/1", requestData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle API response
                        Toast.makeText(MYOActivity.this, "API Response: " + response.toString(), Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors
                        Toast.makeText(MYOActivity.this, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(request);
        */


}