package cn.edu.tyut;

import cn.edu.tyut.domain.User;
import cn.edu.tyut.repository.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = new User("user1","123456","13812345678","2746843089@qq.com",2);
        int num = userMapper.insertUser(user);
        System.out.println(num);

    }
    @Test
    void test2(){
        User user = new User();
        user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    void test3(){
        User user = new User();
        List<User> list = userMapper.findAllUsers();
        for (User user1 : list) {
            System.out.println(user1);
        }
    }
}
