package com.example.picknmixologist;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

import java.util.Timer;

public class MYOActivity extends AppCompatActivity {
    private int url2;
    private SeekBar slider;

    private CountDownTimer countDownTimer1, countDownTimer2, countDownTimer3, countDownTimer4, countDownTimer5, countDownTimer6;
    public int[] Shots = {0,0,0,0,0,0};
    private TextView Shots1;
    private TextView progressText, progressText2, progressText3, progressText4, progressText5, progressText6;
    private int Pump1;
    private int Pump2;
    private int Pump3;
    private int Pump4;
    private int Pump5;
    private int Pump6;
    private int Pumps = 0;

    private int Timers = 0;
    public int OnPumps = 0;
    public int OffPumps = 0;
    private Button sendButton;




    public void onButtonClick() {
        PutRequest.changeStatusOff(this, OffPumps);
        Pumps -=1;
        System.out.println("The pump is: " + Pumps);

    }
    public void onButtonClick2() {
        PutRequest.changeStatusOn(this, OnPumps);
        Pumps +=1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myo);

        String[] Drinks = PutRequest.Drinks;
        TextView Pump1txt = findViewById(R.id.Pump1txt);
        Pump1txt.setText(Drinks[1]);
        TextView Pump2txt = findViewById(R.id.Pump2txt);
        Pump2txt.setText(Drinks[2]);
        TextView Pump3txt = findViewById(R.id.Pump3txt);
        Pump3txt.setText(Drinks[3]);
        TextView Pump4txt = findViewById(R.id.Pump4txt);
        Pump4txt.setText(Drinks[4]);
        TextView Pump5txt = findViewById(R.id.Pump5txt);
        Pump5txt.setText(Drinks[5]);
        TextView Pump6txt = findViewById(R.id.Pump6txt);
        Pump6txt.setText(Drinks[6]);



        //Slider for pump1
        slider = findViewById(R.id.Pump1s);
        progressText = findViewById(R.id.Pump1Shots);
        TextView Shot1 = findViewById(R.id.Pump1Shots);
        fetchData myAsyncTask = new fetchData(Shot1);
        myAsyncTask.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText.setText("Shots: " + progress);
                Pump1 = progress;
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
        slider = findViewById(R.id.Pump2s);
        progressText2 = findViewById(R.id.Pump2Shots);
        TextView Shot2 = findViewById(R.id.Pump2Shots);
        fetchData Task2 = new fetchData(Shot2);
        Task2.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText2.setText("Shots: " + progress);
                Pump2 = progress;
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
        slider = findViewById(R.id.Pump3s);
        progressText3 = findViewById(R.id.Pump3Shots);
        TextView Shot3 = findViewById(R.id.Pump3Shots);
        fetchData Task3 = new fetchData(Shot3);
        Task3.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText3.setText("Shots: " + progress);
                Pump3 = progress;
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
        slider = findViewById(R.id.Pump4s);
        progressText4 = findViewById(R.id.Pump4Shots);
        TextView Shot4 = findViewById(R.id.Pump4Shots);
        fetchData Task4 = new fetchData(Shot4);
        Task4.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText4.setText("Shots: " + progress);
                Pump4 = progress;
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
        slider = findViewById(R.id.Pump5s);
        progressText5 = findViewById(R.id.Pump5Shots);
        TextView Shot5 = findViewById(R.id.Pump5Shots);
        fetchData Task5 = new fetchData(Shot5);
        Task5.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText5.setText("Shots: " + progress);
                Pump5 = progress;

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
        slider = findViewById(R.id.Pump6s);
        progressText6 = findViewById(R.id.Pump6Shots);
        TextView Shot6 = findViewById(R.id.Pump6Shots);
        fetchData Task6 = new fetchData(Shot6);
        Task6.execute();
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update the TextView to show the current progress
                progressText6.setText("Shots: " + progress);
                Pump6 = progress;

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

        Button cocktailbtn = findViewById(R.id.Sendbtn);
        cocktailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int durationInMillis = 15000; // 6 seconds
                Shots[0] = durationInMillis * Pump1;
                Shots[1] = durationInMillis * Pump2;
                Shots[2] = durationInMillis * Pump3;
                Shots[3] = durationInMillis * Pump4;
                Shots[4] = durationInMillis * Pump5;
                Shots[5] = durationInMillis * Pump6;

                //to stop glitches
                for(int i = 0; i > Shots.length; i++){
                    if (Shots[i] == 0){
                        Shots[i] = 10;
                    }
                }

                showPopupDialog();


                //tempoary
                String hi = String.valueOf(Shots[0]) + String.valueOf(Shots[1]) + String.valueOf(Shots[2]) + String.valueOf(Shots[3]) + String.valueOf(Shots[4]) + String.valueOf(Shots[5]) ;
                Toast.makeText(MYOActivity.this, hi , Toast.LENGTH_SHORT).show();


            }

        @SuppressLint("MissingInflatedId")
        private void showPopupDialog() {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MYOActivity.this);
            View dialogView = getLayoutInflater().inflate(R.layout.shotpopup, null);

            dialogBuilder.setView(dialogView);
            Shots1 = dialogView.findViewById(R.id.Pump1s);
            Shots1.setText(String.valueOf(Pump1));
            Shots1 = dialogView.findViewById(R.id.Pump2s);
            Shots1.setText(String.valueOf(Pump2));
            Shots1 = dialogView.findViewById(R.id.Pump3s);
            Shots1.setText(String.valueOf(Pump3));
            Shots1 = dialogView.findViewById(R.id.Pump4s);
            Shots1.setText(String.valueOf(Pump4));
            Shots1 = dialogView.findViewById(R.id.Pump5s);
            Shots1.setText(String.valueOf(Pump5));
            Shots1 = dialogView.findViewById(R.id.Pump6s);
            Shots1.setText(String.valueOf(Pump6));


            final AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
            Button closeButton = dialogView.findViewById(R.id.button1);
            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            Button CreateButton = dialogView.findViewById(R.id.button2);
            CreateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    showPopupLoading();
                }
            });





        }
            @SuppressLint("MissingInflatedId")
            private void showPopupLoading() {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MYOActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.loadingpopup, null);
                dialogBuilder.setView(dialogView);
                final AlertDialog alertDialogs = dialogBuilder.create();
                alertDialogs.show();

                countDownTimer1 = new CountDownTimer(Shots[0], 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {}
                    @Override
                    public void onFinish() {OffPumps = 1; onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(MYOActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
                };
                countDownTimer2 = new CountDownTimer(Shots[1], 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {}
                    @Override
                    public void onFinish() {OffPumps = 2; onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(MYOActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
                };
                countDownTimer3 = new CountDownTimer(Shots[2], 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {}
                    @Override
                    public void onFinish() {OffPumps = 3;  onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(MYOActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
                };
                countDownTimer4 = new CountDownTimer(Shots[3], 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {}
                    @Override
                    public void onFinish() {OffPumps = 4; onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(MYOActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
                };
                countDownTimer5 = new CountDownTimer(Shots[4], 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {}
                    @Override
                    public void onFinish() {OffPumps = 5; onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(MYOActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
                };
                countDownTimer6 = new CountDownTimer(Shots[5], 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {}
                    @Override
                    public void onFinish() {OffPumps = 6; onButtonClick(); if(Pumps == 0){alertDialogs.dismiss(); Toast.makeText(MYOActivity.this, "Your Drink is Ready" , Toast.LENGTH_SHORT).show();}}
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

        });


    }

}