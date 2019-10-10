package com.example.myhouse;

import android.content.Intent;
import android.os.Bundle;

import com.example.myhouse.Card.CardAnalysis;
import com.example.myhouse.CardApi.CardAPITest;
import com.example.myhouse.CardApi.util.CommonConstant;
import com.example.myhouse.CardApi.util.RequestToken;

import com.example.myhouse.user.UserVO;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Fragment_Map fragment_map;
    Fragment_coupon fragment_coupon;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.map:
                    transaction.replace(R.id.frame_container, fragment_map).commitAllowingStateLoss();
                    return true;

                case R.id.coupon:
                    transaction.replace(R.id.frame_container, fragment_coupon).commitAllowingStateLoss();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        new Thread() {
            public void run() {
                getLocation("화양동");
            }
        }.start();

        fragment_map = new Fragment_Map();
        // fragment_coupon = new Fragment_coupon();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_container, fragment_map).commit();

        Intent intent = new Intent(this, folderActivity.class);
        startActivity(intent);

        ((Button) findViewById(R.id.card)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(), graphActivity.class);
                startActivity(intent);

            }
        });
    }

    public String getLocation(String address){
        URL url = null;
        String result = null;
        try {
            url = new URL("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode" + "?query=" + address);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "5phvyfpjfq");
            huc.setRequestProperty("X-NCP-APIGW-API-KEY", "qezQ3wQdbIFdtckGU7hCIaYUQqdkuBW71taQ9vKV");
            int requestCode = huc.getResponseCode();
            BufferedReader reader;
            if (requestCode == 200) {
                reader = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(huc.getErrorStream()));
            }

            String inputLine;
            StringBuffer buffer = new StringBuffer();
            while ((inputLine = reader.readLine()) != null) {
                buffer.append(inputLine);
            }
            if (reader != null)
                reader.close();

            result = buffer.toString();
            Log.d("결과", result);


        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return result;
    }

//    Handler handler = new Handler() {
//        public void handleMessage(Message msg) {
//            Bundle bun = msg.getData();
//            String token = bun.getString("token");
//            Log.d("토큰", token);
//        }
//    };
    

}
