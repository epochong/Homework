package www.epochong.homework.chapter_3;

import java.io.*;
import java.util.*;

public class FourRandomGameExceptionThreadOf24 {
    private static final int CardsNumber = 4;
    private static final int ResultValue = 24;
    private static double number[] = new double[CardsNumber];
    private static String result[] = new String[CardsNumber];
    private static HashMap<Integer,String> map = new HashMap<>();//存放结果Hash表，key为按递增序列排序的，方便对map的操作
    private static int hashSize = 0;
    private static HashMap<Integer,String> JQKA = new HashMap<>();//存放数字和扑克牌一一对应关系
    private static ArrayList<String> str = new ArrayList();
    private static Set<Person> treeMap = new TreeSet<>();//用存放Person类的信息，方便按照分数由高到底输出
    static {
        JQKA.put(1,"A");
        JQKA.put(2,"2");
        JQKA.put(3,"3");
        JQKA.put(4,"4");
        JQKA.put(5,"5");
        JQKA.put(6,"6");
        JQKA.put(7,"7");
        JQKA.put(8,"8");
        JQKA.put(9,"9");
        JQKA.put(10,"10");
        JQKA.put(11,"J");
        JQKA.put(12,"Q");
        JQKA.put(13,"K");
    }

    /**
     * 对随机的四个数进行递归且24点，穷举了所有可能，将结果存储到map中
     * @param n 要递归的操作数的个数
     */
    private static void PointsGame(int n) {
        if (n == 1) {
            if (Math.abs(number[0] - ResultValue) == 0) {
                if (!map.containsValue(result[0])) {
                    map.put(hashSize++,result[0]);
                }
                return ;
            } else {
                return ;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a;
                double b;
                String expa;
                String expb;
                a = number[i];
                b = number[j];
                number[j] = number[n - 1];

                expa = result[i];
                expb = result[j];
                result[j] = result[n - 1];
                //避免了因交换律产生的多个重复的解
                if (a <= b) {
                    result[i] = '(' + expa + '+' + expb + ')';
                    number[i] = a + b;
                    PointsGame(n - 1);
                }
                result[i] = '(' + expa + '-' + expb + ')';
                number[i] = a - b;
                PointsGame(n - 1);


                result[i] = '(' + expb + '-' + expa + ')';
                number[i] = b - a;
                PointsGame(n - 1);

                if (a <= b) {
                    result[i] = '(' + expa + '*' + expb + ')';
                    number[i] = a * b;
                    PointsGame(n - 1);
                }
                if (b != 0) {
                    result[i] = '(' + expa + '/' + expb + ')';
                    number[i] = a / b;
                    PointsGame(n - 1);
                }

                if (a != 0) {
                    result[i] = '(' + expb+ '/' + expa + ')';
                    number[i] = b / a;
                    PointsGame(n - 1);
                }
                number[i] = a;
                number[j] = b;
                result[i] = expa;
                result[j] = expb;
            }
        }
    }

    /**
     * 简单的开始界面函数
     */
    private static void menu() {
        System.out.println("*****************");
        System.out.println("*   24点游戏     *");
        System.out.println("*   1.开始       *");
        System.out.println("*   2.排名       *");
        System.out.println("*   3.结束       *");
        System.out.println("*****************");
    }

