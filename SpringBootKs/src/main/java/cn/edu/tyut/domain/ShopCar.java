package cn.edu.tyut.domain;

public class ShopCar {
    private Integer uid;
    private Integer goodId;
    private Integer goodNum;

    @Override
    public String toString() {
        return "ShopCar{" +
                "uid=" + uid +
                ", goodId=" + goodId +
                ", goodNum=" + goodNum +
                '}';
    }

    public ShopCar(Integer uid, Integer goodId, Integer goodNum) {
        this.uid = uid;
        this.goodId = goodId;
        this.goodNum = goodNum;
    }

    public ShopCar() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }
}
