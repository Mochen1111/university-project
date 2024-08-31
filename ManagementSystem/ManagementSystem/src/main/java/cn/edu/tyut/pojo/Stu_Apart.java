package cn.edu.tyut.pojo;

public class Stu_Apart {
    private int sid;
    private int rid;
    private int aid;

    public Stu_Apart(int sid, int rid, int aid) {
        this.sid = sid;
        this.rid = rid;
        this.aid = aid;
    }

    public Stu_Apart() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Stu_Apart{" +
                "sid=" + sid +
                ", rid=" + rid +
                ", aid=" + aid +
                '}';
    }
}
