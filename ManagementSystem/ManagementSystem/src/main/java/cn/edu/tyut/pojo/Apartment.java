package cn.edu.tyut.pojo;

public class Apartment {
    private int aid;
    private int apeople;
    private int nowapeople;
    private int roomnumber;
    private String asex;

    public Apartment(int aid, int apeople, int nowapeople, int roomnumber, String asex) {
        this.aid = aid;
        this.apeople = apeople;
        this.nowapeople = nowapeople;
        this.roomnumber = roomnumber;
        this.asex = asex;
    }

    public Apartment() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getApeople() {
        return apeople;
    }

    public void setApeople(int apeople) {
        this.apeople = apeople;
    }

    public int getNowapeople() {
        return nowapeople;
    }

    public void setNowapeople(int nowapeople) {
        this.nowapeople = nowapeople;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getAsex() {
        return asex;
    }

    public void setAsex(String asex) {
        this.asex = asex;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "aid=" + aid +
                ", apeople=" + apeople +
                ", nowapeople=" + nowapeople +
                ", roomnumber=" + roomnumber +
                ", asex='" + asex + '\'' +
                '}';
    }
}
