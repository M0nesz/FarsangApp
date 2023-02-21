package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class LeirasThird extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdleiras);

        Button nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(view ->{
            Intent intent = new Intent(LeirasThird.this, QuizzFirstactivity.class);
            startActivity(intent);
        });

    }
}