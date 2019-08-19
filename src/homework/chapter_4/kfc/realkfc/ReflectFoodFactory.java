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
 * ʳ�����
 */
abstract class BaseFood {
    /**
     * ���
     */
    String name;
    /**
     * ����
     */
    int num;
    /**
     * �۸�
     */
    float price;

    /**
     * �ϼ�
     * @return ʳ���ܼ۸�
     */
    public float totalPrice() {
        return this.num * this.price;
    }
}

/**
 * ����ʳ��ӿ�
 */
interface IFood {
    /**
     * ��ӡ���ʳ����Ϣ
     */
    void printMessage();

}

/**
 * ������ͬʳ��ĳ������
 */

/**
 * ��������
 */
abstract class BaseHamburg extends BaseFood implements IFood {
    @Override
    public void printMessage() {
        System.out.println(this.name + "\t\t\t\t���ۣ�" + this.price + "Ԫ" + "\t\t������" + this.num + "\t\t�ϼƣ�" + this.totalPrice() + "Ԫ");
    }

    @Override
    public String toString() {
        return this.name + "\t\t\t" + String.format("%.1f",this.price)+ "\t\t" + this.num + "\t\t" + this.totalPrice();
    }
}

/**
 * ���������ʳ��
 */
class PaNiNiHamburg extends BaseHamburg {
    PaNiNiHamburg(int num) {
        this.name = "֥ʿ������";
        this.price = 12.5f;
        this.num = num;
    }
}

class CrispyChickenHamburg extends BaseHamburg {
    public CrispyChickenHamburg(int num) {
        this.name = "���༦�ȱ�";
        this.price = 19.0f;
        this.num = num;
    }
}
/**
 * �������
 */
abstract class BaseChicken extends BaseFood implements IFood {
    @Override
    public void printMessage() {
        System.out.println( this.name + "\t\t\t\t���ۣ�" + this.price + "Ԫ" + "\t\t������" + this.num + "\t\t�ϼƣ�" + this.totalPrice() + "Ԫ");
    }

    @Override
    public String toString() {
        return this.name + "\t\t" + String.format("%.1f",this.price) +  "\t\t" + this.num + "\t\t" + this.totalPrice() ;
    }
}

/**
 * ������Ƭ����
 */
class HotPotatoChipsChickenWings extends BaseChicken {
    public HotPotatoChipsChickenWings(int num) {
        this.name = "������Ƭ����";
        this.price = 12.0f;
        this.num = num;
    }
}
/**
 * ��������
 */
class PiquancyChickenWings extends BaseChicken {
    PiquancyChickenWings(int num) {
        this.name = "������������";
        this.price = 12.0f;
        this.num = num;
    }
}


/**
 * ��Ʒ����
 */
abstract class BaseSweetmeats extends BaseFood implements IFood {

    @Override
    public void printMessage() {
        System.out.println(this.name + "\t\t���ۣ�" + this.price + "Ԫ" + "\t\t������" + this.num + "\t\t�ϼƣ�" + this.totalPrice() + "Ԫ");
    }

    @Override
    public String toString() {
        return this.name + "\t\t\t" + String.format("%.1f",this.price)  + "\t\t" + this.num + "\t\t" + this.totalPrice();
    }
}

/**
 * ������Ʒ
 */
class ChocolateWaffleSweetmeats extends BaseSweetmeats {
    ChocolateWaffleSweetmeats(int num) {
        this.name = "�ɿ�������";
        this.price = 11.0f;
        this.num = num;
    }
}

class RedBeanPieSweetmeats extends BaseSweetmeats {
    public RedBeanPieSweetmeats(int num) {
        this.name = "����춹��";
        this.price = 13.0f;
        this.num = num;
    }
}

/**
 * ���ϻ���
 */
abstract class BaseBeverage extends BaseFood implements IFood {
    @Override
    public void printMessage() {
        System.out.println(this.name + "\t\t���ۣ�" + this.price + "Ԫ" + "\t\t������" + this.num + "\t\t�ϼƣ�" + this.totalPrice() + "Ԫ");
    }

