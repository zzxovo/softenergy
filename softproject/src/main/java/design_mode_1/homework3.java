package design_mode_1;

import org.example.Main;

class Menu{
    private MainFood mainFood;
    private Drinking drinking;

    public Menu() {
    }

    public MainFood getMainFood() {
        return mainFood;
    }

    public void setMainFood(MainFood mainFood) {
        this.mainFood = mainFood;
    }

    public Drinking getDrinking() {
        return drinking;
    }

    public void setDrinking(Drinking drinking) {
        this.drinking = drinking;
    }

    public Menu(MainFood mainFood, Drinking drinking) {
        this.mainFood = mainFood;
        this.drinking = drinking;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "mainFood=" + mainFood +
                ", drinking=" + drinking +
                '}';
    }
}
class MainFood{
    String size;
    public void eat(){
    };
}

class Hamburger extends MainFood{
    private int num;
    public Hamburger(int num, String size) {
        this.num = num;
        this.size = size;
    }

    @Override
    public void eat() {
        System.out.println("eat hamburger...");
    }

    @Override
    public String toString() {
        return "Hamburger{" +
                "num=" + num +
                ", size='" + size + '\'' +
                '}';
    }
}

class ChickenRolls extends MainFood{
    private String spicy;

    public ChickenRolls(String spicy, String size) {
        this.spicy = spicy;
        this.size = size;
    }

    @Override
    public void eat() {
        System.out.println("eat chicken rolls...");
    }

    @Override
    public String toString() {
        return "ChickenRolls{" +
                "spicy='" + spicy + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}

class Drinking{
    String temperature;//饮料的温度：冰 常温 热

    public Drinking(String temperature) {
        this.temperature = temperature;
    }

    public void drink(){

    }
}

class Juice extends Drinking{
    public Juice(String temperature) {
        super(temperature);
    }

    @Override
    public void drink() {
        System.out.println("drink juice...");
    }

    @Override
    public String toString() {
        return "Juice{" +
                "temperature='" + temperature + '\'' +
                '}';
    }
}

class Coke extends Drinking{
    public Coke(String temperature) {
        super(temperature);
    }

    @Override
    public void drink() {
        System.out.println("drink coke...");
    }

    @Override
    public String toString() {
        return "coke{" +
                "temperature='" + temperature + '\'' +
                '}';
    }
}

abstract class MenuBuilder{
    Menu menu;

    public MenuBuilder() {
        this.menu = new Menu();
    }

    public MenuBuilder(Menu menu) {
        this.menu = menu;
    }
    public abstract void constructMainFood();
    public abstract void constructDrinking();

    public Menu getMenu(){
        return menu;
    }
}

class Director{
    private MenuBuilder menuBuilder;

    public Director(MenuBuilder menuBuilder) {
        this.menuBuilder = menuBuilder;
    }

    public void setMenuBuilder(MenuBuilder menuBuilder) {
        this.menuBuilder = menuBuilder;
    }
    public Menu construct(){
        menuBuilder.constructMainFood();
        menuBuilder.constructDrinking();
        return menuBuilder.getMenu();
    }
}

class ConcreteMenuBuilderA extends MenuBuilder{
    @Override
    public void constructMainFood() {
        menu.setMainFood(new Hamburger(2,"big"));
    }

    @Override
    public void constructDrinking() {
        menu.setDrinking(new Juice("cold"));
    }
}

class ConcreteMenuBuilderB extends MenuBuilder{

    @Override
    public void constructMainFood() {
        menu.setMainFood(new ChickenRolls("spicy","small"));
    }

    @Override
    public void constructDrinking() {
        menu.setDrinking(new Coke("normal"));
    }
}

public class homework3 {
    public static void main(String[] args) {
        //假设有两个KFC套餐，一个套餐为：2个大尺寸的汉堡+冰果汁
        //另一个为：辣的小尺寸鸡肉卷+常温可乐
        MenuBuilder menuBuilder = new ConcreteMenuBuilderA();
        System.out.println(menuBuilder.menu);
        Director director = new Director(menuBuilder);
        Menu menuA = director.construct();
        System.out.println(menuA);
        //直接将director修改menuBuilder即可
        MenuBuilder menuBuilderB = new ConcreteMenuBuilderB();
        director.setMenuBuilder(menuBuilderB);
        Menu menuB = director.construct();
        System.out.println(menuB);
    }
}
