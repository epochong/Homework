package www.epochong.homework.chapter_4.kfc.mykfc;

/**
 * @author epochong
 * @date 2019/4/19 21:23
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class Customer {

    //抽象工厂
    private Factory factory;

    //构造方法将抽象工厂作为参数传入
    public Customer(Factory factory){
        this.factory = factory;
    }

    /**
     * 点餐
     */
    public float orderZingerBurger(int num){
        //获得香辣鸡腿堡
        Hamburger zingerBurger = factory.createZingerBurger(num);
        //输出订购信息
        zingerBurger.printInformation();
        //返回总价
        return zingerBurger.totalPrice();
    }
    public float orderBeefBurger(int num){
        //获得超级牛肉堡
        Hamburger beefBurger = factory.createBeefBurger(num);
        //输出订购信息
        beefBurger.printInformation();
        //返回总价
        return beefBurger.totalPrice();
    }
    public float orderOrleansBurger(int num){
        //获得奥尔良烤鸡腿堡
        Hamburger orleansBurger = factory.createOrleansBurger(num);
        //输出订购信息
        orleansBurger.printInformation();
        //返回总价
        return orleansBurger.totalPrice();
    }
    public float orderShrimpBurger(int num){
        //获得全虾堡
        Hamburger shrimpBurger = factory.createShrimpBurger(num);
        //输出订购信息
        shrimpBurger.printInformation();
        //返回总价
        return shrimpBurger.totalPrice();
    }
    public float orderChickenWings(int num){
        //获得奥尔良烤翅
        Chicken chickenWings = factory.createChickenWings(num);
        //输出订购信息
        chickenWings.printInformation();
        //返回总价
        return chickenWings.totalPrice();
    }
    public float orderDrumStick(int num){
        //获得 烤鸡腿
        Chicken drumStick = factory.createDrumStick(num);
        //输出订购信息
        drumStick.printInformation();
        //返回总价
        return drumStick.totalPrice();
    }
    public float orderPopcornChicken(int num){
        //获得鸡米花
        Chicken popcornChicken = factory.createPopcornChicken(num);
        //输出订购信息
        popcornChicken.printInformation();
        //返回总价
        return popcornChicken.totalPrice();
    }
    public float orderChips(int num){
        //获得薯条
        Dessert chips = factory.createChips(num);
        //输出订购信息
        chips.printInformation();
        //返回总价
        return chips.totalPrice();
    }
    public float orderEggTart(int num){
        //获得蛋挞
        Dessert eggTart = factory.createEggTart(num);
        //输出订购信息
        eggTart.printInformation();
        //返回总价
        return eggTart.totalPrice();
    }
    public float orderSundae(int num){
        //获得圣代
        Dessert sundae = factory.createSundae(num);
        //输出订购信息
        sundae.printInformation();
        //返回总价
        return sundae.totalPrice();
    }
    public float orderMilky(int num){
        //获得奶茶
        Drinks milky = factory.createMilky(num);
        //输出订购信息
        milky.printInformation();
        //返回总价
        return milky.totalPrice();
    }
    public float orderKola(int num){
        //获得可乐
        Drinks kola = factory.createKola(num);
        //输出订购信息
        kola.printInformation();
        //返回总价
        return kola.totalPrice();
    }
    public float orderCoffee(int num){
        //获得咖啡
        Drinks coffee = factory.createCoffee(num);
        //输出订购信息
        coffee.printInformation();
        //返回总价
        return coffee.totalPrice();
    }

    public float orderOneCombo(int num) {
        //单人套餐
        Combo oneCombo = factory.createOneCombo(num);
        //输出订购信息
        oneCombo.printInformation();
        //返回总价
        return oneCombo.totalPrice();
    }

    public float orderTwoCombo(int num) {
        //双人套餐
        Combo twoCombo = factory.createTwoCombo(num);
        //输出订购信息
        twoCombo.printInformation();
        //返回总价
        return twoCombo.totalPrice();
    }

    public float orderThreeCombo(int num) {
        //三人套餐
        Combo threeCombo = factory.createThreeCombo(num);
        //输出订购信息
        threeCombo.printInformation();
        //返回总价
        return threeCombo.totalPrice();
    }

}
