package cn.edu.tyut;

import cn.edu.tyut.domain.ShopCar;
import cn.edu.tyut.repository.ShopCarMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ShopCarMapperTest {
    @Autowired
    private ShopCarMapper shopCarMapper;

    @Test
    void testFindShopCarByUid() {
        List<ShopCar> shopCars = shopCarMapper.findShopCarByUid(2);
        for (ShopCar shopCar : shopCars) {
            System.out.println(shopCar);
        }
    }

    @Test
    public void testInsertShopCar() {
        ShopCar shopCar = new ShopCar();
        shopCar.setUid(2);
        shopCar.setGoodId(1);
        shopCar.setGoodNum(10);
        int result = shopCarMapper.insertShopCar(shopCar);
        System.out.println(result);
    }

    @Test
    void testFindShopCarByUidAndGoodsId() {
        ShopCar shopCar = shopCarMapper.findShopCarByUidAndGoodId(2,1);
        System.out.println(shopCar);
    }

}
