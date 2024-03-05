package com.example.picknmixologist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 1; i < 6; i++){
            PutRequest.changeStatusOff(MainActivity.this, i);
        };
        Button MYObtn = findViewById(R.id.naviagtebtn);
        MYObtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MYOActivity.class);
                startActivity(intent);
            }
        });

        Button Databasebtn = findViewById(R.id.databasebtn);
        Databasebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CocktailsActivity.class);
                startActivity(intent);
            }
        });
        Button Settingbtn = findViewById(R.id.Settingbtn);
        Settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });



    }
}