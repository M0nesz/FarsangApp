package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LeirasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leiras_activity);

        Button start_Button = findViewById(R.id.next);
        start_Button.setOnClickListener(view ->{
            Intent intent = new Intent(LeirasActivity.this, QuizzFirstactivity.class);
            startActivity(intent);
        });
    }
}