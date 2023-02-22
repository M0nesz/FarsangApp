package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class LeirasKettoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leiras_ketto);

        Button nextButton = findViewById(R.id.next);

        nextButton.setOnClickListener(view ->{
            Intent intent = new Intent(LeirasKettoActivity.this, LeirasThird.class);
            startActivity(intent);
        });
        Button vissza_Button = findViewById(R.id.vissza);
        vissza_Button.setOnClickListener(view ->{
            Intent intent = new Intent(LeirasKettoActivity.this, LeirasActivity.class);
            startActivity(intent);
        });
    }
}