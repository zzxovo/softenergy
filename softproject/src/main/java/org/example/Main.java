package org.example;

import java.util.ArrayList;
import java.util.List;

class MeetingRoom {
    private String name;
    private int capacity;
    private String location;
    private List<Reservation> reservations = new ArrayList<>();

    // 省略构造函数、getter和setter方法

    public MeetingRoom(String name, int capacity, String location) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public boolean isAvailable(String time) {
        // 检查会议室在指定时间是否可用的逻辑
        return true;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", location='" + location + '\'' +
                '}';
    }
}

class Employee {
    private String fname;
    private String lname;
    private double salary;
    private List<Reservation> reservations = new ArrayList<>();

    public Employee(String fname, String lname, double salary) {
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
    }

    public Employee(String fname, String lname, double salary, List<Reservation> reservations) {
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.reservations = reservations;
    }

    public Employee() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}

class Manager extends Employee{
    private  double quarterlyBonus;

    public Manager(String fname, String lname, double salary, double quarterlyBonus) {
        super(fname, lname, salary);
        this.quarterlyBonus = quarterlyBonus;
    }

    public void increaseBonus(){

    }
    public void playGolfWithClient(){

    }

}

class Engineer extends Employee{
    private String education;
    private String hardware;

    public Engineer(String fname, String lname, double salary, String education) {
        super(fname, lname, salary);
        this.education = education;
    }

    public Engineer(String fname, String lname, double salary, String education, String hardware) {
        super(fname, lname, salary);
        this.education = education;
        this.hardware = hardware;
    }

    public Engineer(String fname, String lname, double salary) {
        super(fname, lname, salary);
    }

    public Engineer(String fname, String lname, double salary, List<Reservation> reservations, String education, String hardware) {
        super(fname, lname, salary, reservations);
        this.education = education;
        this.hardware = hardware;
    }

    public void analyzeReq(){}

    public void designSoftware(){}

    public void implementCode(){}

    public String getEducation() {
        return education;
    }

    public String getHardware() {
        return hardware;
    }
}

class Reservation {
    private String time;
    private Employee employee;
    private MeetingRoom meetingRoom;
    private Equipment equipment;

    // 省略构造函数、getter和setter方法

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Reservation(String time, Employee employee, MeetingRoom meetingRoom) {
        this.time = time;
        this.employee = employee;
        this.meetingRoom = meetingRoom;
    }

    public Reservation(String time, Employee employee, Equipment equipment) {
        this.time = time;
        this.employee = employee;
        this.equipment = equipment;
    }
}

class Equipment {
    private String name;
    private String model;
    private String function;
    private List<Reservation> reservations = new ArrayList<>();

    // 省略构造函数、getter和setter方法

    public Equipment(String name, String model, String function) {
        this.name = name;
        this.model = model;
        this.function = function;
    }

    public boolean isAvailable(String time) {
        // 检查设备在指定时间是否可用的逻辑
        return true;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", function='" + function + '\'' +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
        List<Reservation> reservations = new ArrayList<>();
        Engineer engineer = new Engineer("三","张",3500.0,"pku","major hardware");
        Manager manager = new Manager("四","李",6000.0,350.0);
        Reservation reservation1 = new Reservation("2025-1-1",engineer,new MeetingRoom("第一会议室",50,"3号楼"));
        Reservation reservation2 = new Reservation("2025-2-2",manager,new Equipment("设备A","型号1","功能1"));
        reservations.add(reservation1);
        reservations.add(reservation2);

        for(Reservation reservation : reservations){
            if(reservation.getMeetingRoom()!=null){
                System.out.println("员工:"+reservation.getEmployee()+"在："+ reservation.getTime() +"的时候预约了："+reservation.getMeetingRoom().toString());
            }
            else{
                System.out.println("员工:"+reservation.getEmployee()+"在："+ reservation.getTime() +"的时候预约了："+reservation.getEquipment().toString());
            }

        }


    }
}