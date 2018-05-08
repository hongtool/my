package com.mybatis.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 创建会话工厂，加载配置信息
 * @author 潘宏
 * @Date 2018/5/7
 */
public class stuController {
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String config = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(config);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
        }
        return sessionFactory;
    }
}
