package com.example.picknmixologist;


import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class PutRequest extends AppCompatActivity {
    public static String[] Drinks = {"place", "Vodka" ,"Gin" ,"Rum" ,"Tequila" ,"Coke", "Lemonade"};
    private static final String BASE_URL = "http://192.168.0.46:8000/book/";

    public static void changeStatusOff(Context context, int Pumps) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL + Pumps;
        String Drink = Drinks[Pumps];
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("id", Pumps);
            jsonBody.put("name", Drink);
            jsonBody.put("status", "Off");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, jsonBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle success response
                        Log.d("VolleyResponse", "Status changed successfully: " + response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error response
                Log.e("VolleyError", "Error: " + error.toString());
            }
        });


        queue.add(jsonObjectRequest);
    }
    public static void changeStatusOn(Context context, int Pumps) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL + Pumps;
        String Drink = Drinks[Pumps];
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("id", Pumps);
            jsonBody.put("name", Drink);
            jsonBody.put("status", "On");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, jsonBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle success response
                        Log.d("VolleyResponse", "Status changed successfully: " + response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error response
                Log.e("VolleyError", "Error: " + error.toString());
            }
        });
        queue.add(jsonObjectRequest);
    }


}
