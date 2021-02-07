package com.example.copylayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_email, TextInputEditText_password, TextInputEditText_gender;
    RelativeLayout RelativeLayout_login;

    String emailOK = "123@gmail.com";
    String passwordOK = "1234";

    String inputEmail = "";
    String inputPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 매칭
        setContentView(R.layout.activity_main);

        // ID 매칭
        TextInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        TextInputEditText_gender = findViewById(R.id.TextInputEditText_gender);
        RelativeLayout_login = findViewById(R.id.RelativeLayout_loginFacebook);

        // login 버튼 클릭 불가능
        RelativeLayout_login.setClickable(false);

        // Email 텍스트와쳐
        TextInputEditText_email.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TextWatcher 로그 확인
                // Log.d("SENTI", s + "," + count);

                if(s != null){
                    inputEmail = s.toString();
                }

                if (validation()) {
                    // 조건 통과하면 로그인 버튼 가능하게 변경
                    RelativeLayout_login.setClickable(true);
                }
                else{
                    RelativeLayout_login.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Password 텍스트와쳐
        TextInputEditText_email.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TextWatcher 로그 확인
                // Log.d("SENTI", s + "," + count);

                if(s != null){
                    inputPassword = s.toString();
                }

                if (validation()) {
                    // 조건 통과하면 로그인 버튼 가능하게 변경
                    RelativeLayout_login.setClickable(true);
                }
                else{
                    RelativeLayout_login.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        // 클릭리스너 생성
        RelativeLayout_login.setClickable(true);
        RelativeLayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 값 가져오기
                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();
                String gender = TextInputEditText_gender.getText().toString();

                // 값 전달 위한 Intent 생성 // 현재 activity.this -> 도착 activity.class 경로 지정
                Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);

                // intent 속 extra 이용해 값 저장
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                intent.putExtra("gender", gender);

                // 값 전송
                startActivity(intent);
            }
        });
    }

    public boolean validation(){
        return inputEmail.equals(emailOK) && inputPassword.equals(passwordOK);
    }
}