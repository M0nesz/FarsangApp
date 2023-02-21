package com.example.farsangapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class FirstQuestion extends AppCompatActivity {
    boolean farsangFarkaChecked;
    boolean rioiKarnevalChecked;
    boolean mohacsiBusojarasChecked;

    public void openLeirasKettoActivity(){
        Intent intent = new Intent(FirstQuestion.this, SecondQuestion.class);
        startActivity(intent);
    }

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

        if (farsangFarka.isChecked() && rioiKarneval.isChecked() && mohacsiBusojaras.isChecked() ){
            farsangFarkaChecked = true;
            rioiKarnevalChecked = true;
            mohacsiBusojarasChecked = true;
            openLeirasKettoActivity();
        } else if (farsangFarka.isChecked() && mohacsiBusojaras.isChecked() ) {
            farsangFarkaChecked = true;
            mohacsiBusojarasChecked = true;
            openLeirasKettoActivity();
        } else if (rioiKarneval.isChecked() && mohacsiBusojaras.isChecked()) {
            rioiKarnevalChecked = true;
            mohacsiBusojarasChecked = true;
            openLeirasKettoActivity();
        } else if (farsangFarka.isChecked() && rioiKarneval.isChecked()) {
            rioiKarnevalChecked = true;
            farsangFarkaChecked = true;
            openLeirasKettoActivity();
        } else if (farsangFarka.isChecked()) {
            farsangFarkaChecked = true;
            openLeirasKettoActivity();
        } else if (rioiKarneval.isChecked()) {
            rioiKarnevalChecked = true;
            openLeirasKettoActivity();
        } else if (mohacsiBusojaras.isChecked()) {
            mohacsiBusojarasChecked = true;
            openLeirasKettoActivity();
        } else {
            errorText.setVisibility(View.VISIBLE);
            farsangFarkaChecked = false;
            rioiKarnevalChecked = false;
            mohacsiBusojarasChecked = false;
        }});
    }
}