    @Override
    public String toString() {
        return this.name + "\t\t\t" + String.format("%.1f",this.price) + "\t\t" + this.num + "\t\t" + this.totalPrice();
    }
}
/**
 * ����
 */
class BaiShiKolaBeverage extends BaseBeverage {
    BaiShiKolaBeverage(int num) {
        this.name = "���¿���";
        this.price = 10.5f;
        this.num = num;
    }
}

/**
 * Ĩ������
 */
class CoffeeBeverage extends BaseBeverage {
    public CoffeeBeverage(int num) {
        this.name = "Ĩ������";
        this.price = 17.0f;
        this.num = num;
    }
}

/**
 * �ײ���
 */
abstract class BaseSetMeal extends BaseFood implements IFood {
    @Override
    public void printMessage() {
        System.out.println(this.name + "\t\t���ۣ�" + this.price + "Ԫ" + "\t\t������" + this.num + "\t\t�ϼƣ�" + this.totalPrice() + "Ԫ");
    }

    @Override
    public String toString() {
        return this.name + "\t" + String.format("%.1f",this.price) + "\t\t" + this.num + "\t\t" + this.totalPrice() ;
    }
}

/**
 * �����ײ�
 */
class WingBucketTenderFiveSides extends BaseSetMeal {
    public WingBucketTenderFiveSides(int num) {
        this.name = "��Ͱ��ţ�巽�ײ�";
        this.price = 89.0f;
        this.num = num;
    }
}
class SpicyDuckRollPopularStarMealBase extends BaseSetMeal {
    public SpicyDuckRollPopularStarMealBase(int num) {
        this.name = "��Ѽ��������ײ�";
        this.price = 39.0f;
        this.num = num;
    }
}

/**
 * ��������
 * ��������ϵ»�����
 * ��������ʳ��
 */
interface IKfcFactory {
    /**
     * ����������
     * @param num Ҫ�������
     * @return BaseHamburg����
     */
    BaseHamburg createPaNiNiHamburg(int num);
    BaseHamburg createCrispyChickenHamburg(int num);
    /**
     * ��������
     * @param num Ҫ�������
     * @return BaseFrenchFries����
     */
    BaseSweetmeats createChocolateWaffleSweetmeats(int num);
    BaseSweetmeats createRedBeanPieSweetmeats(int num);
    /**
     * ��������
     * @param num Ҫ�������
     * @return BaseChicken����
     */
    BaseChicken createHotPotatoChipsChickenWings(int num);
    BaseChicken createPiquancyChickenWings(int num);
    /**
     * ��������
     * @param num Ҫ�������
     * @return BaseBeverage����
     */
    BaseBeverage createBaiShiKolaBeverage(int num);
    BaseBeverage createCoffeeBeverage(int num);

    BaseSetMeal createWingBucketTenderFiveSides(int num);
    BaseSetMeal createSpicyDuckRollPopularStarMealBase(int num);
}

/**
 * ��������ϵ»�����
 * ��������ʳ��
 */
