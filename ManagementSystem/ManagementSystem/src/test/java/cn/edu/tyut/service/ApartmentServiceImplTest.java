package cn.edu.tyut.service;

import cn.edu.tyut.dao.ApartmentMapper;
import cn.edu.tyut.pojo.Apartment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

import static org.junit.Assert.*;

public class ApartmentServiceImplTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Test
    public void insertApartment() {
    }

    @Test
    public void updateApartment() {
    }

    @Test
    public void selectApartment() {
        SqlSession session = sqlSessionFactory.openSession();
        ApartmentMapper apartmentMapper = session.getMapper(ApartmentMapper.class);
        List<Apartment> list = apartmentMapper.selectApartment(new Apartment());
        System.out.println(list);
    }
}