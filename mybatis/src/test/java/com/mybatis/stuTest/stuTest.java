package com.mybatis.stuTest;

import com.mybatis.controller.stuController;
import com.mybatis.mapper.StuMapper;
import com.mybatis.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * 测试对学生信息的正删改查
 * @author 潘宏
 * @Date 2018/5/7
 */
class StuMapperTest {
    private StuMapper stuMapper;
    private SqlSession sqlSession;
    @BeforeEach
    void setUp() {
        SqlSessionFactory sqlSessionFactory = stuController.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        stuMapper = sqlSession.getMapper(StuMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.close();
    }

    @Test//根据ID查找学生信息，返回单条信息
    void selectStudent() throws Exception{
        Student student = stuMapper.selectStudent(1);
        System.out.println(student);
    }

    @Test//对学生表进行模糊查询，返回列表
    void selectStudentByMoHu() throws Exception{
        List<Student> studentList = stuMapper.selectStudentByMoHu("L");

        System.out.println(studentList);
    }

    @Test//添加一条信息
    void selectStudentInsert() throws Exception{
        Student student = new Student();
        student.setStuname("Jack");
        student.setStuage(18);
        stuMapper.insertStudent(student);
        sqlSession.commit();
    }

    @Test//根据ID删除学生信息
    void deleteStudent() throws Exception{
        stuMapper.deleteStudent(4);
        sqlSession.commit();
    }

    @Test//根据ID更新学生信息
    void update() throws Exception{
        stuMapper.update(1,"Lucky",23);
        sqlSession.commit();
    }

}