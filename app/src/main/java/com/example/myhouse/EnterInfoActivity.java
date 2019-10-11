package com.example.myhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class EnterInfoActivity extends AppCompatActivity {
    CheckBox checkBox1;
    CheckBox checkBox2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);

        btn = findViewById(R.id.btn_next);
        checkBox1 = (CheckBox) findViewById(R.id.check1) ;
        checkBox2 = (CheckBox) findViewById(R.id.check2) ;

        checkBox1.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : process the click event.
                if (checkBox1.isChecked() && checkBox2.isChecked())
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);
            }
        }) ;


        checkBox2.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked() && checkBox2.isChecked())
                    btn.setEnabled(true);
                else
                btn.setEnabled(false);
            }
        }) ;

    }

    public void nextClicked(View view) {
        String name = ((EditText)findViewById(R.id.input_name)).getText().toString();
        String birth = ((EditText)findViewById(R.id.input_birth)).getText().toString();

        if(name.isEmpty() || birth.isEmpty()){
            Toast.makeText(this, "이름과 생년월일을 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences preferences = EnterInfoActivity.this.getSharedPreferences("preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor user_editor = preferences.edit();

        user_editor.putString("name", name);
        user_editor.putString("birth", birth);

        user_editor.commit();

        Intent intent = new Intent(this, folderActivity.class);
        startActivity(intent);
    }
}
