package www.epochong.homework.chapter_4.kfc.realkfc;

/**
 * @author epochong
 * @date 2019/4/21 22:26
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * 食物基类
 */
abstract class BaseFood {
    /**
     * 类别
     */
    String name;
    /**
     * 数量
     */
    int num;
    /**
     * 价格
     */
    float price;

    /**
     * 合计
     * @return 食物总价格
     */
    public float totalPrice() {
        return this.num * this.price;
    }
}

/**
 * 抽象食物接口
 */
interface IFood {
    /**
     * 打印输出食物信息
     */
    void printMessage();

}

/**
 * 建立不同食物的抽象基类
 */

/**
 * 汉堡基类
 */
abstract class BaseHamburg extends BaseFood implements IFood {
    @Override
    public void printMessage() {
        System.out.println(this.name + "\t\t\t\t单价：" + this.price + "元" + "\t\t数量：" + this.num + "\t\t合计：" + this.totalPrice() + "元");
    }

    @Override
    public String toString() {
        return this.name + "\t\t\t" + String.format("%.1f",this.price)+ "\t\t" + this.num + "\t\t" + this.totalPrice();
    }
}

/**
 * 创建具体的食物
 */
class PaNiNiHamburg extends BaseHamburg {
    PaNiNiHamburg(int num) {
        this.name = "芝士帕尼尼";
        this.price = 12.5f;
        this.num = num;
    }
}

class CrispyChickenHamburg extends BaseHamburg {
    public CrispyChickenHamburg(int num) {
        this.name = "劲脆鸡腿堡";
        this.price = 19.0f;
        this.num = num;
    }
}
/**
 * 鸡翅基类
 */
abstract class BaseChicken extends BaseFood implements IFood {
    @Override
    public void printMessage() {
        System.out.println( this.name + "\t\t\t\t单价：" + this.price + "元" + "\t\t数量：" + this.num + "\t\t合计：" + this.totalPrice() + "元");
    }

    @Override
    public String toString() {
        return this.name + "\t\t" + String.format("%.1f",this.price) +  "\t\t" + this.num + "\t\t" + this.totalPrice() ;
    }
}

/**
 * 热辣薯片鸡翅
 */
class HotPotatoChipsChickenWings extends BaseChicken {
    public HotPotatoChipsChickenWings(int num) {
        this.name = "热辣薯片鸡翅";
        this.price = 12.0f;
        this.num = num;
    }
}
/**
 * 香辣鸡翅
 */
class PiquancyChickenWings extends BaseChicken {
    PiquancyChickenWings(int num) {
        this.name = "劲爆香辣鸡翅";
        this.price = 12.0f;
        this.num = num;
    }
}


/**
 * 甜品基类
 */
abstract class BaseSweetmeats extends BaseFood implements IFood {

    @Override
    public void printMessage() {
        System.out.println(this.name + "\t\t单价：" + this.price + "元" + "\t\t数量：" + this.num + "\t\t合计：" + this.totalPrice() + "元");
    }

    @Override
    public String toString() {
        return this.name + "\t\t\t" + String.format("%.1f",this.price)  + "\t\t" + this.num + "\t\t" + this.totalPrice();
    }
}

/**
 * 具体甜品
 */
class ChocolateWaffleSweetmeats extends BaseSweetmeats {
    ChocolateWaffleSweetmeats(int num) {
        this.name = "巧克力华夫";
        this.price = 11.0f;
        this.num = num;
    }
}

class RedBeanPieSweetmeats extends BaseSweetmeats {
    public RedBeanPieSweetmeats(int num) {
        this.name = "香香红豆派";
        this.price = 13.0f;
        this.num = num;
    }
}

/**
 * 饮料基类
 */
abstract class BaseBeverage extends BaseFood implements IFood {
    @Override
    public void printMessage() {
        System.out.println(this.name + "\t\t单价：" + this.price + "元" + "\t\t数量：" + this.num + "\t\t合计：" + this.totalPrice() + "元");
    }

