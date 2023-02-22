package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.IOException;

public class FourthQuestion extends AppCompatActivity {

    String userinputonFourth;
    String filename = "fourthquestion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_question);
        EditText valasz = findViewById(R.id.valasz);
        Button nextButton = findViewById(R.id.next);
        TextView error = findViewById(R.id.error);
        error.setVisibility(View.INVISIBLE);

        nextButton.setOnClickListener(view->{
            Log.d("FourthQuestion", "Tovább gomb lenyomva");
            userinputonFourth = String.valueOf(valasz.getText());
            Log.d("FourthQuestion", "userimput= "+ userinputonFourth);

            if (!userinputonFourth.equals("")){
                if (userinputonFourth.matches("^\\p{L}*$")){
                    if (userinputonFourth.length()<15){
                        Intent intent = new Intent(FourthQuestion.this, FifthQuestion.class);
                        startActivity(intent);
                        try (FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE)) {
                            String data = userinputonFourth;
                            fos.write(data.getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }else{
                        error.setText("Válasz nem lehet hosszabb mint 15 karakter!");
                        error.setVisibility(View.VISIBLE);
                    }
                }else{
                    error.setText("Szöveget adj meg!");
                    error.setVisibility(View.VISIBLE);
                }
            }else{
                error.setText("Adj meg egy választ!");
                error.setVisibility(View.VISIBLE);
            }

        });
    }
}