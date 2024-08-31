package cn.edu.tyut.pojo;

public class Employee {
    private int eid;
    private String password;
    private String name;
    private String sex;
    private int age;
    private int aid;

    public Employee(int eid, String password, String name, String sex, int age, int aid) {
        this.eid = eid;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.aid = aid;
    }

    public Employee() {
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", aid=" + aid +
                '}';
    }
}
