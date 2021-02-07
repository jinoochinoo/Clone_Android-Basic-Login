package com.example.copylayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class ConfirmActivity extends AppCompatActivity {

    TextView TextView_EmailConfirm;
    TextView TextView_GenderConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 매칭
        setContentView(R.layout.activity_confirm);

        // ID 매칭
        TextView_EmailConfirm = findViewById(R.id.TextView_EmailConfirm);
        TextView_GenderConfirm = findViewById(R.id.TextView_GenderConfirm);

        // 수신 intent 생성
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // Extra 속 저장된 값 bundle 통해 반환
        String email = bundle.getString("email");
        String password = bundle.getString("password");
        String gender = bundle.getString("gender");

        // 연결된 View 파일에 값 세팅
        TextView_EmailConfirm.setText(email + " / " + password);
        TextView_GenderConfirm.setText(gender);
    }
}