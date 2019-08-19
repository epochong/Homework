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
        System.out.println("��7�����Ӻ�ʣ��2ֻѼ��");
        for (int i = 7; i > 0; i--) {
            sum = (sum + 1) * 2;
            System.out.println("������" + i  + "����ׯʱ��ʣ��" + sum  + "ֻѼ��.���ˣ�" + (sum/2+1) + " ֻѼ��");
        }
    }
    public static int recursionOne(int n) {
        int sum;
        if (n == 8) {
            System.out.println("��7�����Ӻ�ʣ��2ֻѼ��");
            return 2;
        } else {
            sum = (recursionOne(n + 1) + 1) * 2;
            System.out.println("������" + n  + "����ׯʱ��ʣ��" +  sum + "ֻѼ��.���ˣ�" + (sum/2+1) + " ֻѼ��");
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
        System.out.println("��һ�}�ݹ�ⷨ!");
        System.out.println("-------------");
        recursionOne(1);
        System.out.println("---------------");
        System.out.println("��һ��ǵݹ�ⷨ!");
        System.out.println("---------------");
        nonRecursionOne();
        System.out.println("-------------");
        System.out.println("�ڶ���ݹ�ⷨ!");
        System.out.println("-------------");
        System.out.print("����һ����Ȼ��:>");
        int n = input.nextInt();
        recursionTwo(n);
        System.out.println("\nSTEP:" + time);
        System.out.println("---------------");
        System.out.println("�ڶ���ǵݹ�ⷨ!");
        System.out.println("---------------");
        noRecursionTwo(n);
        System.out.println("\nSTEP:" + time2);
    }
}