    @Override
    public String toString() {
        return this.name + "\t\t\t" + String.format("%.1f",this.price) + "\t\t" + this.num + "\t\t" + this.totalPrice();
    }
}
/**
 * 可乐
 */
class BaiShiKolaBeverage extends BaseBeverage {
    BaiShiKolaBeverage(int num) {
        this.name = "百事可乐";
        this.price = 10.5f;
        this.num = num;
    }
}

/**
 * 抹茶拿铁
 */
class CoffeeBeverage extends BaseBeverage {
    public CoffeeBeverage(int num) {
        this.name = "抹茶拿铁";
        this.price = 17.0f;
        this.num = num;
    }
}

/**
 * 套餐类
 */
abstract class BaseSetMeal extends BaseFood implements IFood {
    @Override
    public void printMessage() {
        System.out.println(this.name + "\t\t单价：" + this.price + "元" + "\t\t数量：" + this.num + "\t\t合计：" + this.totalPrice() + "元");
    }

    @Override
    public String toString() {
        return this.name + "\t" + String.format("%.1f",this.price) + "\t\t" + this.num + "\t\t" + this.totalPrice() ;
    }
}

/**
 * 具体套餐
 */
class WingBucketTenderFiveSides extends BaseSetMeal {
    public WingBucketTenderFiveSides(int num) {
        this.name = "翅桶嫩牛五方套餐";
        this.price = 89.0f;
        this.num = num;
    }
}
class SpicyDuckRollPopularStarMealBase extends BaseSetMeal {
    public SpicyDuckRollPopularStarMealBase(int num) {
        this.name = "辣鸭肉卷人气套餐";
        this.price = 39.0f;
        this.num = num;
    }
}

/**
 * 建立工厂
 * 创建抽象肯德基工厂
 * 生产抽象食物
 */
interface IKfcFactory {
    /**
     * 生产帕尼尼
     * @param num 要买的数量
     * @return BaseHamburg对象
     */
    BaseHamburg createPaNiNiHamburg(int num);
    BaseHamburg createCrispyChickenHamburg(int num);
    /**
     * 生产薯条
     * @param num 要买的数量
     * @return BaseFrenchFries对象
     */
    BaseSweetmeats createChocolateWaffleSweetmeats(int num);
    BaseSweetmeats createRedBeanPieSweetmeats(int num);
    /**
     * 生产鸡翅
     * @param num 要买的数量
     * @return BaseChicken对象
     */
    BaseChicken createHotPotatoChipsChickenWings(int num);
    BaseChicken createPiquancyChickenWings(int num);
    /**
     * 生产饮料
     * @param num 要买的数量
     * @return BaseBeverage对象
     */
    BaseBeverage createBaiShiKolaBeverage(int num);
    BaseBeverage createCoffeeBeverage(int num);

    BaseSetMeal createWingBucketTenderFiveSides(int num);
    BaseSetMeal createSpicyDuckRollPopularStarMealBase(int num);
}

/**
 * 创建具体肯德基工厂
 * 生产具体食物
 */
class KfcFoodFactory implements IKfcFactory {
    /**
     * 生产可乐
     * @param num 要买的数量
     * @return Beverage对象向上转型
     */
    @Override
    public BaseBeverage createBaiShiKolaBeverage(int num) {
        return new BaiShiKolaBeverage(num);
    }

    @Override
    public BaseBeverage createCoffeeBeverage(int num) {
        return new CoffeeBeverage(num);
    }

    @Override
    public BaseSetMeal createWingBucketTenderFiveSides(int num) {
        return new WingBucketTenderFiveSides(num);
    }

    @Override
    public BaseSetMeal createSpicyDuckRollPopularStarMealBase(int num) {
        return new SpicyDuckRollPopularStarMealBase(num);
    }

