package com.yuxh_aop.dynamic_proxy;

/**
 * 动态代理方式进行aop切面
 * 此处举例数据库的增删改查前都有一步保存操作
 */
public interface AopDynamicProxy {
    void insert();
    void delete();
    void update();
    //保存
    void save();
}
