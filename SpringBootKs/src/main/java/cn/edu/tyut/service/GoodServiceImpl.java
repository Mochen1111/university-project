package cn.edu.tyut.service;

import cn.edu.tyut.domain.*;
import cn.edu.tyut.repository.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private SListMapper sListMapper;
    @Autowired
    private AListMapper alistMapper;
    @Autowired
    private ShopCarMapper shopCarMapper;

    @Override
    public Good findGoodById(int id) {
        // 通过 goodMapper 查找指定 ID 的商品
        Good good = goodMapper.findGoodById(id);
        if (good != null){
            return good;
        }else {
            return null;
        }
    }

    @Override
    public List<Good> findGoodNumIsNull(){
        //查询商品库存为空的商品
        List<Good> goodList = goodMapper.findNumIsNull();
        return goodList;
    }

    @Override
    public PageInfo<Good> findAllGood(Integer pageNum, Integer pageSize) {
        //分页查找
        List<Good> allGoods = goodMapper.findAllGoods();
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Good> pageInfo = new PageInfo<>(allGoods);
        return pageInfo;
    }

    @Override
    public List<Good> findGoodByName(String goodName) {
        //通过商品名称查找
        return goodMapper.findGoodByName(goodName);
    }

    @Override
    public List<Good> findGoodByType(String goodType) {
        //通过商品类型查找
        return goodMapper.findGoodByType(goodType);
    }

    @Override
    public Good addGood(Good good) {
        //插入商品
        goodMapper.insertGood(good);
        return good;
    }

    @Override
    public int updateGood(Good good) {
        //更新商品信息
        return goodMapper.updateGood(good);
    }

    @Override
    public int deleteGood(int id) {
        //删除商品
        return goodMapper.deleteGood(id);
    }

    //在购物车中购买商品使用该方法
    @Override
    public int buyGood(User user, Integer getMethod, Address address, Integer[] goodId) {
        // 初始化金额为0
        double money = 0;
        // 将金额转为BigDecimal类型
        BigDecimal bigDecimal = new BigDecimal(Double.toString(money));
        // 遍历商品ID数组
        for (int i = 0; i < goodId.length; i++) {
            // 根据商品ID查询商品信息
            Good good = goodMapper.findGoodById(goodId[i]);
            // 根据用户ID和商品ID查询购物车信息
            ShopCar shopCar = shopCarMapper.findShopCarByUidAndGoodId(user.getUid(),goodId[i]);
            if (shopCar != null){
                // 将商品价格转为BigDecimal类型
                BigDecimal bigDecimal1 = new BigDecimal(Double.toString(good.getGoodPrice()));
                // 计算商品总价
                bigDecimal1 = bigDecimal1.multiply(BigDecimal.valueOf(shopCar.getGoodNum()));
                // 累加总金额
                bigDecimal = bigDecimal.add(bigDecimal1);

                // 创建SList对象并设置属性
                SList sList = new SList(0,user.getUid(),goodId[i],shopCar.getGoodNum(),bigDecimal1.doubleValue());
                // 插入SList记录
                int flag = sListMapper.insertSList(sList);

                if (flag == 1){
                    // 更新商品库存数量
                    int num = good.getGoodNum() - shopCar.getGoodNum();
                    good.setGoodNum(num);
                    // 更新商品信息
                    int flag1 = goodMapper.updateGood(good);
                    if (flag1 == 1){
                        // 删除购物车记录
                        shopCarMapper.deleteShopCar(user.getUid(),goodId[i]);
                    }
                }
            }
        }

        // 创建日期格式化对象，并设置日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前日期
        Date date = new Date();

        // 创建AList对象并设置属性
        AList aList = new AList();
        aList.setUid(user.getUid());
        aList.setSumPrice(bigDecimal.doubleValue());
        aList.setCreateTime(simpleDateFormat.format(date));
        aList.setStatus("已下单");
        // 根据获取方式设置获取方式属性
        if (getMethod.equals(1)){
            aList.setGetGoodMethod("自提");
        }else if (getMethod.equals(2)){
            aList.setGetGoodMethod("外送");
        }
        aList.setAddress(address.getAddress());

        // 插入AList
        alistMapper.insertAList(aList);

        // 获取AList记录ID
        int aid = aList.getAid();

        // 根据AId查询SList记录列表
        List<SList> sLists = sListMapper.findSListsByAId(0);
        for (SList sList : sLists){
            // 设置SList记录的AId属性
            sList.setAid(aid);
            // 更新SList记录
            sListMapper.updateSList(sList);
        }
        // 返回插入AList记录的结果
        return aid;
    }

    //直接购买商品使用该方法
    @Override
    public int buyGoodMethod(User user, Integer getMethod, Integer goodNum, Address address, Integer goodId) {
        // 根据商品ID查询商品信息
        Good good = goodMapper.findGoodById(goodId);

        // 初始化金额
        double money = 0;
        BigDecimal bigDecimal = new BigDecimal(Double.toString(money));
        BigDecimal bigDecimal1 = new BigDecimal(Integer.toString(goodNum));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(good.getGoodPrice()));
        // 计算商品总价
        bigDecimal = bigDecimal1.multiply(bigDecimal2);

        // 创建日期格式化对象，并设置日期格式为"yyyy-MM-dd HH:mm:ss"
        // 创建日期格式化对象，并设置日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前日期
        Date date = new Date();

        // 创建AList对象并设置属性
        AList aList = new AList();
        aList.setUid(user.getUid());
        aList.setSumPrice(bigDecimal.doubleValue());
        aList.setCreateTime(simpleDateFormat.format(date));
        aList.setStatus("已下单");
        // 根据获取方式设置获取方式属性
        if (getMethod.equals(1)){
            aList.setGetGoodMethod("自提");
        } else if (getMethod.equals(2)){
            aList.setGetGoodMethod("外送");
        }
        aList.setAddress(address.getAddress());

        // 插入AList记录
        alistMapper.insertAList(aList);
        int aid = aList.getAid();

        // 创建SList对象并设置属性
        SList sList = new SList();
        sList.setAid(aid);
        sList.setUid(user.getUid());
        sList.setGoodId(goodId);
        sList.setGoodNum(goodNum);
        sList.setGoodPriceWithNum(bigDecimal.doubleValue());
        // 插入SList记录
        sListMapper.insertSList(sList);

        // 更新商品库存数量
        int num = good.getGoodNum() - goodNum;
        good.setGoodNum(num);
        goodMapper.updateGood(good);

        return aid;
    }
}
