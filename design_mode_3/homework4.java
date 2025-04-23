package design_mode_3;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String newDepartmentName);
}
interface Subject {
    void attach(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String newDepartmentName);
}
//具体的观察者类
class Teacher implements Observer {
    private String name;
    private String departmentName;

    public Teacher(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
    }

    @Override
    public void update(String newDepartmentName) {
        this.departmentName = newDepartmentName;
        System.out.println("教师 " + name + " 所属系更新为: " + departmentName);
    }
}
//具体的被观察者类
class Department implements Subject {
    private String departmentName;
    private List<Observer> observers = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        notifyObservers(departmentName);
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String newDepartmentName) {
        for (Observer observer : observers) {
            observer.update(newDepartmentName);
        }
    }
}

// 学生类，实现观察者接口
class Student implements Observer {
    private String name;
    private String departmentName;

    public Student(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
    }

    @Override
    public void update(String newDepartmentName) {
        this.departmentName = newDepartmentName;
        System.out.println("学生 " + name + " 所属系更新为: " + departmentName);
    }
}



public class homework4 {
    public static void main(String[] args) {
        Department department = new Department("计算机系");

        Teacher teacher = new Teacher("张老师", "计算机系");
        Student student = new Student("李同学", "计算机系");

        department.attach(teacher);
        department.attach(student);

        department.setDepartmentName("信息科学系");
    }
}
