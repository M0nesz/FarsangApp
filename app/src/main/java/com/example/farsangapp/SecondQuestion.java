package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class SecondQuestion extends AppCompatActivity {
    boolean levendulaChecked;
    boolean bokretaChecked;
    boolean kalacsChecked;
    public void openThirdQuestionActivity(){
        Intent intent = new Intent(SecondQuestion.this, ThirdQuestion.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_question);
        CheckBox levendula = findViewById(R.id.levendula);
        CheckBox bokreta = findViewById(R.id.bokreta);
        CheckBox kalacs = findViewById(R.id.kalacs);
        Button nextButton = findViewById(R.id.next);
        TextView errorText = findViewById(R.id.error);
        errorText.setVisibility(View.INVISIBLE);

        nextButton.setOnClickListener(view ->{

            if (levendula.isChecked() && bokreta.isChecked() && kalacs.isChecked() ){
                levendulaChecked = true;
                bokretaChecked = true;
                kalacsChecked = true;
                openThirdQuestionActivity();
            } else if (levendula.isChecked() && kalacs.isChecked() ) {
                levendulaChecked = true;
                kalacsChecked = true;
                openThirdQuestionActivity();
            } else if (bokreta.isChecked() && kalacs.isChecked()) {
                bokretaChecked = true;
                kalacsChecked = true;
                openThirdQuestionActivity();
            } else if (levendula.isChecked() && bokreta.isChecked()) {
                bokretaChecked = true;
                levendulaChecked = true;
                openThirdQuestionActivity();
            } else if (levendula.isChecked()) {
                levendulaChecked = true;
                openThirdQuestionActivity();
            } else if (bokreta.isChecked()) {
                bokretaChecked = true;
                openThirdQuestionActivity();
            } else if (kalacs.isChecked()) {
                kalacsChecked = true;
                openThirdQuestionActivity();
            } else {
                errorText.setVisibility(View.VISIBLE);
                levendulaChecked = false;
                bokretaChecked = false;
                kalacsChecked = false;
            }});
    }
}