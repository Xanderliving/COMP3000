package com.example.picknmixologist;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class PutRequest {

    private static final String BASE_URL = "http://192.168.0.33:8000/";
    private static final String ENDPOINT = "book/1"; // Adjust endpoint according to your API

    public static void changeStatusOff(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL + ENDPOINT;

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("id", "1");
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
}
