package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class LeirasKettoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leiras_ketto);

        Button nextButton = findViewById(R.id.nexttoquestion2);

        nextButton.setOnClickListener(view ->{

        });
    }
}