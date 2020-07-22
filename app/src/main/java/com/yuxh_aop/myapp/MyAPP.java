package com.yuxh_aop.myapp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAPP extends Application {
    private String TAG = "Lifecycle->>>>";

    @Override
    public void onCreate() {
        super.onCreate();
        //监听所有activity生命周期
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                Log.e(TAG, "onActivityCreated: " + activity.getComponentName().getClassName() + "");
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                Log.e(TAG, "onActivityResumed: " + activity.getComponentName().getClassName() + "");
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                Log.e(TAG, "onActivityDestroyed: " + activity.getComponentName().getClassName() + "");
            }
        });
    }
}
