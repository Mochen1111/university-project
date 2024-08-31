package cn.edu.tyut.service;

import cn.edu.tyut.dao.ApartmentMapper;
import cn.edu.tyut.dao.RoomMapper;
import cn.edu.tyut.dao.Stu_ApartMapper;
import cn.edu.tyut.dao.StudentMapper;
import cn.edu.tyut.pojo.Apartment;
import cn.edu.tyut.pojo.Room;
import cn.edu.tyut.pojo.Stu_Apart;
import cn.edu.tyut.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ApartmentMapper apartmentMapper;
    @Autowired
    private Stu_ApartMapper stuApartMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public int insertStudent(Student student) {
        int num = studentMapper.insertStudent(student);
        if (num > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int deleteStudent(Student student) {
        String state = student.getState();
        if (state.equals("已分配")){
//            查找学生宿舍对应表
            Stu_Apart stuApart = new Stu_Apart();
            stuApart.setSid(student.getSid());
            List<Stu_Apart> list = stuApartMapper.selectStuA(stuApart);
//            获取学生宿舍信息
            Stu_Apart stuApart1 = list.get(0);
//            设置宿舍信息
            Room room = new Room();
            room.setRid(stuApart1.getRid());
            room.setAid(stuApart1.getAid());
            List<Room> list1 = roomMapper.selectRoom(room);
//            查询出该宿舍
            Room room1 = list1.get(0);
//            宿舍实住人数减一
            room1.setNowrpeople(room1.getNowrpeople()-1);
            int num = roomMapper.updateRoom(room1);
//            修改成功
            if (num > 0){
//                修改宿舍楼信息
                Apartment apartment = new Apartment();
//                设置楼号
                apartment.setAid(stuApart1.getAid());
//                查询楼信息
                List<Apartment> list2 = apartmentMapper.selectApartment(apartment);
//                获取宿舍楼信息
                Apartment apartment1 = list2.get(0);
//                楼内实住人数减一
                apartment1.setNowapeople(apartment1.getNowapeople()-1);
                int num1 = apartmentMapper.updateApartment(apartment1);
//                修改楼信息成功
                if (num1 > 0){
//                    删除学生宿舍表信息
                    int num2 = stuApartMapper.deleteStuA(stuApart1);
//                    删除学生宿舍信息成功
                    if (num2 > 0){
//                        删除学生表信息
                        int num3 = studentMapper.deleteStudent(student.getSid());
                        if (num3 > 0){
                            return 1;
                        }else {
                            return 0;
                        }
                    }else {
                        return 0;
                    }
                }else {
                    return 0;
                }
            }else {
                return 0;
            }
        }else {
            int num = studentMapper.deleteStudent(student.getSid());
            if (num > 0){
                return 1;
            }else {
                return 0;
            }
        }
    }

    @Override
    public int updateStudent(Student student) {
        int num = studentMapper.updateStudent(student);
        if (num > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<Student> selectStudent(Student student) {
        List<Student> list = studentMapper.selectStudent(student);
        return list;
    }

    @Override
    public Student allocation(Student student) {
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

//                            插入住宿信息表stu_apart
                            Stu_Apart stuApart = new Stu_Apart();
                            stuApart.setAid(apartment1.getAid());
                            stuApart.setRid(room1.getRid());
                            stuApart.setSid(student.getSid());
                            int num2 = stuApartMapper.insertStuA(stuApart);
                            if (num2 > 0){
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
//                            修改学生状态
                                student.setState("已分配");
                                int num3 = studentMapper.updateStudent(student);
                                if (num > 0 && num1 > 0 && num2 > 0 && num3 > 0){
                                    System.out.println(student);
                                    return student;
                                }
                            }
                        }
                    }
                }
            }
        }
        return student;
    }
}