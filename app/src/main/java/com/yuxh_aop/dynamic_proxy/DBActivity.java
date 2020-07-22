package com.yuxh_aop.dynamic_proxy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yuxh_aop.R;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DBActivity extends AppCompatActivity implements View.OnClickListener, AopDynamicProxy {

    protected Button button;
    private AopDynamicProxy db;
    public final static String TAG = "动态代理-->>>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_d_b);
        initView();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
//            //每次操作前需要save(常规写法)
//            db.save();
//            db.insert();

            db.insert();
        }
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(DBActivity.this);
//        db=this;

        db = (AopDynamicProxy) Proxy.newProxyInstance(AopDynamicProxy.class.getClassLoader(),
                new Class[]{AopDynamicProxy.class},
                new AopHander(this));
    }


    class AopHander implements InvocationHandler {
        private AopDynamicProxy db;

        public AopHander(AopDynamicProxy db) {
            this.db = db;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (db != null) {
                Log.e(TAG, "操作之前的保存数据");
                save();
                Log.e(TAG, "保存数据之后的操作");
                return method.invoke(db, args);
            }

            return null;
        }
    }

    @Override
    public void insert() {
        Log.e(TAG, "查询数据成功！！！");
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void save() {
        Log.e(TAG, "开始保存数据");
    }
}