    /**
     * 对用户按照分数进行排序，通过TreeSet集合可以简单的实现，只要向里面存储就行了
     * @throws FileNotFoundException
     */
    public static void sort() throws FileNotFoundException {
        Scanner input = new Scanner(new File("F:\\Program\\sort\\IDEA\\Arithmetic\\src\\www\\homework\\chapter_3\\TopList.txt"));
        //input.useDelimiter("\r\n");
        while (input.hasNextLine()) {
            String scannerRead  = input.nextLine();
            treeMap.add(new Person(scannerRead.split(" ")[0],Integer.valueOf(scannerRead.split(" ")[1])));
            /*for (int i = 0; i < str.size(); i++) {
                for (int j = i; j >0; j--) {
                    String[] spj = str.get(j).split(" ");
                    String[] spj_1 = str.get((j - 1)).split(" ");
                    if (Integer.valueOf(spj[1]) > Integer.valueOf(spj_1[1])) {
                        String temp = str.get(j);
                        str.set(j,str.get(j - 1));
                        str.set(j - 1,temp);
                    }
                }
            }*/
        }

    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int select;
        while (true) {
            menu();
            System.out.println("select:>");
            select = input.nextInt();
            if (select == 3) {
                break;
            } else if (select == 2) {
                sort();
                System.out.println(treeMap);
            } else if (select == 1) {
                System.out.println("请输入用户ID:");
                input.nextLine();
                String ID = input.nextLine();
                Person person = new Person(ID);
                while (person.life != 0) {

                    System.out.println("随机的4个扑克牌是");
                    for (int i = 0; i < CardsNumber; i++) {
                        int x = (int) (Math.random() * 13) + 1;
                        if (x <= 10 && x >= 2) {
                            System.out.print(x + " ");
                        } else {
                            System.out.print(JQKA.get(x) + " ");
                        }
                        number[i] = x;
                        result[i] = JQKA.get(x);
                    }
                    PointsGame(CardsNumber);
                    if (map.size() == 0) {
                        System.out.println();
                        System.out.println("这组组合没有解,进行下一组!");
                        continue;
                    } else {
                        System.out.println();
                        System.out.println("答案表如下!");
                        for (int mapKey : map.keySet()
                                ) {
                            System.out.println(map.get(mapKey));
                        }
                    }
                    System.out.println("您有30秒的时间答题！");
                    System.out.println("请输入求24点的表达式:");

                    /**
                     * 倒计时操作
                     */
                    int time = 0;
                    new Timer().schedule(new MyTimerTask1(), 2000);
                    // 下面这段代码是每隔1秒,打印下当前的时间
                    while (true) {
                        try {
                            if (input.hasNext()) {//在有输入的时候提前跳出，判断是否正确
                                break;
                            }
                            if (++time == 3) {
                                System.out.println("30秒时间到,进入下一题,减少1个生命值！");
                                System.out.println("你还剩下" + (--person.life) + "的生命值！");
                                System.out.println("1.继续");
                                System.out.println("2.不玩了");
                                /*for (int i = hashSize - 1; i >= 0; i--) {
                                    map.remove(i);
                                }*/
                                map.clear();
                                break;
                            }

                            Thread.sleep(1000);//其实这是一个线程，让程序停滞1秒钟

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //用户再此输入答案
                    String personResult = input.nextLine();
                    if (personResult.equals("1")) {
                        continue;
                    } else if (personResult.equals("2")) {
                        break;
                    }
                    if (map.containsValue(personResult)) {
                        System.out.println("表达式正确,加10分!进入下一题!");
                        person.score += 10;
                    } else {
                        System.out.println("答题错误,进入下一题,减少1个生命值！");
                        System.out.println("你还剩下" + (--person.life) + "的生命值！");
                    }
                    map.clear();
                }
                if (person.life == 0) {
                    System.out.println("您的生命值已用完,游戏结束!");
                } else {
                    System.out.println("您已结束游戏!");
                }
                System.out.println("用户:" + person.ID);
                System.out.println("分数:" + person.score);
                //存入文件的操作
                File user = new File("F:\\Program\\sort\\IDEA\\Arithmetic\\src\\www\\homework\\chapter_3\\TopList.txt");
                Writer out = new FileWriter(user,true);
                Scanner fileScanner = new Scanner(user);
                ArrayList<String> fileReadStr = new ArrayList<>();
                while (fileScanner.hasNextLine()) {
                    fileReadStr.add(fileScanner.nextLine());
                }
                /**
                 * 下面是判断用户是否是之前有过记录的用户
                 * 如果用具名称相同，只修改他现有的分数即可
                 * 其实这一部分用HashMap作为数据结构然后结合文件进行操作即可
                 * 这里是使用字符串切割然后比较的方式
                 */
                int contain = 0;
                for (int i = 0; i < fileReadStr.size(); i++) {
                    if (fileReadStr.get(i).split(" ")[0].equals(person.ID)) {
                        fileReadStr.set(i,person.ID + " " + person.score + "\r\n");
                        out.write(fileReadStr.get(i));
                        contain = 1;
                    } else {
                        out.write(fileReadStr.get(i) + "\r\n");
                    }
                }
                if (contain == 0) {
                    out.write(person.ID + " " + person.score + "\r\n");
                }
                out.close();
            }
        }
        System.out.println("游戏结束,祝您生活愉快!");
    }
}
