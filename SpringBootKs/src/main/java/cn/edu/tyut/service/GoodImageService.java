package cn.edu.tyut.service;

import cn.edu.tyut.domain.GoodImage;

public interface GoodImageService {
    GoodImage findGoodImage(int id);
    int addGoodImage(GoodImage goodImage);
    int updateGoodImage(GoodImage goodImage);
    int deleteGoodImage(int id);
}
