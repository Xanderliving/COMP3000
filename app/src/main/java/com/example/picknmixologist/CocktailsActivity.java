package com.example.picknmixologist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;

public class CocktailsActivity extends AppCompatActivity {

    ListView listView;
    private CountDownTimer countDownTimer1, countDownTimer2, countDownTimer3, countDownTimer4, countDownTimer5, countDownTimer6;

    private int Pump1, Pump2, Pump3, Pump4, Pump5, Pump6;

    public int[] Shots = {0,0,0,0,0,0};

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> vodka = new ArrayList<>();
    ArrayList<String> gin = new ArrayList<>();
    ArrayList<String> rum = new ArrayList<>();
    ArrayList<String> tequila = new ArrayList<>();
    ArrayList<String> coke = new ArrayList<>();
    ArrayList<String> lemonade = new ArrayList<>();
    ArrayList<String> extra = new ArrayList<>();
    ArrayList<String> units = new ArrayList<>();
    public List<String> filterTitles(List<String> titles, String query) {
        return titles;
    };


    ArrayAdapter<String> adapter;

    public int OnPumps = 0;
    public int OffPumps = 0;

    int Vodka,Gin,Rum,Tequila,Coke,Lemonade = 0;
    int Units = 0;
    public String Extra;
    int Pumps = 0;
    private EditText editTextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktails);
        fetchData();

        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
        listView.setAdapter(adapter);
        editTextSearch = findViewById(R.id.editTextSearch);

        // Add TextChangedListener to EditText
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Filter the data based on user input
                filter(editable.toString());
            }
        });
    }

    public void filter(String text) {
        List<String> filteredList = new ArrayList<>();
        if (!text.isEmpty()) {
            for (String item : titles) {
                if (item.toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        } else {
            filteredList.addAll(titles); // If the search query is empty, show all items
        }

        // Update the adapter with filtered data
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filteredList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                fetchData();
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(CocktailsActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.shotpopup, null);
                dialogBuilder.setView(dialogView);
                //Stops user from clicking out the popup
                //dialogBuilder.setCancelable(false);
                final AlertDialog alertDialogs = dialogBuilder.create();
                alertDialogs.show();
                TextView Shots1;

                //dialogBuilder.setView(dialogView);
                Shots1 = dialogView.findViewById(R.id.Pump1s);
                Shots1.setText(String.valueOf(vodka.get(position)));
                Shots1 = dialogView.findViewById(R.id.Pump2s);
                Shots1.setText(String.valueOf(gin.get(position)));
                Shots1 = dialogView.findViewById(R.id.Pump3s);
                Shots1.setText(String.valueOf(rum.get(position)));
                Shots1 = dialogView.findViewById(R.id.Pump4s);
                Shots1.setText(String.valueOf(tequila.get(position)));
                Shots1 = dialogView.findViewById(R.id.Pump5s);
                Shots1.setText(String.valueOf(coke.get(position)));
                Shots1 = dialogView.findViewById(R.id.Pump6s);
                Shots1.setText(String.valueOf(lemonade.get(position)));
                Shots1 = dialogView.findViewById(R.id.Units);
                Shots1.setText("This drink is " + String.valueOf(units.get(position)) + " Units");
                Shots1 = dialogView.findViewById(R.id.title);
                Shots1.setText("Do you want to make a " + String.valueOf(titles.get(position)));



                Pump1 = Integer.parseInt(vodka.get(position));
                Pump2 = Integer.parseInt(gin.get(position));
                Pump3 = Integer.parseInt(rum.get(position));
                Pump4 = Integer.parseInt(tequila.get(position));
                Pump5 = Integer.parseInt(coke.get(position));
                Pump6 = Integer.parseInt(lemonade.get(position));
                Units = Integer.parseInt(units.get(position));

                Shots1 = dialogView.findViewById(R.id.Extra);
                Shots1.setText(String.valueOf(extra.get(position)));


                Button closeButton = dialogView.findViewById(R.id.button1);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialogs.dismiss();
                    }
                });

                Button sendButton = dialogView.findViewById(R.id.button2);
                sendButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialogs.dismiss();
                        showPopupLoading();
                    }
                });
            }
        });



    }

    private void fetchData() {
        String url = "http://192.168.0.46:3001/api/data/";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String title = jsonObject.getString("Name");
                        try {
                            Vodka = jsonObject.getInt("Vodka");
                        } catch (JSONException e) {
                            // If "Vodka" field is not present or cannot be parsed as an integer, set it to 0
                            Vodka = 0;
                        }

                        try {
                            Gin = jsonObject.getInt("Gin");
                        } catch (JSONException e) {
                            // If "Gin" field is not present or cannot be parsed as an integer, set it to 0
                            Gin = 0;
                        }

                        try {
                            Rum = jsonObject.getInt("Rum");
                        } catch (JSONException e) {
                            // If "Gin" field is not present or cannot be parsed as an integer, set it to 0
                            Rum = 0;
                        }

                        try {
                            Tequila = jsonObject.getInt("Tequila");
                        } catch (JSONException e) {
                            // If "Gin" field is not present or cannot be parsed as an integer, set it to 0
                            Tequila = 0;
                        }

                        try {
                            Coke = jsonObject.getInt("Coke");
                        } catch (JSONException e) {
                            // If "Gin" field is not present or cannot be parsed as an integer, set it to 0
                            Coke = 0;
                        }

                        try {
                            Lemonade = jsonObject.getInt("Lemonade");
                        } catch (JSONException e) {
                            // If "Gin" field is not present or cannot be parsed as an integer, set it to 0
                            Lemonade = 0;
                        }
                        try {
                            Extra = jsonObject.getString("Extra");
                        } catch (JSONException e) {

                            Extra = "";
                        }
                        try {
                            Units = jsonObject.getInt("Units");
                        } catch (JSONException e) {

                            Units = 0;
                        }

                        titles.add(title);
                        vodka.add(String.valueOf(Vodka));
                        gin.add(String.valueOf(Gin));
                        rum.add(String.valueOf(Rum));
                        tequila.add(String.valueOf(Tequila));
                        coke.add(String.valueOf(Coke));
                        lemonade.add(String.valueOf(Lemonade));
                        extra.add(Extra);
                        units.add(String.valueOf(Units));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CocktailsActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonArrayRequest);
    }


    public void onButtonClick() {
        PutRequest.changeStatusOff(this, OffPumps);
        Pumps -=1;
        System.out.println("The pump is: " + Pumps);

    }
    public void onButtonClick2() {
        PutRequest.changeStatusOn(this, OnPumps);
        Pumps +=1;
    }
    private void showPopupLoading() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(CocktailsActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.loadingpopup, null);
        dialogBuilder.setView(dialogView);
        //Stops user from clicking out the popup
        dialogBuilder.setCancelable(false);
        final AlertDialog alertDialogs = dialogBuilder.create();
        alertDialogs.show();


        int durationInMillis = 15000; // 6 seconds
        Shots[0] = durationInMillis * Pump1;
        Shots[1] = durationInMillis * Pump2;
        Shots[2] = durationInMillis * Pump3;
        Shots[3] = durationInMillis * Pump4;
        Shots[4] = durationInMillis * Pump5;
        Shots[5] = durationInMillis * Pump6;

        //to stop glitches
        for (int i = 0; i > Shots.length; i++) {
            if (Shots[i] == 0) {
                Shots[i] = 10;
            }
        }

        countDownTimer1 = new CountDownTimer(Shots[0], 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}
            @Override
            public void onFinish() {OffPumps = 1; onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(CocktailsActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
        };
        countDownTimer2 = new CountDownTimer(Shots[1], 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}
            @Override
            public void onFinish() {OffPumps = 2; onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(CocktailsActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
        };
        countDownTimer3 = new CountDownTimer(Shots[2], 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}
            @Override
            public void onFinish() {OffPumps = 3;  onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(CocktailsActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
        };
        countDownTimer4 = new CountDownTimer(Shots[3], 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}
            @Override
            public void onFinish() {OffPumps = 4; onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(CocktailsActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
        };
        countDownTimer5 = new CountDownTimer(Shots[4], 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}
            @Override
            public void onFinish() {OffPumps = 5; onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(CocktailsActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
        };
        countDownTimer6 = new CountDownTimer(Shots[5], 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}
            @Override
            public void onFinish() {OffPumps = 6; onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(CocktailsActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
        };

        OnPumps = 1;
        if (Shots[0] != 0){countDownTimer1.start(); onButtonClick2();}

        OnPumps= 2;
        if (Shots[1] != 0){countDownTimer2.start(); onButtonClick2();}

        OnPumps= 3;
        if (Shots[2] != 0){countDownTimer3.start();onButtonClick2();}

        OnPumps= 4;
        if (Shots[3] != 0){countDownTimer4.start(); onButtonClick2();}

        OnPumps= 5;
        if (Shots[4] != 0){countDownTimer5.start(); onButtonClick2();}

        OnPumps= 6;
        if (Shots[5] != 0){countDownTimer6.start(); onButtonClick2();}

        }


}

