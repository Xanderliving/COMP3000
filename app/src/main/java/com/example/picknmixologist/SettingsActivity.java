package com.example.picknmixologist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity {
    int option = 1;
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
                TextView NewDrink = findViewById(R.id.newDrinktxt);
                String NewDrinks = NewDrink.getText().toString();
                PutRequest.Drinks[option] = NewDrinks;
                PutRequest.changeStatusOff(SettingsActivity.this, option);


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
                if ("Pump 1".equals(selectedOption)) {OldDrink.setText(Drinks[1]); option = 1;}
                if ("Pump 2".equals(selectedOption)) {OldDrink.setText(Drinks[2]); option = 2;}
                if ("Pump 3".equals(selectedOption)) {OldDrink.setText(Drinks[3]); option = 3;}
                if ("Pump 4".equals(selectedOption)) {OldDrink.setText(Drinks[4]); option = 4;}
                if ("Pump 5".equals(selectedOption)) {OldDrink.setText(Drinks[5]); option = 5;}
                if ("Pump 6".equals(selectedOption)) {OldDrink.setText(Drinks[6]); option = 6;}

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });

    }
}