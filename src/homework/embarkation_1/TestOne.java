package EmbarkationOne;

import java.util.Scanner;

public class TestOne {
    /**
     * 获取正确的输入数据
     * @return 一个数组，包含两个数，这两个数输入正确的输入格式，可以用来求最大公约数，和最小公倍数
     */
    public static int[] getlegalFormat() {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[2];
        boolean judge = true;
        String str1 = null, str2 = null;
        int num1,num2;
        //对输入异常的处理
        while (judge) {
            System.out.println("Please input two numbers:");
            str1 = input.next();
            str2 = input.next();

            try {
                Integer.parseInt(str1);
                Integer.parseInt(str2);
            } catch (NumberFormatException e) {
                judge = true;
                System.out.println("The input format is wrong, please input again!");
                e.printStackTrace();

                continue;
            }
            num1 = Integer.parseInt(str1);
            num2 = Integer.parseInt(str2);
            if (num1 < 1 || num2 < 1) {
                System.out.println("You must input two positive integers!Input again!");
                judge = true;
                continue;
            }
            judge = false;
        }
        arr[0]= Integer.parseInt(str1);
        arr[1] = Integer.parseInt(str2);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = getlegalFormat();
        for (int a: arr) {
            System.out.println(a);
        }
    }
}