    /**
     * 生产奥尔良烤鸡翅
     * @param num 要买的数量
     * @return BaseChickenWings对象向上转型
     */
    @Override
    public BaseChicken createHotPotatoChipsChickenWings(int num) {
        return new HotPotatoChipsChickenWings(num);
    }

    @Override
    public BaseChicken createPiquancyChickenWings(int num) {
        return new PiquancyChickenWings(num);
    }

    /**
     * 生产薯条
     * @param num 要买的数量
     * @return FrenchFries对象向上转型
     */
    @Override
    public BaseSweetmeats createChocolateWaffleSweetmeats(int num) {
        return new ChocolateWaffleSweetmeats(num);
    }

    @Override
    public BaseSweetmeats createRedBeanPieSweetmeats(int num) {
        return new RedBeanPieSweetmeats(num);
    }

    /**
     * 生产汉堡
     * @param num 要买的数量
     * @return Hamburg对象向上转型
     */
    @Override
    public BaseHamburg createPaNiNiHamburg(int num) {
        return new PaNiNiHamburg(num);
    }

    @Override
    public BaseHamburg createCrispyChickenHamburg(int num) {
        return new CrispyChickenHamburg(num);
    }
}

class FoodFactory {
    private FoodFactory() {}
    public static IKfcFactory getInstance(String className) {
        IKfcFactory food = null ;
        try {
            food = (IKfcFactory) Class.forName(className).newInstance() ;
        } catch (InstantiationException | IllegalAccessException |
                ClassNotFoundException e) {
            e.printStackTrace();
        }
        return food ;
    }
}

interface Pay {
    public float countMoney(float clientpay);
}

class AliPay implements Pay {


    @Override
    public float countMoney(float clientpay) {
        System.out.println("使用支付宝支付，您有5元红包");
        return clientpay - 5;
    }
}

class TencentPay implements Pay {

    @Override
    public float countMoney(float clientpay) {
        System.out.println("使用微信支付，您可以享受95折");
        return clientpay * 0.95f;
    }
}

class IPay implements Pay {

    @Override
    public float countMoney(float shouldPayMoney) {
        System.out.println("使用现金支付，您没有优惠");
        return shouldPayMoney;
    }
}

class HandlerPay {
    private Pay pay;

    public HandlerPay(Pay pay) {
        this.pay = pay;
    }

