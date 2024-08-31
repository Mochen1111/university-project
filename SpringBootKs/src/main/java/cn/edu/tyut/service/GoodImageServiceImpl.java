package cn.edu.tyut.service;

import cn.edu.tyut.domain.GoodImage;
import cn.edu.tyut.repository.GoodImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodImageServiceImpl implements GoodImageService {
    @Autowired
    private GoodImageMapper goodImageMapper;

    @Override
    public GoodImage findGoodImage(int id) {
        //通过ID查询商品图片表
        GoodImage goodImage = goodImageMapper.findGoodImageById(id);
        return goodImage;
    }

    @Override
    public int addGoodImage(GoodImage goodImage) {
        //插入商品图片
        int flag = goodImageMapper.insertGoodImage(goodImage);
        if (flag > 0){
            return flag;
        }else {
            return 0;
        }
    }

    @Override
    public int updateGoodImage(GoodImage goodImage) {
        //修改商品图片
        int flag = goodImageMapper.updateGoodImage(goodImage);
        if (flag > 0){
            return flag;
        }else {
            return 0;
        }
    }

    @Override
    public int deleteGoodImage(int id) {
        //删除商品图片
        int flag = goodImageMapper.deleteGoodImage(id);
        if (flag > 0){
            return flag;
        }else {
            return 0;
        }

    }
}
