package com.example.picknmixologist;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CocktailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktails);

        Button dropdownButton1 = findViewById(R.id.dropdown_button1);
        Button dropdownButton2 = findViewById(R.id.dropdown_button2);
        Button dropdownButton3 = findViewById(R.id.dropdown_button3);
        Button dropdownButton4 = findViewById(R.id.dropdown_button4);

        dropdownButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDropdownMenu(v);
            }
        });

        dropdownButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDropdownMenu(v);
            }
        });

        dropdownButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDropdownMenu(v);
            }
        });

        dropdownButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDropdownMenu(v);
            }
        });
    }
    private void showDropdownMenu(View anchorView) {
        View popupView = getLayoutInflater().inflate(R.layout.dropdown_items, null);

        // Create a PopupWindow with the layout and set its properties
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        // Set background color and animation style (optional)
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);

        // Show the popup window below the anchor view
        popupWindow.showAsDropDown(anchorView);

        // Optionally, handle item clicks
        TextView item1 = popupView.findViewById(R.id.item1);
        TextView item2 = popupView.findViewById(R.id.item2);
        TextView item3 = popupView.findViewById(R.id.item3);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item 1 click
                // For example, you can set a TextView text to "Item 1 clicked"
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item 2 click
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item 3 click
            }
        });
    }

}