class KfcFoodFactory implements IKfcFactory {
    /**
     * ��������
     * @param num Ҫ�������
     * @return Beverage��������ת��
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
     * �����¶���������
     * @param num Ҫ�������
     * @return BaseChickenWings��������ת��
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
     * ��������
     * @param num Ҫ�������
     * @return FrenchFries��������ת��
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
     * ��������
     * @param num Ҫ�������
     * @return Hamburg��������ת��
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
        System.out.println("ʹ��֧����֧��������5Ԫ���");
        return clientpay - 5;
    }
}

class TencentPay implements Pay {

    @Override
    public float countMoney(float clientpay) {
        System.out.println("ʹ��΢��֧��������������95��");
        return clientpay * 0.95f;
    }
}

class IPay implements Pay {

    @Override
    public float countMoney(float shouldPayMoney) {
        System.out.println("ʹ���ֽ�֧������û���Ż�");
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
                        +"*                 KFC���ϵͳ��                *\n"
                        +"***********************************************\n"
                        +"*********************�˵�***********************\n"
                        +"����\n"
                        + "\t\t1.֥ʿ������\t\t12.5Ԫ\n" + "\t\t2.���༦�ȱ�\t\t19.0Ԫ \n"
                        +"������\n"
                        + "\t\t3.������Ƭ����\t12.0Ԫ\n" + "\t\t4.������������\t12.0Ԫ\n"
                        + "����\n"
                        + "\t\t5.���¿���\t\t10.5Ԫ\n" + "\t\t6.Ĩ������\t\t17.0Ԫ\n"
                        +"���\n"
                        + "\t\t7.�ɿ�������\t\t11.0Ԫ\n" + "\t\t8.����춹��\t\t13.0Ԫ\n"
                        +"�ײ�\n"
                        +"\t\t9.��Ͱ��ţ�巽�ײ�\t\t89.0Ԫ\n"
                        + "\t\t\t�������� 6 ��\n" + "\t\t\t�°¶������� 4 ��\n" + "\t\t\t�������ȱ� 1 ��\n" + "\t\t\t��ţ�巽 1 �� + ���� 2 �� \n"
                        +"\t\t10.��Ѽ������������ײ�\t39.0Ԫ\n"
                        + "\t\t\t�ϱ�������Ѽ��� 1 ��\n" + "\t\t\t��Ǽ� 3 ��\n" + "\t\t\t���������� 1 ��\n" + "\t\t\t���� 1 ��\n"
                        +"*********************************************\n");
    }
    private static int get12() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String re = input.nextLine();
            if (re.equals("2") || re.equals("1")) {
                return Integer.valueOf(re);
            } else {
                System.out.println("�������,��������ɣ�");
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
                System.out.println("�������,��������ɣ�");
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
                System.out.println("���������������ɣ�");
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
                System.out.println("���������������ɣ�");
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
                System.out.println("�������,��������ɣ�");
            }
        }
    }
    public static float shouldPayMoney = 0.0f;
    public static ArrayList<IFood> baseFoods = new ArrayList<>();
    public static void getFood() {
        IKfcFactory food = FoodFactory.getInstance("www.homework.chapter_4.kfc.realkfc.KfcFoodFactory");
        while (true) {
            System.out.print("��ѡ����ŵ��:");
            int a = get1_10();
            System.out.print("��ѡ������:");
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
            System.out.print("��ѡ���Ƿ������� 1.��   2.��:");
            int c = get12();
            if (c != 1) {
                break;
            }
        }
        System.out.println("�ܼ۸�" + shouldPayMoney + "Ԫ");
    }

    public static void selectMenu() {
        System.out.println("***************");
        System.out.println("*   1.֧����  *");
        System.out.println("*   2.΢��    *");
        System.out.println("*   3.�ֽ�    *");
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
        System.out.print("ʹ���Ż�ȯ(����ֱ�������Żݾ�۸�û��������0):");
        float cutDown = getFloatNum();
        float giveMoney = 0.0f;


        while (true) {
            System.out.print("����������Ǯ:");
            giveMoney = getFloatNum();
            shouldPayMoney = selectPay(shouldPayMoney);
            change = giveMoney + cutDown - shouldPayMoney;
            if (change < 0) {
                System.out.println("������Ǯ���㣬�����¸�Ǯ��");
            } else {
                System.out.println("����:" + change);
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
        writer.write("\t\t\t�ϵ»�СƱѽ\r\n");
        writer.write("����ʱ��  " + simpleDateFormat.format(date) +"\r\n");
        writer.write("  ʳ��\t\t\t\t����(Ԫ)\t����\t�۸�(Ԫ)\r\n");
        for (int i = 0; i < baseFoods.size(); i++) {
            writer.write(baseFoods.get(i).toString() + "\r\n");
        }
        writer.write("\r\n");
        writer.write("�ܼ�  " + shouldPayMoney + "Ԫ   ����  " + change + "Ԫ\r\n");
        writer.write("����Ա  " + "С���\r\n");
        writer.write("��ӭ�´ι���(*^��^*)\r\n");
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
