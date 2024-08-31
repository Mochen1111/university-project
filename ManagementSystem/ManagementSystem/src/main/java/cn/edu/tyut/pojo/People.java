package cn.edu.tyut.pojo;

public class People {
    private String vname;
    private int yyyy;
    private int mm;
    private int dd;
    private int aid;
    private int rid;
    private String name;
    private String gname;

    public People(String vname, int yyyy, int mm, int dd, int aid, int rid, String name, String gname) {
        this.vname = vname;
        this.yyyy = yyyy;
        this.mm = mm;
        this.dd = dd;
        this.aid = aid;
        this.rid = rid;
        this.name = name;
        this.gname = gname;
    }

    public People() {
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public int getYyyy() {
        return yyyy;
    }

    public void setYyyy(int yyyy) {
        this.yyyy = yyyy;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Override
    public String toString() {
        return "People{" +
                "vname='" + vname + '\'' +
                ", yyyy=" + yyyy +
                ", mm=" + mm +
                ", dd=" + dd +
                ", aid=" + aid +
                ", rid=" + rid +
                ", name='" + name + '\'' +
                ", gname='" + gname + '\'' +
                '}';
    }
}
