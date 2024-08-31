package cn.edu.tyut.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
    @Test
    public void register() {
    }

    @Test
    public void deleteEmployee() {
    }

    @Test
    public void updateEmployee() {
    }

    @Test
    public void selectEmployee() {
    }

    @Test
    public void login() {
    }
}