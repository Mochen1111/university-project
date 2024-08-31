package cn.edu.tyut.domain;

public class Good {
    private Integer goodId;
    private String goodName;
    private Double goodPrice;
    private String goodContext;
    private String goodCover;
    private String goodType;
    private Integer goodNum;

    @Override
    public String toString() {
        return "Good{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", goodPrice=" + goodPrice +
                ", goodContext='" + goodContext + '\'' +
                ", goodCover='" + goodCover + '\'' +
                ",  goodType='" + goodType + '\'' +
                ", goodNum=" + goodNum +
                '}';
    }

    public Good(String goodName, Double goodPrice, String goodContext, String goodCover, String goodType, Integer goodNum) {
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.goodContext = goodContext;
        this.goodCover = goodCover;
        this.goodType = goodType;
        this.goodNum = goodNum;
    }

    public Good() {
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodContext() {
        return goodContext;
    }

    public void setGoodContext(String goodContext) {
        this.goodContext = goodContext;
    }

    public String getGoodCover() {
        return goodCover;
    }

    public void setGoodCover(String goodCover) {
        this.goodCover = goodCover;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }
}
