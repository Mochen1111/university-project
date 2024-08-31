package cn.edu.tyut.domain;

import java.util.Date;

public class AList {
    private Integer aid;
    private Integer uid;
    private Double sumPrice;
    private String createTime;
    private String status;
    private String getGoodMethod;
    private String address;

    @Override
    public String toString() {
        return "AList{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", sumPrice=" + sumPrice +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", getGoodMethod='" + getGoodMethod + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public AList(Integer aid, Integer uid, Double sumPrice, String createTime, String status, String getGoodMethod, String address) {
        this.aid = aid;
        this.uid = uid;
        this.sumPrice = sumPrice;
        this.createTime = createTime;
        this.status = status;
        this.getGoodMethod = getGoodMethod;
        this.address = address;
    }

    public AList() {
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

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGetGoodMethod() {
        return getGoodMethod;
    }

    public void setGetGoodMethod(String getGoodMethod) {
        this.getGoodMethod = getGoodMethod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
