package design_mode_3;
// 策略接口
interface DiscountStrategy {
    double computeDiscount(double originalPrice);
}
class ComputerBookDiscount implements DiscountStrategy {
    @Override
    public double computeDiscount(double originalPrice) {
        return originalPrice * 0.1;
    }
}
class LanguageBookDiscount implements DiscountStrategy {
    @Override
    public double computeDiscount(double originalPrice) {
        return 2;
    }
}
class NovelBookDiscount implements DiscountStrategy {
    @Override
    public double computeDiscount(double originalPrice) {
        return originalPrice / 100 * 15;
    }
}
// 图书类
class Book {
    private String title;
    private double price;
    private DiscountStrategy discountStrategy;

    public Book(String title, double price, DiscountStrategy discountStrategy) {
        this.title = title;
        this.price = price;
        this.discountStrategy = discountStrategy;
    }

    public double getFinalPrice() {
        double discount = discountStrategy.computeDiscount(price);
        return price - discount;
    }

    public String getTitle() {
        return title;
    }
}
public class homework5 {
    public static void main(String[] args) {
        Book computerBook = new Book("数据结构", 50, new ComputerBookDiscount());
        System.out.println(computerBook.getTitle() + " 的折后价: " + computerBook.getFinalPrice());

        Book languageBook = new Book("田静英语", 30, new LanguageBookDiscount());
        System.out.println(languageBook.getTitle() + " 的折后价: " + languageBook.getFinalPrice());

        Book novelBook = new Book("斗破苍穹", 80, new NovelBookDiscount());
        System.out.println(novelBook.getTitle() + " 的折后价: " + novelBook.getFinalPrice());
    }
}
