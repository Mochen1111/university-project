package cn.edu.tyut.controller;

import cn.edu.tyut.pojo.*;

import cn.edu.tyut.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class FirstController {
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private PeopleService peopleService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private Stu_ApartService stuApartService;
    @RequestMapping("/login")
    public ModelAndView Login(Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        Employee employee1 = employeeService.login(employee);
//        登录数据是否获取到了数据库信息
        if (employee1 != null){
                modelAndView.addObject("employee",employee1);
                modelAndView.setViewName("/BigAdmin");
        }else {
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }
    @RequestMapping("jumpToBigAdmin")
    public String jumpBigAdmin(){
        return "BigAdmin";
    }

    @RequestMapping("/listUnAllocation")
    @ResponseBody
    public Map Allocation(@RequestBody Student student){
        student.setState("未分配");
        List<Student> list = studentService.selectStudent(student);
        Map map = new HashMap();
        map.put("list",list);
        return map;
    }
    @RequestMapping("/AllocationStudent")
    @ResponseBody
    public Map AllocationStu(@RequestBody Student student){
        Map map = new HashMap();
        if(student.getState().equals("未分配")) {
            Student student1 = studentService.allocation(student);
            if (student1.getState().equals("已分配")){
                map.put("student",student1);
                return map;
            }else {
                map.put("student",student);
            }
        }else {
            map.put("student",student);
            return map;
        }
        return map;
    }

    @RequestMapping("/AllocationStudentList")
    @ResponseBody
    public Map AllocationStu(@RequestBody List<Student> list){
        Map map = new HashMap();
        for (Student student :
                list) {
            if(student.getState().equals("未分配")) {
                Student student1 = studentService.allocation(student);
                if (student1.getState().equals("已分配")){
                }else {
                    map.put("student",student);
                    break;
                }
            }else {
                map.put("student",student);
                break;
            }
        }
        map.put("student",list.get(list.size()-1));
        return map;
    }

    @RequestMapping("/allocation")
    public String  jumpAllocation(){
        return "/Allocation";
    }
    
    @RequestMapping("/showAdmin")
    public String jumpAdmin(){
        return "/ShowAdmin";
    }

    @RequestMapping("/ShowEmployee")
    @ResponseBody
    public Map selectEmployee(@RequestBody Employee employee){
        Map map = new HashMap();
        List<Employee> list = employeeService.selectEmployee(employee);
        map.put("list",list);
        return map;
    }

    @RequestMapping("/ShowEmployeeMore")
    @ResponseBody
    public ModelAndView selectEmployeeMore(Employee employee){
        List<Employee> list = employeeService.selectEmployee(employee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("ShowAdminMore");
        return modelAndView;
    }

    @RequestMapping("/updateEmp")
    public ModelAndView jumpUpdateEmp(Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> list = employeeService.selectEmployee(employee);
        modelAndView.addObject("employee",list.get(0));
        modelAndView.setViewName("UpdateEmp");
        return modelAndView;
    }

    @RequestMapping("/UpdateEmp")
    @ResponseBody
    public Map UpdateEmp(@RequestBody Employee employee){
        Map map = new HashMap();
        int num = employeeService.updateEmployee(employee);
        if (num > 0){
            List<Employee> list = employeeService.selectEmployee(employee);
            map.put("employee",list.get(0));
        }
        return map;
    }

    @RequestMapping("/DeleteEmployee")
    public String deleteEmp(int eid){
        int num = employeeService.deleteEmployee(eid);
        if (num > 0) {
            return "/ShowAdmin";
        }else {
            return "/error";
        }
    }

    @RequestMapping("/insertAdmin")
    public String jumpInsertAdm(){
        return "/InsertAdmin";
    }

    @RequestMapping("/InsertAdmin")
    public String InsertAdmin(Employee employee){
        boolean flag = employeeService.register(employee);
        if (flag){
            return "/ShowAdmin";
        }else {
            return "/error";
        }
    }

    @RequestMapping("/showStudent")
    public String jumpShowStu(){
        return "/ShowStudent";
    }

    @RequestMapping("/ShowStudent")
    @ResponseBody
    public Map ShowStudent(@RequestBody Student student){
        Map map = new HashMap();
        List<Student> list = studentService.selectStudent(student);
        map.put("student",list);
        return map;
    }

    @RequestMapping("/DeleteStudent")
    @ResponseBody
    public Map DeleteStudent(@RequestBody Student student){
        Map map = new HashMap();
        int num = studentService.deleteStudent(student);
        if (num > 0){
            map.put("student",student);
            return map;
        }else {
            return map;
        }
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public ModelAndView jumpUpdateStudent(int sid){
        ModelAndView modelAndView = new ModelAndView();
        Student student = new Student();
        student.setSid(sid);
        List<Student> list = studentService.selectStudent(student);
        Student student1 = list.get(0);
        modelAndView.addObject("student",student1);
        modelAndView.setViewName("UpdateStudent");
        return modelAndView;
    }

    @RequestMapping("/UpdateStudent")
    @ResponseBody
    public Map UpdateStudent(@RequestBody Student student){
        Map map = new HashMap();
        int num = studentService.updateStudent(student);
        if (num > 0){
            List<Student> list = studentService.selectStudent(student);
            Student student1 = new Student();
            student1 = list.get(0);
            map.put("student",student1);
            return map;
        }else {
            return map;
        }
    }
    @RequestMapping("/insertStudent")
    public String jumpInsertStudent(){
        return "/InsertStudent";
    }
    @RequestMapping("/InsertStudent")
    public String InsertStudent(Student student){
        if (student != null){
            student.setState("未分配");
            int num = studentService.insertStudent(student);
            if (num > 0){
                return "ShowStudent";
            }else {
                return "error";
            }
        }else {
            return "error";
        }
    }

    @RequestMapping("showApartment")
    public String jumpShowApt(){
        return "ShowApartment";
    }

    @RequestMapping("/ShowApartment")
    @ResponseBody
    public Map ShowApartment(@RequestBody Apartment apartment){
        Map map = new HashMap();
        List<Apartment> list = apartmentService.selectApartment(apartment);
        map.put("apt",list);
        return map;
    }

    @RequestMapping("/ShowApartmentMore")
    public String ShowApartmentMore(int aid,HttpServletRequest request){
        Room room = new Room();
        room.setAid(aid);
        List<Room> list = roomService.selectRoom(room);
        request.setAttribute("room",list);
        return "/ShowApartmentMore";
    }

    @RequestMapping("/ShowRoomMore")
    public String ShowRoomMore(int rid,int aid,HttpServletRequest request){
        Stu_Apart stuApart = new Stu_Apart();
        stuApart.setRid(rid);
        stuApart.setAid(aid);
        List<Stu_Apart> list = stuApartService.selectStu(stuApart);
        int len = list.size();

        Student[] list2 = new Student[len];
        for (int i = 0; i < len; i++){
            Student student = new Student();
            Stu_Apart stuApart1 = list.get(i);
            student.setSid(stuApart1.getSid());
            List<Student> list1 = studentService.selectStudent(student);
            list2[i] = list1.get(0);
        }
        request.setAttribute("student",list2);
        return "ShowRoomMore";
    }

    @RequestMapping("/InsertApartment")
    public String InsertApartment(int aid,String sex){
        Apartment apartment1 = new Apartment();
        apartment1.setAid(aid);
        List<Apartment> list = apartmentService.selectApartment(apartment1);
        if (list.size() == 0){
            if (sex != null && aid != 0){
                Apartment apartment = new Apartment();
                apartment.setAid(aid);
                apartment.setApeople(288);
                apartment.setNowapeople(0);
                apartment.setRoomnumber(72);
                apartment.setAsex(sex);
                int num = apartmentService.insertApartment(apartment);
                if (num > 0){
                    return "/ShowApartment";
                }else {
                    return "/error";
                }
            }
            return "/error";
        }else {
            return "/error";
        }
    }

    @RequestMapping("/peopleLog")
    public String jumpPeopleLog(){
        return "/PeopleLog";
    }

    @RequestMapping("/PeopleLog")
    @ResponseBody
    public Map PeopleLog(@RequestBody People people){
        Map map = new HashMap();
        List<People> list = peopleService.selectPeople(people);
        if (list != null){
            map.put("people",list);
            return map;
        }else {
            return map;
        }
    }

    @RequestMapping("/insertAllPeople")
    public String jumpInsertPeople(){
        return "/InsertPeople";
    }

    @RequestMapping("/InsertPeople")
    public String InsertPeople(People people){
        if (people != null){
            int num = peopleService.insertPeople(people);
            if (num > 0){
                return "/PeopleLog";
            }else {
                return "/error";
            }
        }else {
            return "error";
        }
    }

    @RequestMapping("/goodManage")
    public String jumpGoodManage(){
        return "/GoodManage";
    }

    @RequestMapping("/selectGood")
    @ResponseBody
    public Map SelectGood(int aid){
        Map map = new HashMap();
        List<Room_Good> list = goodService.selectGood(aid);
        if (list != null){
            map.put("good",list);
            return map;
        }else {
            return map;
        }
    }

    @RequestMapping("/insertGood")
    public String jumpInsertGood(){
        return "/InsertGood";
    }

    @RequestMapping("/InsertGood")
    public String InsertGood(Room_Good roomGood){
        int num = goodService.insertGood(roomGood);
        if (num > 0){
            return "/GoodManage";
        }else {
            return "/error";
        }
    }

    @RequestMapping("/DeleteGood")
    public String DeleteGood(int aid,int rid,String gname){
        Room_Good roomGood = new Room_Good();
        roomGood.setAid(aid);
        roomGood.setRid(rid);
        roomGood.setGname(gname);
        int num = goodService.deleteGood(roomGood);
        if (num > 0){
            return "/GoodManage";
        }else {
            return "/error";
        }
    }
}
