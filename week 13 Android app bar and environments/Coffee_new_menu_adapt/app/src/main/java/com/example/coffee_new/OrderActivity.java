package com.example.coffee_new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //get toolbar and set it as the app bar
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        //enable the up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
