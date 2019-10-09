package com.example.myhouse;

import android.content.Intent;
import android.os.Bundle;

import com.example.myhouse.CardApi.CardAPITest;
import com.example.myhouse.CardApi.util.CommonConstant;
import com.example.myhouse.CardApi.util.RequestToken;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.map:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.coupon:
                    mTextMessage.setText(R.string.title_dashboard);
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
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        new Thread() {
            public void run() {
                getLocation("화양동");
            }
        }.start();

//        new Thread() {
//            public void run() {
//                String token = null;
//                CardAPITest cardAPITest = new CardAPITest();
//                try {
//                    token = cardAPITest.test();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                Bundle bun = new Bundle();
//                bun.putString("token", token);
//
//                Message msg = handler.obtainMessage();
//                msg.setData(bun);
//                handler.sendMessage(msg);
//            }
//        }.start();
//
//        Intent intent = new Intent(this, folderActivity
//                .class);
//        startActivity(intent);
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
