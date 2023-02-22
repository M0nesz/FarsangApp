package com.example.farsangapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FinalPage extends AppCompatActivity {
    String filename = "firstquestion";
    String filename2 = "secondquestion";
    String filename3 = "thirdquestion";
    String filename4 = "fourthquestion";
    String filename5 = "fifthquestion";
    boolean farsangFarkaChecked;
    boolean rioiKarnevalChecked;
    boolean mohacsiBusojarasChecked;
    boolean levendulaChecked;
    boolean bokretaChecked;
    boolean kalacsChecked;
    boolean igenIsChecked;
    boolean nemIsChecked;
    String userinputonFourth;
    String userinputonfifth;


    public void readFirst(){

        try (FileInputStream fis = openFileInput(filename)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            String data = new String(buffer);
            String[] parts = data.split(",");
            if (parts.length == 3) {
                farsangFarkaChecked = Boolean.parseBoolean(parts[0]);
                rioiKarnevalChecked = Boolean.parseBoolean(parts[1]);
                mohacsiBusojarasChecked = Boolean.parseBoolean(parts[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readSecond(){

        try (FileInputStream fis = openFileInput(filename2)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            String data = new String(buffer);
            String[] parts = data.split(",");
            if (parts.length == 3) {
                levendulaChecked = Boolean.parseBoolean(parts[0]);
                bokretaChecked = Boolean.parseBoolean(parts[1]);
                kalacsChecked = Boolean.parseBoolean(parts[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readThird(){

        try (FileInputStream fis = openFileInput(filename3)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            String data = new String(buffer);
            String[] parts = data.split(",");
            if (parts.length == 2) {
                igenIsChecked = Boolean.parseBoolean(parts[0]);
                nemIsChecked = Boolean.parseBoolean(parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFourth(){

        try (FileInputStream fis = openFileInput(filename4)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            String data = new String(buffer);
            String[] parts = data.split(",");
            if (parts.length == 1) {
                userinputonFourth = parts[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFifth(){

        try (FileInputStream fis = openFileInput(filename5)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            String data = new String(buffer);
            String[] parts = data.split(",");
            if (parts.length == 1) {
                userinputonfifth = parts[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class TwoColumnListAdapter extends ArrayAdapter<String> {
        private List<String> items1;
        private List<String> items2;

        public TwoColumnListAdapter(Context context, List<String> items1, List<String> items2) {
            super(context, R.layout.two_column_list_item, items1);
            this.items1 = items1;
            this.items2 = items2;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View rowView = inflater.inflate(R.layout.two_column_list_item, parent, false);

            TextView textView1 = rowView.findViewById(R.id.textView1);
            TextView textView2 = rowView.findViewById(R.id.textView2);

            textView1.setText(items1.get(position));
            textView2.setText(items2.get(position));

            return rowView;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalpage);
        readFirst();
        readSecond();
        readThird();
        readFourth();
        readFifth();
        List<String> items = new ArrayList<>();
        List<String> items2 = new ArrayList<>();

        items.add("Első kérdés: \n \n Mi Magyarország legnevezetesebb farsangi eseménye?  \n \n Farkas farka: " + farsangFarkaChecked + " \n \n Riói karnevál: " + rioiKarnevalChecked + "  \n \n Mohácsi busójárás: " + mohacsiBusojarasChecked);
        items.add("Második kérdés:  \n \n Hogy hívják azt amit a fiúk a kalapjukra tűznek Farsang vasárnap?  \n \n.. Levendula: " + levendulaChecked + " \n \n Bokréta: " + bokretaChecked + "  \n \n Kalács: " + kalacsChecked);
        items.add("Harmadik kérdés:  \n \n Vallási ünnep-e a Farsang?  \n \n Igen: " + igenIsChecked + "  \n \n Nem: " + nemIsChecked);
        items.add("Negyedik kérdés:  \n \n Hogy hívják a szalmabábút amit Húshagyókedden készítenek?  \n \n Te válaszod: " + userinputonFourth);
        items.add("Ötödik kérdés:  \n \n Hány nappal előzi meg Húshagyókedd a Húsvétot?  \n \n Te válaszod: " + userinputonfifth);

        items2.add("Helyes válasz: Mohácsi busójárás");
        items2.add("Helyes válasz: Bokréta");
        items2.add("Helyes válasz: Nem");
        items2.add("Helyes válasz: Kisze");
        items2.add("Helyes válasz: 47 nap");

        ListView listView = findViewById(R.id.listView);
        TwoColumnListAdapter adapter = new TwoColumnListAdapter(this, items, items2);
        listView.setAdapter(adapter);

    }
}