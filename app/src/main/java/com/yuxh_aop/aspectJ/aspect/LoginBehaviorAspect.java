package com.yuxh_aop.aspectJ.aspect;

import android.util.Log;

import com.yuxh_aop.aspectJ.annotation.LoginPointCut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

//定义切面类
@Aspect
public class LoginBehaviorAspect {
    public final static String TAG = "aspectJ->>> ";

    //应用中那些方法用到注解放到当前方法内进行处理
    //execution 一方法执行时为切入点
    //* *(..)意思是可以处理LoginPointCut内的所有方法
    @Pointcut("execution(@com.yuxh_aop.aspectJ.annotation.LoginPointCut * *(..))")
    public void onIsLoginMethod() {
    }


    //对切入点如何处理
    @Around("onIsLoginMethod()")
    public Object jointPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取签名方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取方法所属类名
        String simpleName = methodSignature.getDeclaringType().getSimpleName();
        //获取方法名
        String name = methodSignature.getName();
        //获取方法注解的value值
        String value = methodSignature.getMethod().getAnnotation(LoginPointCut.class).value();

        //方法执行之前
        long before = System.currentTimeMillis();
        Log.e(TAG, "jointPoint:  执行之前打印 ");
        //执行原本方法
        Object result = joinPoint.proceed();
        Log.e(TAG, "jointPoint:  执行中 ");
        //方法执行之后
        long after = System.currentTimeMillis();
        Log.e(TAG, "jointPoint:  执行之后打印 ");

        Log.e(TAG,String.format("统计了%s功能，在%s类的%s方法，用时%s ms",value,simpleName,name,after-before) );
        return result;
    }
}
