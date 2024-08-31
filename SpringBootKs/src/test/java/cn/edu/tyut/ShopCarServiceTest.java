package cn.edu.tyut;

import cn.edu.tyut.domain.ShopCar;
import cn.edu.tyut.service.ShopCarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ShopCarServiceTest {
    @Autowired
    private ShopCarService shopCarService;

    @Test
    public void insert() {
        int flag = shopCarService.insertShopCar(2,3,1);
        System.out.println(flag);
    }

    @Test
    public void select() {
        List<ShopCar> list = shopCarService.findShopCarByUid(2);
        for (ShopCar shopCar : list) {
            System.out.println(shopCar);
        }
    }

    @Test
    public void delete() {
        int flag = shopCarService.deleteShopCarByUid(2,3);
        System.out.println(flag);
    }
}
