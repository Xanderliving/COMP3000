package com.example.picknmixologist;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private String encryptedUsername;
    private String encryptedPassword;
    private Button loginButton;
    private Button registerButton;

    ArrayList<String> Username = new ArrayList<>();
    ArrayList<String> Password = new ArrayList<>();

    public String username,password;
    private static final String URL_TO_CHECK = "http://192.168.0.46:3001/api/data/";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        showOver18Dialog();
        if (isNetworkAvailable()) {
            checkURLStatus(URL_TO_CHECK);
        } else {
            Toast.makeText(this, "No internet connection available", Toast.LENGTH_SHORT).show();
        }

        usernameEditText = findViewById(R.id.editTextUsername2);
        passwordEditText = findViewById(R.id.editTextPassword2);
        loginButton = findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(view -> {

            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            accounts();
            sendLoginDetails(username, password);

            ///Checker();


        });

        View registerclicker = findViewById(R.id.textViewRegister);

        registerclicker.setOnClickListener(view -> {
            showPopupRegister();

        });

    }
    public void Checker() {
        for (int i = 0; i < Username.size(); i++) {
            String User = Username.get(i).trim();
            String EUser = encryptedUsername.trim();
            String Pass = Password.get(i).trim();
            String EPass = encryptedPassword.trim();

            if (User.equals(EUser) && Pass.equals(EPass)) {
                // Both username and password are correct
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }
    }


    public void sendLoginDetails(String username, String password) {
        new Thread(new Runnable() {
            public void run() {
                try {

                    encryptedUsername = User.encrypt(username);
                    encryptedPassword = User.encrypt(password);



                    // Handle response here
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }).start();

    }



    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void checkURLStatus(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean isLive = isURLLive(url);
                if (isLive) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showOver18Dialog();
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showCheckMachinePopup();
                        }
                    });
                }
            }
        }).start();
    }
    private boolean isURLLive(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setRequestProperty("User-Agent", "test");
            urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(10000); // 10 seconds timeout in milliseconds

            urlc.connect();
            return (urlc.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (IOException e) {
            // Log exception if needed
            return false;
        }
    }
    private void showCheckMachinePopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Machine Check");
        builder.setMessage("Please check the machine. The URL is not reachable.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Close the dialog or take any necessary action
            }
        });
        builder.setCancelable(false); // Prevent dialog from being dismissed by touching outside
        builder.show();
    }

    //popup for age
    private void showOver18Dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Age");
        builder.setView(R.layout.agepopup);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                TextView Shot1 = findViewById(R.id.Pump1Shots);
                fetchData myAsyncTask = new fetchData(Shot1);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });
        builder.setCancelable(false);
        builder.show();


    }


    @SuppressLint("MissingInflatedId")
    private void showPopupRegister() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LoginActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.register_popup, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog alertDialogs = dialogBuilder.create();
        alertDialogs.show();

        usernameEditText = findViewById(R.id.editTextUsername2);
        passwordEditText = findViewById(R.id.editTextPassword2);

        username = String.valueOf(usernameEditText);
        password = String.valueOf(passwordEditText);

        Button regButton = dialogView.findViewById(R.id.buttonRegister);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    encryptedUsername = User.encrypt(username);
                    encryptedPassword = User.encrypt(password);



                    // Handle response here
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });




    }

    private void accounts() {
        String url = "http://192.168.0.46:3001/accounts";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        username = jsonObject.getString("Username");
                        password = jsonObject.getString("Password");

                        Username.add(username);
                        Password.add(password);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Checker();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonArrayRequest);

    }
}
