package com.yuxh_aop.aspectJ;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yuxh_aop.R;
import com.yuxh_aop.aspectJ.annotation.LoginPointCut;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_login);
        initView();
    }
    @LoginPointCut("哈哈")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.but1) {
            Toast.makeText(this, "执行方法", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(LoginActivity.this);
    }
}