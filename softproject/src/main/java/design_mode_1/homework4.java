package design_mode_1;


class Dog{
    public void run(){
        System.out.println("dog run...");
    }
}

class Bird{
    public void haul(){
        System.out.println("bird haul...");
    }
}

abstract class Robot {
    public abstract void request1(); //像鸟一样叫
    public abstract void request2();//像狗一样跑
}

class Adapter extends Robot{
    private Dog dog;
    private Bird bird;

    public Adapter(Dog dog, Bird bird) {
        this.dog = dog;
        this.bird = bird;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void request1() {
        bird.haul();
    }

    @Override
    public void request2() {
        dog.run();
    }
}

public class homework4 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Bird bird = new Bird();
        Robot robot = new Adapter(dog,bird);
        robot.request1();
        robot.request2();
    }
}
