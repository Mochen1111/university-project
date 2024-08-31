package cn.edu.tyut.domain;

public class SList {
    private Integer sid;
    private Integer aid;
    private Integer uid;
    private Integer goodId;
    private Integer goodNum;
    private Double goodPriceWithNum;

    @Override
    public String toString() {
        return "SList{" +
                "sid=" + sid +
                ", aid=" + aid +
                ", uid=" + uid +
                ", goodId=" + goodId +
                ", goodNum=" + goodNum +
                ", goodPriceWithNum=" + goodPriceWithNum +
                '}';
    }

    public SList(Integer aid, Integer uid, Integer goodId, Integer goodNum, Double goodPriceWithNum) {
        this.aid = aid;
        this.uid = uid;
        this.goodId = goodId;
        this.goodNum = goodNum;
        this.goodPriceWithNum = goodPriceWithNum;
    }

    public SList() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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

    public Double getGoodPriceWithNum() {
        return goodPriceWithNum;
    }

    public void setGoodPriceWithNum(Double goodPriceWithNum) {
        this.goodPriceWithNum = goodPriceWithNum;
    }
}
