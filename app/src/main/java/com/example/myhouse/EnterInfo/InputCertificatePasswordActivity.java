package com.example.myhouse.EnterInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myhouse.CardApi.util.AccountTest;
import com.example.myhouse.CardApi.util.CommonConstant;
import com.example.myhouse.MainActivity;
import com.example.myhouse.R;
import com.example.myhouse.graphActivity;
import com.example.myhouse.user.UserVO;

public class InputCertificatePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_certificate_password);

        Button nextButton = findViewById(R.id.btn_next_);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d("ㅁㄴ이ㅓㄹㄴ아", "dhodaslkdfj");
//                EditText password = findViewById(R.id.input_password_);
//
//                if(password.getText().toString().isEmpty()){
//                    Toast.makeText(InputCertificatePasswordActivity.this, "비밀번호를 입력해 주세요", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                new Thread() {
//                    public void run() {
//                        AccountTest accountTest = new AccountTest(password.getText().toString(), UserVO.getInstance().birth);
//                        try {
//                            accountTest.create("BK",CommonConstant.BK_NH, UserVO.getInstance().BKconnectedID);
//                            accountTest.create("BK",CommonConstant.BK_KB, UserVO.getInstance().BKconnectedID);
//                            accountTest.create("BK",CommonConstant.BK_SH, UserVO.getInstance().BKconnectedID);
//                            accountTest.create("BK",CommonConstant.BK_URI, UserVO.getInstance().BKconnectedID);
//
//                            for(String connect : UserVO.getInstance().BKconnectedID)
//                                System.out.println(connect);
//
//                            accountTest.create("CD", CommonConstant.CD_NH, UserVO.getInstance().CDconnectedID);
//                            accountTest.create("CD",CommonConstant.CD_KB, UserVO.getInstance().CDconnectedID);
//                            accountTest.create("CD",CommonConstant.CD_SH, UserVO.getInstance().CDconnectedID);
//                            accountTest.create("CD",CommonConstant.CD_SAM, UserVO.getInstance().CDconnectedID);
//
//                            for(String connect : UserVO.getInstance().CDconnectedID)
//                                System.out.println(connect);
//
//                            accountTest.list(UserVO.getInstance().CDconnectedID.get(0),CommonConstant.CD_NH);
//                            accountTest.list(UserVO.getInstance().CDconnectedID.get(1),CommonConstant.CD_KB);
//                            accountTest.list(UserVO.getInstance().CDconnectedID.get(2),CommonConstant.CD_SH);
//                            accountTest.list(UserVO.getInstance().CDconnectedID.get(3),CommonConstant.CD_SAM);
//
//                            accountTest.list(UserVO.getInstance().BKconnectedID.get(0),CommonConstant.BK_NH);
//                            accountTest.list(UserVO.getInstance().BKconnectedID.get(1),CommonConstant.BK_KB);
//                            accountTest.list(UserVO.getInstance().BKconnectedID.get(2),CommonConstant.BK_SH);
//                            accountTest.list(UserVO.getInstance().BKconnectedID.get(3),CommonConstant.BK_URI);
//
//                        } catch (
//                                Exception e) {
//                            Log.d("errrrrr", "Errrrrrrrrrrrrrr");
//                        }
//                        Intent intent = new Intent(InputCertificatePasswordActivity.this, InputDetailInfoActivity.class);
//                        startActivity(intent);
//                    }
//                }.start();
                Intent intent = new Intent(InputCertificatePasswordActivity.this, InputDetailInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }
}
