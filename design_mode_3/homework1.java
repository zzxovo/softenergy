package design_mode_3;

import java.util.ArrayList;

//调用者
class MenuItem{
    private Command command;

    public MenuItem(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    void click(){
        command.execute();
    };
}
//调用者集合
class Menu{
    private ArrayList<MenuItem> menuItems = null;

    public Menu() {
        this.menuItems = new ArrayList<>();
    }
    public void addMenuItem(MenuItem menuItem){
        menuItems.add(menuItem);
    }

    public void foreach(){
        System.out.println("遍历Menu的所有菜单项MenuItem....");
        for(MenuItem menuItem:menuItems){
            menuItem.click();
        }
    }


}

//抽象命令类
abstract class Command{
    abstract void execute();
}
//接收者
class BoardScreen{
    void open(){
        System.out.println("open...");
    }
    void create(){
        System.out.println("create...");
    }
    void edit(){
        System.out.println("edit");
    }
}
//具体命令类
class OpenCommand extends Command{
    private BoardScreen boardScreen;

    public OpenCommand(BoardScreen boardScreen) {
        this.boardScreen = boardScreen;
    }

    @Override
    void execute() {
        boardScreen.open();
    }
}
class CreateCommand extends Command{
    private BoardScreen boardScreen;

    public CreateCommand(BoardScreen boardScreen) {
        this.boardScreen = boardScreen;
    }

    @Override
    void execute() {
        boardScreen.create();
    }
}

class EditCommand extends Command{
    private BoardScreen boardScreen;

    public EditCommand(BoardScreen boardScreen) {
        this.boardScreen = boardScreen;
    }

    @Override
    void execute() {
        boardScreen.edit();
    }
}
public class homework1 {
    public static void main(String[] args) {
        //测试：三个调用者，分别调用使用open、create、edit等命令类
        //接收者
        BoardScreen boardScreen = new BoardScreen();
        //调用者
        MenuItem openItem = new MenuItem(new OpenCommand(boardScreen));
        MenuItem createItem = new MenuItem(new CreateCommand(boardScreen));
        MenuItem editItem = new MenuItem(new EditCommand(boardScreen));
        //三个调用者(菜单项)分别实现相应功能
        openItem.click();
        createItem.click();
        editItem.click();

        //调用者集合
        Menu menu = new Menu();
        menu.addMenuItem(openItem);
        menu.addMenuItem(createItem);
        menu.addMenuItem(editItem);
        //我们可以通过一个简单的遍历功能说明Menu已经具备了其他三个菜单项调用者的功能~
        menu.foreach();

    }
}
