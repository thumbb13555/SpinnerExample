package com.jetec.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Boolean firstTime = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = findViewById(R.id.spinnerEX1);
        Spinner spinner2 = findViewById(R.id.spinnerEX2);
        Button btAdd = findViewById(R.id.buttonADD);
        Button btRemove = findViewById(R.id.buttonRemove);

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this
                ,R.array.planets_array,android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);


        ArrayList arrayList = new ArrayList<Integer>();
        for (int i = 0;i<5;i++){
            arrayList.add(i);
        }
        ArrayAdapter adapter2 = new  ArrayAdapter(this
                ,android.R.layout.simple_dropdown_item_1line,arrayList);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (firstTime){firstTime = false;}
                else{
                    Toast.makeText(view.getContext(),parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btAdd.setOnClickListener((v)->{
            arrayList.add(arrayList.size());
        });
        btRemove.setOnClickListener((v -> {
            if (arrayList.size()!=0){
                arrayList.remove(arrayList.size()-1);
            }
        }));


    }
}
