package cn.edu.tyut.service;

import cn.edu.tyut.dao.ApartmentMapper;
import cn.edu.tyut.dao.RoomMapper;
import cn.edu.tyut.dao.Stu_ApartMapper;
import cn.edu.tyut.dao.StudentMapper;
import cn.edu.tyut.pojo.Apartment;
import cn.edu.tyut.pojo.Room;
import cn.edu.tyut.pojo.Stu_Apart;
import cn.edu.tyut.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.Reader;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Test
    public void insertStudent() {
    }

    @Test
    public void deleteStudent() {
    }

    @Test
    public void updateStudent() {
    }

    @Test
    public void selectStudent() {
    }

    @Test
    public void allocation() {
        Student student = new Student(100001,"test","男","软件工程","大一","17","未分配");
        SqlSession session = sqlSessionFactory.openSession();
        ApartmentMapper apartmentMapper = session.getMapper(ApartmentMapper.class);
        RoomMapper roomMapper = session.getMapper(RoomMapper.class);
        Stu_ApartMapper stuApartMapper = session.getMapper(Stu_ApartMapper.class);
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

        //        学生状态为未分配
        if (student.getState().equals("未分配")){
//            查询与学生性别相同的楼
            Apartment apartment = new Apartment();
            apartment.setAsex(student.getSex());
            List<Apartment> list = apartmentMapper.selectApartment(apartment);
//            将list集合转为object对象
            for (int i = 0; i < list.size(); i++) {
                Apartment apartment1 = list.get(i);
                System.out.println(apartment1);
//                如果实住人数小于应住人数
                if (apartment1.getNowapeople() < apartment1.getApeople()){
//                    设置房间楼号为查出的楼号
                    Room room = new Room();
                    room.setAid(apartment1.getAid());
//                    查该宿舍楼房间
                    List<Room> rooms = roomMapper.selectRoom(room);
//                    将查出宿舍转为object对象
                    for (Room room1:
                            rooms) {
//                        如果宿舍内实住人数小于应住人数
                        if (room1.getNowrpeople() < room1.getRpeople()){
                            Room room2 = new Room();
//                            设置楼号
                            room2.setAid(apartment1.getAid());
//                            设置宿舍号
                            room2.setRid(room1.getRid());
//                            设置实住人数
                            room2.setNowrpeople(room1.getNowrpeople()+1);
//                            修改信息
                            int num = roomMapper.updateRoom(room2);
                            Apartment apartment2 = new Apartment();
//                            设置楼号
                            apartment2.setAid(apartment1.getAid());
//                            设置实住人数
                            apartment2.setNowapeople(apartment1.getNowapeople()+1);
//                            修改信息
                            int num1 = apartmentMapper.updateApartment(apartment2);
//                            插入住宿信息表stu_apart
                            Stu_Apart stuApart = new Stu_Apart();
                            stuApart.setAid(apartment1.getAid());
                            stuApart.setRid(room1.getRid());
                            stuApart.setSid(student.getSid());
                            int num2 = stuApartMapper.insertStuA(stuApart);
//                            修改学生状态
                            student.setState("已分配");
                            int num3 = studentMapper.updateStudent(student);
                            if (num > 0 && num1 > 0 && num2 > 0 && num3 > 0){
                                System.out.println(student);
                            }
                        }
                    }
                }
            }
        }
    }
}