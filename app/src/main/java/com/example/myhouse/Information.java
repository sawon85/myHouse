package com.example.myhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);


        ((Button)findViewById(R.id.request)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();

            }
        });


        ((Button)findViewById(R.id.cancel)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();

            }
        });

    }
}
