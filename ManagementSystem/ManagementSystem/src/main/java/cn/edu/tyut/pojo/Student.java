package cn.edu.tyut.pojo;

public class Student {
    private int sid;
    private String name;
    private String sex;
    private String major;
    private String grade;
    private String stuclass;
    private String state;

    public Student(int sid, String name, String sex, String major, String grade, String stuclass, String state) {
        this.sid = sid;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.grade = grade;
        this.stuclass = stuclass;
        this.state = state;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStuclass() {
        return stuclass;
    }

    public void setStuclass(String stuclass) {
        this.stuclass = stuclass;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", stuclass='" + stuclass + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
