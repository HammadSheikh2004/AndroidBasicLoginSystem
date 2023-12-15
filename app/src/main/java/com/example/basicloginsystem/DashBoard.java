package com.example.basicloginsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        text = findViewById(R.id.text);
        String getEmail = getIntent().getStringExtra("email");
        text.setText(getEmail);
    }
}