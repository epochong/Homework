package ChapterTwo;
import java.util.Scanner;

public class Main {
    private static int gcd(int a , int  b) {
        if(a % b == 0) {
            return b;
        }
        return gcd( b,a % b);
    }
    /**
     *
     * @param a 整数1
     * @param b 整数2
     * @return a,b的最小公倍数
     */
    private static int multiple(int a, int b) {
        int temp;
        temp = gcd(a,b);
        return (a * b/temp);
    }

    /**
     * 获取正确的输入数据
     * @return 一个数组，包含n个数，这两个数输入正确的输入格式，可以用来求最大公约数，和最小公倍数
     */
    private static int[] getLegalFormat() {
        Scanner input = new Scanner(System.in);
        int n = 3;
        int[] arr = new int[n];
        boolean judge = true;
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = null;
        }
        int[] numStr = new int[n];
        for (int i = 0; i < n; i++) {
            numStr[i] = 0;
        }
        //对输入异常的处理
        while (judge) {
            for (int i = 0; i < n; i++) {
                str[i] = input.next();
            }
            try {
               /* Integer.parseInt(str1);
                Integer.parseInt(str2);*/
                for (int i = 0; i < n; i++) {
                    Integer.parseInt(str[i]);
                }
            } catch (NumberFormatException e) {
                System.out.println("The input format is wrong, please input again!");
                e.printStackTrace();
                continue;
            }
           /* num1 = Integer.parseInt(str1);
            num2 = Integer.parseInt(str2);*/
            for (int i = 0; i < n; i++) {
                numStr[i] = Integer.parseInt(str[i]);
            }
            int positiveNum  = 0;
            for (int i = 0; i < n; i++) {
                if (numStr[i] < 1) {
                    System.out.println("You must input two positive integers!Input again!");
                    judge = true;
                    positiveNum++;
                    break;
                }
            }
            if (positiveNum > 0) {
                continue;
            }
            judge = false;
        }
       /* arr[0]= Integer.parseInt(str1);
        arr[1] = Integer.parseInt(str2);*/
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = getLegalFormat();
        //输出对输入数据的求取最大公约数，或者最小公倍数
        int gcdResult = 0;
        int multipleResult = 0;
        for (int i = 2; i < input.length; i++) {

            multipleResult = multiple(multiple(input[i - 2],input[i - 1]), input[i]);
        }
        System.out.println(multipleResult);
    }
}
