package www.epochong.homework.chapter_4.test;

abstract class Food {
    /**
     * 类别
     */
    protected String kind;
    /**
     * 数量
     */
    protected int num;
    /**
     * 价格
     */
    protected float price;

    /**
     * 合计
     */
    public float totalPrice(){
        return this.num * this.price;
    }
    public void eat(){}
}
class Apple extends Food {

    @Override
    public void eat() {
        System.out.println("[Apple] 吃苹果 ");
    }
}
class Orange extends Food {
    @Override
    public void eat() {
        System.out.println("[Orange] 吃橘子 ");
    }
}
class FruitFactory {
    private FruitFactory() {}

    public static Food getInstance(String className) {
        Food fruit = null ;
        try {
            fruit = (Food) Class.forName(className).newInstance() ;
        } catch (InstantiationException | IllegalAccessException |
                ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit ;
    }
}
public class ReflectFruitFactory {
    public static void main(String[] args) {
        Food fruit = FruitFactory.getInstance("www.homework.chapter_4.test.Apple") ;
        fruit.eat() ;
        Food orange = FruitFactory.getInstance("www.homework.chapter_4.test.Orange");
        orange.eat();
    }
}