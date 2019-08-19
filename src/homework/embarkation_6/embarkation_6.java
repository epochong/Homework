package www.epochong.homework.embarkation_6;

import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/5/27 8:05
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class embarkation_6 {

    public static void nonRecursionOne() {
        int sum = 2;
        System.out.println("第7个村子后还剩下2只鸭子");
        for (int i = 7; i > 0; i--) {
            sum = (sum + 1) * 2;
            System.out.println("经过第" + i  + "个村庄时还剩下" + sum  + "只鸭子.卖了：" + (sum/2+1) + " 只鸭子");
        }
    }
    public static int recursionOne(int n) {
        int sum;
        if (n == 8) {
            System.out.println("第7个村子后还剩下2只鸭子");
            return 2;
        } else {
            sum = (recursionOne(n + 1) + 1) * 2;
            System.out.println("经过第" + n  + "个村庄时还剩下" +  sum + "只鸭子.卖了：" + (sum/2+1) + " 只鸭子");
            return sum;
        }

    }
    static int time = 0;
    public static void recursionTwo(int n) {
        time++;
        if(n % 2 == 0){
            System.out.print(n + " ");
            recursionTwo(n / 2);

        }
        else{
            if(n == 1) {
                System.out.print(n + " ");
            }
            else {
                System.out.print(n + " ");
                recursionTwo(3 * n + 1);
            }
        }
    }

    static int time2;
    public static void noRecursionTwo(int n) {
        System.out.print(n + " ");
        time2++;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                time2++;
                System.out.print(n + " ");
            } else {
                n = (n * 3) + 1;
                time2++;
                System.out.print(n + " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("第一題递归解法!");
        System.out.println("-------------");
        recursionOne(1);
        System.out.println("---------------");
        System.out.println("第一题非递归解法!");
        System.out.println("---------------");
        nonRecursionOne();
        System.out.println("-------------");
        System.out.println("第二题递归解法!");
        System.out.println("-------------");
        System.out.print("输入一个自然数:>");
        int n = input.nextInt();
        recursionTwo(n);
        System.out.println("\nSTEP:" + time);
        System.out.println("---------------");
        System.out.println("第二题非递归解法!");
        System.out.println("---------------");
        noRecursionTwo(n);
        System.out.println("\nSTEP:" + time2);
    }
}
