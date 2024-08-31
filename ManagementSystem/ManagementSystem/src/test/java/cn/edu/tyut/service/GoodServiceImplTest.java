package cn.edu.tyut.service;

import cn.edu.tyut.dao.Room_GoodMapper;
import cn.edu.tyut.pojo.Room_Good;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

import static org.junit.Assert.*;

public class GoodServiceImplTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Test
    public void insertGood() {
    }

    @Test
    public void deleteGood() {
    }

    @Test
    public void updateGood() {
    }

    @Test
    public void selectGood() {
        SqlSession session = sqlSessionFactory.openSession();
        Room_GoodMapper roomGoodMapper = session.getMapper(Room_GoodMapper.class);
        Room_Good roomGood = new Room_Good();
        List<Room_Good> list = roomGoodMapper.selectGood(roomGood);
        System.out.println(list);
    }
}