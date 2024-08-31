package cn.edu.tyut.pojo;

public class Room {
    private int rid;
    private int rpeople;
    private int nowrpeople;
    private int aid;
    private String sex;

    public Room(int rid, int rpeople, int nowrpeople, int aid, String sex) {
        this.rid = rid;
        this.rpeople = rpeople;
        this.nowrpeople = nowrpeople;
        this.aid = aid;
        this.sex = sex;
    }

    public Room() {
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getRpeople() {
        return rpeople;
    }

    public void setRpeople(int rpeople) {
        this.rpeople = rpeople;
    }

    public int getNowrpeople() {
        return nowrpeople;
    }

    public void setNowrpeople(int nowrpeople) {
        this.nowrpeople = nowrpeople;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", rpeople=" + rpeople +
                ", nowrpeople=" + nowrpeople +
                ", aid=" + aid +
                ", sex='" + sex + '\'' +
                '}';
    }
}