    public float countMoney(float clientMoney) {
        return pay.countMoney(clientMoney);
    }
}
public class ReflectFoodFactory {
    public static void menu() {
        System.out.println(
                "***********************************************\n"
                        +"*                 KFC点餐系统！                *\n"
                        +"***********************************************\n"
                        +"*********************菜单***********************\n"
                        +"汉堡\n"
                        + "\t\t1.芝士帕尼尼\t\t12.5元\n" + "\t\t2.劲脆鸡腿堡\t\t19.0元 \n"
                        +"烤鸡翅\n"
                        + "\t\t3.热辣薯片鸡翅\t12.0元\n" + "\t\t4.劲爆香辣鸡翅\t12.0元\n"
                        + "饮料\n"
                        + "\t\t5.百事可乐\t\t10.5元\n" + "\t\t6.抹茶拿铁\t\t17.0元\n"
                        +"甜点\n"
                        + "\t\t7.巧克力华夫\t\t11.0元\n" + "\t\t8.香香红豆派\t\t13.0元\n"
                        +"套餐\n"
                        +"\t\t9.翅桶嫩牛五方套餐\t\t89.0元\n"
                        + "\t\t\t香辣鸡翅 6 块\n" + "\t\t\t新奥尔良烤翅 4 块\n" + "\t\t\t香辣鸡腿堡 1 个\n" + "\t\t\t嫩牛五方 1 个 + 饮料 2 杯 \n"
                        +"\t\t10.辣鸭肉卷人气明星套餐\t39.0元\n"
                        + "\t\t\t老北京香辣鸭肉卷 1 个\n" + "\t\t\t香骨鸡 3 块\n" + "\t\t\t醇香土豆泥 1 份\n" + "\t\t\t饮料 1 杯\n"
                        +"*********************************************\n");
    }
    private static int get12() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String re = input.nextLine();
            if (re.equals("2") || re.equals("1")) {
                return Integer.valueOf(re);
            } else {
                System.out.println("输入错误,重新输入吧！");
            }
        }
    }
    private static int get13() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String re = input.nextLine();
            if (re.equals("2") || re.equals("1") || re.equals("3")) {
                return Integer.valueOf(re);
            } else {
                System.out.println("输入错误,重新输入吧！");
            }
        }
    }
    private static float getFloatNum() {
        Scanner input = new Scanner(System.in);

        String re = null;
        while (true) {
            re = input.nextLine();
            Scanner has = new Scanner(re);
            if (has.hasNextFloat()) {
                return Float.parseFloat(re);
            }else {
                System.out.println("输入错误，重新输入吧！");
                continue;
            }

        }
    }
    private static int getIntNum() {
        Scanner input = new Scanner(System.in);

        while (true) {
            String re = input.nextLine();
            Scanner has = new Scanner(re);
            if (has.hasNextInt()) {
                return Integer.parseInt(re);
            } else {
                System.out.println("输入错误，重新输入吧！");
                continue;
            }
        }
    }
    private static int get1_10() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String re = input.nextLine();
            if (re.equals("1") || re.equals("2") || re.equals("3") || re.equals("4") || re.equals("5")||
                    re.equals("6") || re.equals("7") || re.equals("8") || re.equals("9") || re.equals("10")) {
                return Integer.valueOf(re);
            } else {
                System.out.println("输入错误,重新输入吧！");
            }
        }
    }
    public static float shouldPayMoney = 0.0f;
    public static ArrayList<IFood> baseFoods = new ArrayList<>();
    public static void getFood() {
        IKfcFactory food = FoodFactory.getInstance("www.homework.chapter_4.kfc.realkfc.KfcFoodFactory");
        while (true) {
            System.out.print("请选择序号点餐:");
            int a = get1_10();
            System.out.print("请选择数量:");
            int b = getIntNum();
            switch (a) {
                case 1:
                    BaseHamburg baseHamburg = food.createPaNiNiHamburg(b);
                    shouldPayMoney += baseHamburg.totalPrice();
                    baseFoods.add(baseHamburg);
                    break;
                case 2:
                    BaseHamburg baseHamburg1 = food.createCrispyChickenHamburg(b);
                    shouldPayMoney += baseHamburg1.totalPrice();
                    baseFoods.add(baseHamburg1);
                    break;
                case 3:
                    BaseChicken baseChicken = food.createHotPotatoChipsChickenWings(b);
                    shouldPayMoney += baseChicken.totalPrice();
                    baseFoods.add(baseChicken);
                    break;
                case 4:
                    BaseChicken baseChicken1 = food.createPiquancyChickenWings(b);
                    shouldPayMoney += baseChicken1.totalPrice();
                    baseFoods.add(baseChicken1);
                    break;
                case 5:
                    BaseBeverage baseBeverage = food.createBaiShiKolaBeverage(b);
                    shouldPayMoney += baseBeverage.totalPrice();
                    baseFoods.add(baseBeverage);
                    break;
                case 6:
                    BaseBeverage baseBeverage1 = food.createCoffeeBeverage(b);
                    shouldPayMoney += baseBeverage1.totalPrice();
                    baseFoods.add(baseBeverage1);
                    break;
                case 7:
                    BaseSweetmeats baseSweetmeats = food.createChocolateWaffleSweetmeats(b);
                    shouldPayMoney += baseSweetmeats.totalPrice();
                    baseFoods.add(baseSweetmeats);
                    break;
                case 8:
                    BaseSweetmeats baseSweetmeats1 = food.createRedBeanPieSweetmeats(b);
                    shouldPayMoney += baseSweetmeats1.totalPrice();
                    baseFoods.add(baseSweetmeats1);
                    break;
                case 9:
                    BaseSetMeal baseSetMeal = food.createWingBucketTenderFiveSides(b);
                    shouldPayMoney += baseSetMeal.totalPrice();
                    baseFoods.add(baseSetMeal);
                    break;
                case 10:
                    BaseSetMeal baseSetMeal1 = food.createSpicyDuckRollPopularStarMealBase(b);
                    shouldPayMoney += baseSetMeal1.totalPrice();
                    baseFoods.add(baseSetMeal1);
                default:
                    break;

            }
            System.out.print("请选择是否继续点餐 1.是   2.否:");
            int c = get12();
            if (c != 1) {
                break;
            }
        }
        System.out.println("总价格：" + shouldPayMoney + "元");
    }

    public static void selectMenu() {
        System.out.println("***************");
        System.out.println("*   1.支付宝  *");
        System.out.println("*   2.微信    *");
        System.out.println("*   3.现金    *");
        System.out.println("***************");
    }
    public static float selectPay(float shouldPayMoney) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Pay pay;
        float resMoney = 0.0f;
        selectMenu();
        int selcet = get13();
        if (selcet == 1) {
            pay = (Pay)Class.forName("www.epochong.homework.chapter_4.kfc.realkfc.AliPay").newInstance();
            HandlerPay handlerPay = new HandlerPay(pay);
            resMoney = handlerPay.countMoney(shouldPayMoney);
        } else if (selcet == 2) {
            pay = (Pay)Class.forName("www.epochong.homework.chapter_4.kfc.realkfc.TencentPay").newInstance();
            HandlerPay handlerPay = new HandlerPay(pay);
            resMoney = handlerPay.countMoney(shouldPayMoney);
        } else if (selcet == 3) {
            pay = (Pay)Class.forName("www.epochong.homework.chapter_4.kfc.realkfc.IPay").newInstance();
            HandlerPay handlerPay = new HandlerPay(pay);
            resMoney = handlerPay.countMoney(shouldPayMoney);
        }
        return resMoney;
    }
    private static float change;
    public static void giveMoney() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        System.out.print("使用优惠券(有则直接输入优惠卷价格，没有则输入0):");
        float cutDown = getFloatNum();
        float giveMoney = 0.0f;


        while (true) {
            System.out.print("您将付多少钱:");
            giveMoney = getFloatNum();
            shouldPayMoney = selectPay(shouldPayMoney);
            change = giveMoney + cutDown - shouldPayMoney;
            if (change < 0) {
                System.out.println("您付的钱不足，请重新付钱！");
            } else {
                System.out.println("找零:" + change);
                break;
            }

        }

    }
    public static void printToFile() throws IOException {
        File file = new File("F:" + File.separator + "kfc.txt");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Writer writer = new FileWriter(file);
        writer.write("****************************************************\r\n");
        writer.write("\t\t\t肯德基小票呀\r\n");
        writer.write("订餐时间  " + simpleDateFormat.format(date) +"\r\n");
        writer.write("  食物\t\t\t\t单价(元)\t数量\t价格(元)\r\n");
        for (int i = 0; i < baseFoods.size(); i++) {
            writer.write(baseFoods.get(i).toString() + "\r\n");
        }
        writer.write("\r\n");
        writer.write("总计  " + shouldPayMoney + "元   找零  " + change + "元\r\n");
        writer.write("收银员  " + "小姐姐\r\n");
        writer.write("欢迎下次光临(*^▽^*)\r\n");
        writer.write("****************************************************\r\n");
        writer.close();

    }
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        System.out.println(AliPay.class);

        menu();
        getFood();
        giveMoney();
        try {
            printToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
