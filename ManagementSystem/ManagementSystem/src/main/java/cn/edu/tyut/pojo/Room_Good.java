package cn.edu.tyut.pojo;

public class Room_Good {
    private int aid;
    private int rid;
    private String gname;
    private int gnumber;

    public Room_Good(int aid, int rid, String gname, int gnumber) {
        this.aid = aid;
        this.rid = rid;
        this.gname = gname;
        this.gnumber = gnumber;
    }

    public Room_Good() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGnumber() {
        return gnumber;
    }

    public void setGnumber(int gnumber) {
        this.gnumber = gnumber;
    }

    @Override
    public String toString() {
        return "Room_Good{" +
                "aid=" + aid +
                ", rid=" + rid +
                ", gname='" + gname + '\'' +
                ", gnumber=" + gnumber +
                '}';
    }
}
