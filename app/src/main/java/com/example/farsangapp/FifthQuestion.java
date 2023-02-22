package com.example.farsangapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
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

public class FifthQuestion extends AppCompatActivity {

    String userinputonfifth;
    String filename = "fifthquestion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_question);
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
                try (FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE)) {
                    String data = userinputonfifth;
                    fos.write(data.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
            userinputonfifth = String.valueOf(valasz.getText());
            Log.d("FourthQuestion", "userimput= "+ userinputonfifth);

            if (!userinputonfifth.equals("")){
                {
                    if (userinputonfifth.length()<15){
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }else{
                        error.setText("Válasz nem lehet hosszabb mint 15 karakter!");
                        error.setVisibility(View.VISIBLE);
                    }
                }
            }else{
                error.setText("Adj meg egy választ!");
                error.setVisibility(View.VISIBLE);
            }

        });
    }
}