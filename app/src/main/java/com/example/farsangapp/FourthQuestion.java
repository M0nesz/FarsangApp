package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class FourthQuestion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_question);
        EditText valasz = findViewById(R.id.valasz);
        String userinput = String.valueOf(valasz.getText());
        Button nextButton = findViewById(R.id.next);
        TextView error = findViewById(R.id.error);
        error.setVisibility(View.INVISIBLE);

        if (userinput instanceof String){
            if (userinput.length()<15){

            }else{
                error.setText("Válasz nem lehet hosszabb mint 15 karakter!");
            }
        }else{
            error.setText("Szöveget adj meg!");
        }

    }
}