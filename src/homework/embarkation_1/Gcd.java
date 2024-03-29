package www.epochong.homework.embarkation_1;
/**
* @describe
* @file Gcd
* @author epochong
* @date 2019/3/5 
* @params 
* @return 
* @email 876459397@qq.com
* @CSDN https://blog.csdn.net/wfcn_zyq
*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Sopwatch 创建对象时会直接记录创建的时间
 * elapsedTime() 返回Soapwatch自创建到调用这个函数这个期间经历的纳秒数
 */
class Stopwatch {
    private final long start;
    public Stopwatch() {
        start = System.nanoTime();
    }
    public double elapsedTime() {
        long now = System.nanoTime();
        return (now - start);
    }
}

public class Gcd {
    /**
     * 其算法过程为： 前提：设两数为a,b设其中a 做被除数,b做除数，temp为余数
     * 1、大数放a中、小数放b中；
     * 2、求a/b的余数；
     * 3、若temp=0则b为最大公约数；
     * 4、如果temp!=0则把b的值给a、temp的值给a；
     * 5、返回第二步；
     * @param a
     * @param b
     * @return 最大公约数
     */
    private static int divisor(int a, int b) {
        int temp;
        if(a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        while(b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    /**
     *
     * @param a 整数1
     * @param b 整数2
     * @return a,b的最小公倍数
     */
    private static int multiple(int a, int b) {
        return (a * b / divisor(a,b));
    }

    /**
     * 辗转相除法的递归调用
     * @param a 整数1
     * @param b 整数2
     * @return a,b的最大公约数
     */
    private static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        else {
            return gcd(b,a%b);
        }
    }

    /**
     * 穷举法（也叫枚举法）穷举法求两个正整数的最大公约数的解题步骤：
     * 从两个数中较小数开始由大到小列举，
     * 直到找到公约数立即中断列举，得到的公约数便是最大公约数 。
     * 对两个正整数a,b如果能在区间[a,0]或[b,0]内能找到一个整数temp
     * 能同时被a和b所整除，则temp即为最大公约数。
     * @param a
     * @param b
     * @return a,b的最大公约数
     */
    private static int enumerateDivisor(int a, int b) {
        int temp = a > b ? b : a;
        while (temp > 0) {
            if (a % temp == 0 && b % temp == 0) {
                break;
            }
            temp--;
        }
        return temp;
    }

    /**
     * 枚举法求对两个正整数a,b的最小公倍数
     * 如果若干个a之和或b之和能被b所整除或能被a所整除，
     * 则该和数即为所求的最小公倍数。
     * @param a
     * @param b
     * @return a,b的最小公倍数
     */
    private static int addMultiple(int a, int b) {
        int max = a > b ? a : b;
        int min = a > b ? b : a;
        int temp = max;
        while (true) {
            if (max % min == 0) {
                break;
            }
            max += temp;
        }
        return max;
    }
    /**
     * 更小减损法求两个数的最大公因数
     * 第一步：任意给定两个正整数；判断它们是否都是偶数。
     * 若是，则用2约简；若不是则执行第二步。
     * 第二步：以较大的数减较小的数，接着把所得的差与较小的数比较，
     * 并以大数减小数。继续这个操作，直到所得的减数和差相等为止。
     * 则第一步中约掉的若干个2与第二步中等数的乘积就是所求的最大公约数。
     * 其中所说的“等数”，就是最大公约数。求“等数”的办法是“更相减损”法。
     * 所以更相减损法也叫等值算法。
     * @param a
     * @param b
     * @return a,b的最大公约数
     */
    private static int GCDDivisor(int a ,int b) {
        while (a!=b)    {
            if (a>b) {
                a -= b;
            }
            else     {
                b-=a;
            }
        }
        return a;
    }


    /**
     * stein算法
     * 1.均为偶数 gcd( x,y ) =2gcd( x/2,y/2 )；
     * 2.均为奇数 gcd( x,y ) = gcd( (x+y)/2,(x-y)/2 )；
     * 2.x奇y偶   gcd( x,y ) = gcd( x,y/2 )；
     * 3.x偶y奇   gcd( x,y ) = gcd( x/2,y )  或 gcd( x,y )=gcd( y,x/2 )；
     * @param x
     * @param y
     * @return x,y的最大公因数
     */
    private static int stein(int x, int y) {
        int factor = 0;
        int temp;
        if (x < y) {
            temp = x;
            x = y;
            y = temp;
        }
        if (0 == y) {
            return 0;
        }
        while (x != y) {
            if (!isEvenNumber(x & 0x1)) {
                if (!isEvenNumber(y & 0x1)) {
                    y = (x - y) >> 1;
                    x -= y;
                } else {
                    y >>= 1;
                }
            } else {
                if (!isEvenNumber(y & 0x1)) {
                    x >>= 1;
                    if (x < y) {
                        temp = x;
                        x = y;
                        y = temp;
                    }
                } else {
                    x >>= 1;
                    y >>= 1;
                    ++factor;
                }
            }
        }
        return(x << factor);
    }

    /**
     * stein的递归调用
     * @param u
     * @param v
     * @return u,v的最大公因数
     */
    private static int steinRecursion(int u, int v) {
        if (u == 0) {
            return v;
        }
        if(v == 0) {
            return u;
        }
            if(!isEvenNumber(~u & 1)) {
                if(!isEvenNumber(v & 1)) {
                    return steinRecursion(u >> 1,v);
                } else {
                    return steinRecursion(u >> 1,v >> 1) << 1;
                }
            }
            if(!isEvenNumber(~v & 1)) {
                return steinRecursion(u,v >> 1);
            }
            if(u > v) {
                return steinRecursion((u - v) >> 1,v);
            }

         return steinRecursion((v - u) >> 1,u);
    }

    /**
     *  求n是否为偶数
     * @param n
     * @return n为偶数返回true，否则返回false
     */
    private static boolean isEvenNumber(int n) {
        return (((n >> 1) << 1) == n);
    }

    /**
     *
     * @param maxSize
     * @param maxValue
     * @return 返回一个二维数组，maxSize行，2列，数组中的每个数都是随机的，随机大小在[0,maxValue]范围内
     */
    public static int[][] generateRandomArray(int maxSize,int maxValue) {
        int[][] arr = new int[maxSize][2];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = (int) ((maxValue + 1) * Math.random()) + 1;
            }
        }
        return arr;
    }

