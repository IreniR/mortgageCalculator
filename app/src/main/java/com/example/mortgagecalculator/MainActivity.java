package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //requesting the action to start the end-user enter the calculate mortgage page
        Intent intent = new Intent(this, calculateMortgage.class);
        startActivity(intent);
    }
}