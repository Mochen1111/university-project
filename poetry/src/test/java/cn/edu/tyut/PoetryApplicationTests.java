package cn.edu.tyut;

import cn.edu.tyut.dao.UserMapper;
import cn.edu.tyut.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PoetryApplicationTests {
    @Autowired
    private UserMapper userMapper;
//    @Test
//    void contextLoads() {
//        User user = new User("user1","123456","27468xxxx@qq.com","12312341234",2);
//        userMapper.insertUser(user);
//        System.out.println(user);
//    }
}