    /**
     *
     * @param arr
     * @param select
     * @return 返回对应select的求最大公因数或最小公倍数函数的运行时间，
     */
    public static double runTime(int[][] arr, int select) {
        //创建Stopwatch变量，记录他常见开始时间
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < arr.length; i++) {
            switch (select) {
                case 1:
                    divisor(arr[i][0],arr[i][1]);
                    break;
                case 2:
                    gcd(arr[i][0],arr[i][1]);
                    break;
                case 3:
                    enumerateDivisor(arr[i][0],arr[i][1]);
                    break;
                case 4:
                    GCDDivisor(arr[i][0],arr[i][1]);
                    break;
                case 5:
                     stein(arr[i][0],arr[i][1]);
                    break;
                case 6:
                    steinRecursion(arr[i][0],arr[i][1]);
                    break;
                case 7:
                    addMultiple(arr[i][0],arr[i][1]);
                    break;
                case 8:
                    multiple(arr[i][0],arr[i][1]);
                    break;
            }
        }
        //调用函数elapsedTime()返回从创建开始到结束的时间
        return timer.elapsedTime();

    }


    /**
     * 输入i对应的函数的输出信息提示
     * @param i
     */
    public static void printTime(int i) {
        switch (i) {
            case 1:
                System.out.print("Time of divisor is:");
                break;
            case 2:
                System.out.print("Time of gcd is:");
                break;
            case 3:
                System.out.print("Time of enumerateDivisor is:");
                break;
            case 4:
                System.out.print("Time of GCDDivisor is:");
                break;
            case 5:
                System.out.print("Time of stein is:");
                break;
            case 6:
                System.out.print("Time of steinRecursion is:");
                break;
            case 7:
                System.out.print("Time of addMultiple is:");
                break;
            case 8:
                System.out.print("Time of multiple is:");
                break;
        }
    }

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
        int[] input = getlegalFormat();
        //输出对输入数据的求取最大公约数，或者最小公倍数
        System.out.println("divisor is:" + divisor(input[0],input[1]) );
        System.out.println("gcd is:" + gcd(input[0],input[1])  );
        System.out.println("enumerateDivisor is:" + enumerateDivisor(input[0],input[1]) );
        System.out.println("stein is:" + stein(input[0],input[1]) );
        System.out.println("steinRecursion is:" + steinRecursion(input[0],input[1]) );
        System.out.println("addMultiple is:" + addMultiple(input[0],input[1]) );
        System.out.println("multiple is:" + multiple(input[0],input[1])  );
        int maxValue = 100000;
        double[] sumTime = new double[8];
        //5组数据
        for (int i = 1; i <= 5; i++) {
            int maxSize = 20 * i;
            System.out.printf("Values of %d",maxSize);
            System.out.println();
            System.out.println("**********************************");
            int[][] arr = generateRandomArray(maxSize,maxValue);
            for (int j = 1; j <= 8; j++) {
                printTime(j);
                sumTime[j - 1] += runTime(arr,j);
                System.out.println(runTime(arr,j) + "ns");
            }

            System.out.println("**********************************");
        }
        System.out.println("Average time is (sort from smallest to biggest )");
        //创建hash表，处理对应的函数信息，和运行时间意义对应
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 1; i <= 8; i++) {
            map.put(sumTime[i - 1],i);
        }
        Arrays.sort(sumTime);
        for (int i = 0; i < 8; i++) {
            printTime(map.get(sumTime[i]));
            System.out.println(sumTime[i] / 5 + "ns");
        }
        System.out.println("**********************************");

    }
}

