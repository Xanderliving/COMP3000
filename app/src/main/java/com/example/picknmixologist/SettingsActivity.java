package com.example.picknmixologist;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;


public class SettingsActivity extends AppCompatActivity {
    int option = 1;
    int Change = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.settings_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button NewDrink = findViewById(R.id.NewDrinkbtn);
        NewDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //PutRequest.changeStatusOff(SettingsActivity.this, option);
                showPopupnew();

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle selection here
                String selectedOption = parentView.getItemAtPosition(position).toString();
                //Toast.makeText(SettingsActivity.this, "Selected: " + selectedOption, Toast.LENGTH_SHORT).show();
                String[] Drinks = PutRequest.Drinks;
                TextView OldDrink = findViewById(R.id.oldDrinktxt);
                View dotPump1 = findViewById(R.id.DotPump1);
                View dotPump2 = findViewById(R.id.DotPump2);
                View dotPump3 = findViewById(R.id.DotPump3);
                View dotPump4 = findViewById(R.id.DotPump4);
                View dotPump5 = findViewById(R.id.DotPump5);
                View dotPump6 = findViewById(R.id.DotPump6);

                if ("Pump 1".equals(selectedOption)) {
                    OldDrink.setText(Drinks[1]);
                    option = 1;
                    dotPump1.setVisibility(View.VISIBLE);
                    dotPump2.setVisibility(View.INVISIBLE);
                    dotPump3.setVisibility(View.INVISIBLE);
                    dotPump4.setVisibility(View.INVISIBLE);
                    dotPump5.setVisibility(View.INVISIBLE);
                    dotPump6.setVisibility(View.INVISIBLE);
                } else if ("Pump 2".equals(selectedOption)) {
                    OldDrink.setText(Drinks[2]);
                    option = 2;
                    dotPump1.setVisibility(View.INVISIBLE);
                    dotPump2.setVisibility(View.VISIBLE);
                    dotPump3.setVisibility(View.INVISIBLE);
                    dotPump4.setVisibility(View.INVISIBLE);
                    dotPump5.setVisibility(View.INVISIBLE);
                    dotPump6.setVisibility(View.INVISIBLE);
                } else if ("Pump 3".equals(selectedOption)) {
                    OldDrink.setText(Drinks[3]);
                    option = 3;
                    dotPump1.setVisibility(View.INVISIBLE);
                    dotPump2.setVisibility(View.INVISIBLE);
                    dotPump3.setVisibility(View.VISIBLE);
                    dotPump4.setVisibility(View.INVISIBLE);
                    dotPump5.setVisibility(View.INVISIBLE);
                    dotPump6.setVisibility(View.INVISIBLE);
                } else if ("Pump 4".equals(selectedOption)) {
                    OldDrink.setText(Drinks[4]);
                    option = 4;
                    dotPump1.setVisibility(View.INVISIBLE);
                    dotPump2.setVisibility(View.INVISIBLE);
                    dotPump3.setVisibility(View.INVISIBLE);
                    dotPump4.setVisibility(View.VISIBLE);
                    dotPump5.setVisibility(View.INVISIBLE);
                    dotPump6.setVisibility(View.INVISIBLE);
                } else if ("Pump 5".equals(selectedOption)) {
                    OldDrink.setText(Drinks[5]);
                    option = 5;
                    dotPump1.setVisibility(View.INVISIBLE);
                    dotPump2.setVisibility(View.INVISIBLE);
                    dotPump3.setVisibility(View.INVISIBLE);
                    dotPump4.setVisibility(View.INVISIBLE);
                    dotPump5.setVisibility(View.VISIBLE);
                    dotPump6.setVisibility(View.INVISIBLE);
                } else if ("Pump 6".equals(selectedOption)) {
                    OldDrink.setText(Drinks[6]);
                    option = 6;
                    dotPump1.setVisibility(View.INVISIBLE);
                    dotPump2.setVisibility(View.INVISIBLE);
                    dotPump3.setVisibility(View.INVISIBLE);
                    dotPump4.setVisibility(View.INVISIBLE);
                    dotPump5.setVisibility(View.INVISIBLE);
                    dotPump6.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }

        });


    }
    private void showPopupnew () {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SettingsActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.newdrinkpopup, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        final AlertDialog alertDialogs = dialogBuilder.create();
        alertDialogs.show();

        Button CreateButton = dialogView.findViewById(R.id.changedbtn);
        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogs.dismiss();
                showPopupLoading();
            }
        });


    }
    private void showPopupLoading() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SettingsActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.changingdrinkpopup, null);
        View Popup = getLayoutInflater().inflate(R.layout.newdrinkpopup, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        final AlertDialog alertDialogs = dialogBuilder.create();
        alertDialogs.show();

        int timer = 0;
        if(option == 1){timer = 7400;}
        if(option == 2){timer = 8300;}
        if(option == 3){timer = 7600;}
        if(option == 4){timer = 7400;}
        if(option == 5){timer = 8200;}
        if(option == 6){timer = 7800;}


        CountDownTimer countDownTimer1 = new CountDownTimer(timer, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {

                PutRequest.changeStatusOff(SettingsActivity.this, option);
                alertDialogs.dismiss();
                if(Change ==2){
                    Toast.makeText(SettingsActivity.this, "Drink has been changed", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }else {
                    PopupWater();
                }
            }
        };


        TextView NewDrink = findViewById(R.id.newDrinktxt);
        String NewDrinks = NewDrink.getText().toString();
        PutRequest.Drinks[option] = NewDrinks;
        PutRequest.changeStatusOn(SettingsActivity.this, option);
        countDownTimer1.start();


    }

    private void PopupWater () {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SettingsActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.newdrinkpopup, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        final AlertDialog alertDialogs = dialogBuilder.create();
        alertDialogs.show();
        TextView Hi = dialogView.findViewById(R.id.Description);
        Hi.setText("Place the tube into the bottle of water");
        Change += 1;

        if (Change == 2){
            Hi.setText("Place the tube into the new bottle");
        }
        Button CreateButton = dialogView.findViewById(R.id.changedbtn);
        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogs.dismiss();
                showPopupLoading();
            }
        });
    }

}