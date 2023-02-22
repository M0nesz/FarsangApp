package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.IOException;


public class ThirdQuestion extends AppCompatActivity {
    boolean igenIsChecked;
    boolean nemIsChecked;
    String filename = "thirdquestion";

    public void openNextQuestionActivity(){
        Intent intent = new Intent(ThirdQuestion.this, FourthQuestion.class);
        startActivity(intent);
        try (FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE)) {
            String data = igenIsChecked + "," + nemIsChecked;
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_question);
        Button nextButton = findViewById(R.id.next);
        TextView errorText = findViewById(R.id.error);
        errorText.setVisibility(View.INVISIBLE);
        TextView errorText2 = findViewById(R.id.error2);
        errorText2.setVisibility(View.INVISIBLE);
        CheckBox igen = findViewById(R.id.igen);
        CheckBox nem = findViewById(R.id.nem);


        nextButton.setOnClickListener(view ->{
            if (igen.isChecked() && nem.isChecked()){
                errorText.setVisibility(View.VISIBLE);
                errorText.setText("Csak egy opciót válassz!");
            } else if (igen.isChecked()) {
                igenIsChecked = true;
                openNextQuestionActivity();
            } else if (nem.isChecked()) {
                nemIsChecked = true;
                openNextQuestionActivity();
            }else{
                errorText.setVisibility(View.VISIBLE);
                errorText.setText("Válassz egy opciót!");

            }


        });
    }
}