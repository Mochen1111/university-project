package cn.edu.tyut;

import cn.edu.tyut.domain.Good;
import cn.edu.tyut.repository.GoodMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class GoodMapperTest {
    @Autowired
    private GoodMapper goodMapper;

    @Test
    void test1(){
        Good good = new Good("苹果",2.8,"烟台富士苹果","","水果",200);
        int i = goodMapper.insertGood(good);
        System.out.println(good);
        System.out.println(i);
    }

    @Test
    void test2(){
        List<Good> list = goodMapper.findGoodByName("土豆");
        System.out.println(list);
    }

    @Test
    void test3(){
        List<Good> list = goodMapper.findGoodByType("蔬");
        System.out.println(list);
    }

    @Test
    void test6(){
        List<Good> goodList = goodMapper.findNumIsNull();
        System.out.println(goodList);
    }
}
