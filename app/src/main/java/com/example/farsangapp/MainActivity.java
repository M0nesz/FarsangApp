package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_Button = findViewById(R.id.start);
        start_Button.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, LeirasActivity.class);
            startActivity(intent);
        });
    }
}