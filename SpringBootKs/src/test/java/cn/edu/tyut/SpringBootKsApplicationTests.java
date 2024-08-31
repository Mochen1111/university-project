package cn.edu.tyut;

import cn.edu.tyut.domain.User;
import cn.edu.tyut.repository.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringBootKsApplicationTests {

    @Test
    void contextLoads() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));
    }
}
