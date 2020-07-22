package com.yuxh_aop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yuxh_aop.aspectJ.LoginActivity;
import com.yuxh_aop.aspectJ.annotation.LoginPointCut;
import com.yuxh_aop.dynamic_proxy.DBActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button butProxy;
    protected Button butLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.but_proxy) {
            startActivity(new Intent(this, DBActivity.class));
        } else if (view.getId() == R.id.but_login) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    private void initView() {
        butProxy = (Button) findViewById(R.id.but_proxy);
        butProxy.setOnClickListener(MainActivity.this);
        butLogin = (Button) findViewById(R.id.but_login);
        butLogin.setOnClickListener(MainActivity.this);
    }
}