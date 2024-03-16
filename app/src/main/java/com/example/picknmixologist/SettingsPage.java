package com.example.picknmixologist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SettingsPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingspage);


        Spinner spinnerMachine = findViewById(R.id.spinnerMachine);
        String[] items = new String[]{"Machine", "Configuration", "What is it"}; // 0: Title, 1 & 2: Items
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, android.R.layout.simple_spinner_item, items);
        spinnerMachine.setAdapter(adapter);

        spinnerMachine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Avoid actions on the title selection
                if (position == 0) {
                    // Optionally reset spinner to title after selection
                    spinnerMachine.setSelection(0);
                    return;
                }

                Intent intent;
                if (position == 1) {
                    // Configuration selected
                    intent = new Intent(getApplicationContext(), SettingsActivity.class);
                } else {
                    // What is it selected
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                }
                startActivity(intent);
                // Optionally reset spinner to title after selection
                spinnerMachine.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }
        public class CustomSpinnerAdapter extends ArrayAdapter<String> {
            private Context context;
            private String[] values;
            private LayoutInflater inflater;

            public CustomSpinnerAdapter(@NonNull Context context, int resource, String[] values) {
                super(context, resource, values);
                this.context = context;
                this.values = values;
                inflater = LayoutInflater.from(context);
            }

            @Override
            public boolean isEnabled(int position) {
                // Make the first item (Machine) non-selectable
                return position != 0;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView label = (TextView) super.getView(position, convertView, parent);
                label.setTextColor(Color.BLACK);
                if (position == 0) {
                    label.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20); // Title size
                } else {
                    label.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20); // Item size
                }
                return label;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView label = (TextView) super.getDropDownView(position, convertView, parent);
                if (position == 0) {
                    label.setBackground(new ColorDrawable(Color.parseColor("#80FFFFFF"))); // Semi-transparent background for title
                } else {
                    label.setBackground(new ColorDrawable(Color.parseColor("#80FFFFFF"))); // Semi-transparent background for items
                }
                label.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20); // Dropdown items size
                return label;
            }


    }
}
