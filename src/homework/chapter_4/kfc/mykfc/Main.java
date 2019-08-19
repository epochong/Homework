package www.epochong.homework.chapter_4.kfc.mykfc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/4/19 21:23
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class Main {
    public static void menu() {
        System.out.println("欢迎进入今晚吃鸡汉堡店点餐系统！\n"
                +"******************大吉大利菜单******************\n"
                +"汉堡类：\n"
                + "1.鸡腿堡--15.0元                             2.烤鸡腿堡--17.0元 \n"
                + "3.超级牛肉堡--17.0元                          4.全虾堡--17.0元\n"
                +"鸡肉类：\n"
                + "5.烤翅--6.0元                                6.烤鸡腿--12.0元\n"
                + "7.鸡米花--11.0元\n"
                + "甜点类：\n"
                + "8.薯条--8元                                   9.蛋挞--4元\n"
                + "10.圣代--6元\n"
                +"饮品类：\n"
                + "11.可乐--6元                                  12.奶茶--6元\n"
                + "13.咖啡--12元\n"
                +"套餐类：\n"
                +"14.单人套餐--33元\n"
                + "  1个鸡腿堡+1个烤鸡腿+1包薯条+1杯可乐/奶茶（任点）\n"
                +"15.双人套餐:--54元\n"
                + "  1个鸡腿堡+1个烤鸡腿堡/超级牛肉堡/全虾堡（任点）\n"
                + "  1对奥尔良烤翅+2个蛋挞+2杯可乐/奶茶（任点）\n"
                +"16.三人套餐--109元\n"
                + "  3个奥尔良烤鸡腿堡/超级牛肉堡/全虾堡（任点）\n"
                + "  1对奥尔良烤翅+1个烤鸡腿+1包鸡米花\n"
                + "  1包薯条+2杯圣代+2杯可乐/奶茶（任点）+1杯咖啡\n"
                +"*********************************************\n");
    }
    public static void main(String[] args) throws IOException {
        /**
         * 定义一个肯德基（factory类型）
         */
        Factory factory = new KFCFactory();
        /**
         * 创建客户
         */
        Customer customer = new Customer(factory);
        /**
         * 客户点餐
         */
        Scanner input = new Scanner(System.in);
        float zingerBurger = 0;
        float orleansBurger = 0;
        float beefBurger = 0;
        float shrimpBurger = 0;
        float chickenWings = 0;
        float drumStick = 0;
        float popcornChicken = 0;
        float chips = 0;
        float eggTart = 0;
        float sundae = 0;
        float kola = 0;
        float milky = 0;
        float coffee = 0;
        float oneCombo = 0;
        float twoCombo = 0;
        float threeCombo = 0;
        menu();
        while (true) {
            System.out.println("请选择序号点餐");
            int a = input.nextInt();
            System.out.println("请选择数量");
            int b = input.nextInt();
            switch (a) {
                case 1:
                    //鸡腿堡
                    zingerBurger = customer.orderZingerBurger(b);
                    break;
                case 2:
                    //烤鸡腿堡
                    orleansBurger = customer.orderOrleansBurger(b);
                    break;
                case 3:
                    //牛肉堡
                    beefBurger = customer.orderBeefBurger(b);
                    break;
                case 4:
                    //全虾堡
                    shrimpBurger = customer.orderShrimpBurger(b);
                    break;
                case 5:
                    //烤鸡翅
                    chickenWings = customer.orderChickenWings(b);
                    break;
                case 6:
                    //烤鸡腿
                    drumStick = customer.orderDrumStick(b);
                    break;
                case 7:
                    //鸡米花
                    popcornChicken = customer.orderPopcornChicken(b);
                    break;
                case 8:
                    //薯条
                    chips = customer.orderChips(b);
                    break;
                case 9:
                    //蛋挞
                    eggTart = customer.orderEggTart(b);
                    break;
                case 10:
                    //圣代
                    sundae = customer.orderSundae(b);
                    break;
                case 11:
                    //可乐
                    kola = customer.orderKola(b);
                    break;
                case 12:
                    //奶茶
                    milky = customer.orderMilky(b);
                    break;
                case 13:
                    //咖啡
                    coffee = customer.orderCoffee(b);
                    break;
                case 14:
                    //单人套餐
                    oneCombo = customer.orderOneCombo(b);
                    break;
                case 15:
                    //双人套餐
                    twoCombo = customer.orderTwoCombo(b);
                    break;
                case 16:
                    //三人套餐
                    threeCombo = customer.orderThreeCombo(b);
                    break;
                default:
                    break;

            }
            System.out.println("请选择是否继续点餐，1.是   2.否");
            int c = input.nextInt();
            if (c != 1) {
                break;
            }
        }
        float money1 = zingerBurger + orleansBurger + beefBurger + shrimpBurger;
        float money2 = chickenWings + drumStick + popcornChicken;
        float money3 = chips + eggTart + sundae;
        float money4 = kola + milky + coffee;
        float money5 = oneCombo + twoCombo + threeCombo;
        float money = money1 + money2 + money3 + money4 + money5;
        System.out.println("此次点餐共计：" + money);
        System.out.println("请问您是否具有优惠券？ 1.是   2.否");
        int c = input.nextInt();
        int d = 0;
        if (c == 1) {
            System.out.println("请输入优惠券金额");
            d = input.nextInt();
        }
        System.out.println("请输入实付金额");
        int e = input.nextInt();
        float changes = e - money - d;
        System.out.println("找零：" + changes);
        System.out.println("欢迎下次点餐，祝您用餐愉快！");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        File file = new File("F:\\kfc.txt");
        Writer writer = new FileWriter(file,true);
        writer.write("******************************");
        writer.write("         肯德基               ");
        writer.write("订单时间 " + simpleDateFormat.format(date));
        writer.write("名称           " + "单价          " + "数量           " + "价格");
        writer.write("d           " + "单价          " + "数量           " + "价格");
        writer.write("名称           " + "单价          " + "数量           " + "价格");
        writer.write("名称           " + "单价          " + "数量           " + "价格");
    }
}
