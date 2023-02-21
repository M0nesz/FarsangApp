package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ThirdQuestion extends AppCompatActivity {

    public void openThirdQuestionActivity(){
        //Intent intent = new Intent(SecondQuestion.this, ThirdQuestion.class);
        //startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_question);
        Button nextButton = findViewById(R.id.next);
        TextView errorText = findViewById(R.id.error);
        errorText.setVisibility(View.INVISIBLE);


    }
}