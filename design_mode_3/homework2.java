package design_mode_3;

// 迭代器接口，定义了双向迭代的方法
interface MyIterator {
    boolean hasNext();
    Object next();
    boolean hasPrevious();
    Object previous();
}

// 抽象聚合类，包含商品数组和创建迭代器的抽象方法
abstract class Aggregate {
    protected String[] products;
    protected int size;

    public Aggregate(int capacity) {
        this.products = new String[capacity];
        this.size = 0;
    }

    // 向聚合类中添加商品的方法
    public void addProduct(String product) {
        if (size < products.length) {
            products[size++] = product;
        }
    }

    // 抽象方法，用于创建迭代器
    abstract MyIterator createIterator();
}

// 具体聚合类，继承自抽象聚合类
class ConcreteAggregate extends Aggregate {

    public ConcreteAggregate(int capacity) {
        super(capacity);
    }

    // 实现创建迭代器的方法
    @Override
    public MyIterator createIterator() {
        return new ConcreteIterator(this);
    }
}

// 具体迭代器类，实现了迭代器接口
class ConcreteIterator implements MyIterator {
    private Aggregate aggregate;
    private int currentIndex = 0;

    public ConcreteIterator(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    // 判断是否有下一个元素
    @Override
    public boolean hasNext() {
        return currentIndex < aggregate.size;
    }

    // 获取下一个元素
    @Override
    public Object next() {
        if (hasNext()) {
            return aggregate.products[currentIndex++];
        }
        return null;
    }

    // 判断是否有上一个元素
    @Override
    public boolean hasPrevious() {
        return currentIndex > 0;
    }

    // 获取上一个元素
    @Override
    public Object previous() {
        if (hasPrevious()) {
            return aggregate.products[--currentIndex];
        }
        return null;
    }
}

public class homework2 {
    public static void main(String[] args) {
        // 创建具体聚合类实例(商品，并设置最大数量)
        ConcreteAggregate aggregate = new ConcreteAggregate(5);
        // 向聚合类中添加商品
        aggregate.addProduct("商品1");
        aggregate.addProduct("商品2");
        aggregate.addProduct("商品3");

        // 获取迭代器
        MyIterator iterator = aggregate.createIterator();

        // 向前遍历
        System.out.println("向前遍历:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 向后遍历
        System.out.println("向后遍历:");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}