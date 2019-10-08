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

import java.io.IOException;

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
                String token = null;
                CardAPITest cardAPITest = new CardAPITest();
                try {
                    token = cardAPITest.test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Bundle bun = new Bundle();
                bun.putString("token", token);

                Message msg = handler.obtainMessage();
                msg.setData(bun);
                handler.sendMessage(msg);
            }
        }.start();

        Intent intent = new Intent(this, folderActivity
                .class);
        startActivity(intent);


    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            Bundle bun = msg.getData();
            String token = bun.getString("token");
            Log.d("토큰", token);
        }
    };



}
