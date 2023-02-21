package com.example.farsangapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class FifthQuestion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_question);
        EditText valasz = findViewById(R.id.valasz);
        Button nextButton = findViewById(R.id.next);
        TextView error = findViewById(R.id.error);
        error.setVisibility(View.INVISIBLE);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation");
        builder.setMessage("Ez volt az utolsó kérdés. Szeretnéd folytatni? ");

        builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(FifthQuestion.this, FinalPage.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });




        nextButton.setOnClickListener(view->{
            Log.d("FourthQuestion", "Tovább gomb lenyomva");
            String userinputonfifth = String.valueOf(valasz.getText());
            Log.d("FourthQuestion", "userimput= "+ userinputonfifth);

            if (!userinputonfifth.equals("")){
                if (userinputonfifth.matches("^\\p{L}*$")){
                    if (userinputonfifth.length()<15){
                        AlertDialog dialog = builder.create();
                        dialog.show();
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