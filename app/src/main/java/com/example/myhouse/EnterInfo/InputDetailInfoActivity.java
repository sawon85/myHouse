package com.example.myhouse.EnterInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myhouse.MainActivity;
import com.example.myhouse.R;
import com.example.myhouse.user.UserConstant;
import com.example.myhouse.user.UserVO;

public class InputDetailInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_detail_info);
    }

    public void btnClicked(View view) {
        Spinner marrySpinner =  findViewById(R.id.marry_spinner);
        Spinner jobSpinner = findViewById(R.id.job_spinner);
        Spinner childrenSpinner = findViewById(R.id.children_spinner);
        EditText property = findViewById(R.id.input_property);
        EditText deposit = findViewById(R.id.input_deposit);
        EditText salary = findViewById(R.id.input_salary);
        EditText resLoan = findViewById(R.id.input_resLoan);
        CheckBox hasHouseCheck = findViewById(R.id.hasHouseCheckBox);
        Spinner creditSpinner = findViewById(R.id.credit_spinner);

        if(property.getText().toString().isEmpty() || deposit.getText().toString().isEmpty() ||
                salary.getText().toString().isEmpty() || resLoan.getText().toString().isEmpty() ){
            Toast.makeText(InputDetailInfoActivity.this, "정보를 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if(marrySpinner.getSelectedItem().toString().equals("미혼"))
            UserVO.getInstance().marryState = UserConstant.notMarried;
        else if(marrySpinner.getSelectedItem().toString().equals("신혼"))
            UserVO.getInstance().marryState = UserConstant.newlyMarried;
        else if(marrySpinner.getSelectedItem().toString().equals("기혼"))
            UserVO.getInstance().marryState = UserConstant.married;

        if(jobSpinner.getSelectedItem().toString().equals("미취업"))
            UserVO.getInstance().jobState = UserConstant.jobSeeker;
        else if(jobSpinner.getSelectedItem().toString().equals("중소기업 재직"))
            UserVO.getInstance().jobState = UserConstant.smallBusinessMan;
        else if(jobSpinner.getSelectedItem().toString().equals("대기업 재직"))
            UserVO.getInstance().jobState = UserConstant.largeBusinessMan;
        else if(jobSpinner.getSelectedItem().toString().equals("개인사업"))
            UserVO.getInstance().jobState = UserConstant.businessCEO;

        UserVO.getInstance().childrenNumber = childrenSpinner.getSelectedItemPosition();

        UserVO.getInstance().property = Integer.parseInt(property.getText().toString());

        UserVO.getInstance().deposit = Integer.parseInt(deposit.getText().toString());

        UserVO.getInstance().salary = Integer.parseInt(salary.getText().toString());

        UserVO.getInstance().resLoan = Integer.parseInt(resLoan.getText().toString());

        if(hasHouseCheck.isChecked())
            UserVO.getInstance().hasHouse = true;
        else
            UserVO.getInstance().hasHouse = false;

        UserVO.getInstance().credit = creditSpinner.getSelectedItemPosition()+1;

        SharedPreferences preferences = InputDetailInfoActivity.this.getSharedPreferences("preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor user_editor = preferences.edit();

        user_editor.putString("finish", "finish");
        user_editor.commit();
        Intent intent = new Intent(InputDetailInfoActivity.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }
}
