package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuizzFirstactivity extends AppCompatActivity {
    boolean farsangFarkaChecked;
    boolean rioiKarnevalChecked;
    boolean mohacsiBusojarasChecked;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizz_first_page);
        CheckBox farsangFarka = findViewById(R.id.farsang_farka);
        CheckBox rioiKarneval = findViewById(R.id.rioi_karneval);
        CheckBox mohacsiBusojaras = findViewById(R.id.mohacsi_busojaras);
        Button nextButton = findViewById(R.id.next);
        TextView errorText = findViewById(R.id.error);
        errorText.setVisibility(View.INVISIBLE);


        nextButton.setOnClickListener(view ->{
        if (farsangFarka.isChecked()){
            farsangFarkaChecked = true;
        } else if (rioiKarneval.isChecked()) {
            rioiKarnevalChecked = true;
        } else if (mohacsiBusojaras.isChecked()) {
            mohacsiBusojarasChecked = true;
        }
        else{
            errorText.setVisibility(View.VISIBLE);
            farsangFarkaChecked = false;
            rioiKarnevalChecked = false;
            mohacsiBusojarasChecked = false;
        }
        });

    }
}