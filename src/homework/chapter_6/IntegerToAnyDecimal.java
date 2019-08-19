package www.epochong.homework.chapter_6;

import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/5/29 12:38
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe 将非负十进制整数n转换成b进制。（其中b=2~16）
 */
public class IntegerToAnyDecimal {
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
    final static char [] DigitOnes = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
    } ;

    final static char [] DigitTens = {
            '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
            '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
            '2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
            '3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
            '4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
            '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
            '6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
            '7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
            '8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
            '9', '9', '9', '9', '9', '9', '9', '9', '9', '9',
    } ;
    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    /**
     * 返回x的位数,比如为1位数返回1,为2位数返回2
     * @param x 要求位数的值
     * @return x的位数
     */
    static int stringSize(int x) {
        for (int i = 0; ; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }
    static void getChars(int i, int index, char[] buf) {
        int q, r;
        int charPos = index;
        char sign = 0;
        if (i < 0) {
            sign = '-';
            i = -i;
        }
        // 每次迭代生成两位数字
        while (i >= 65536) {
            q = i / 100;
            // 实际上: r = i - (q * 100); r得到i的后两位的大小 如为65536,则r = 36,r 确保一定是两位数
            r = i - ((q << 6) + (q << 5) + (q << 2));
            i = q;
            //DigitOnes获得i后两位的个位
            buf [--charPos] = DigitOnes[r];
            //DigitOnes获得i后两位的十位
            buf [--charPos] = DigitTens[r];
        }
        // 下降到快速模式为较小的数字
        // assert(i <= 65536, i);
        for (;;) {
            q = (i * 52429) >>> (16+3);
            // r = i-(q*10) ...
            r = i - ((q << 3) + (q << 1));
            buf [--charPos] = digits [r];
            i = q;
            if (i == 0) {break;}
        }
        //sign为标志,如果不为0就是'-'表示负数
        if (sign != 0) {
            buf [--charPos] = sign;
        }
    }


    public static String toString(int i) {
        if (i == Integer.MIN_VALUE) {
            return "-2147483648";
        }
        int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
        char[] buf = new char[size];
        getChars(i, size, buf);
        return new String(buf);
    }

    public static String noReInterToAnyDecimal(int i, int radix) {
        /*
         * 进制数小于2或大于36，radix = 10
         */
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
            {radix = 10;}

        /* Use the faster version */
        if (radix == 10) {
            return toString(i);
        }

        char[] buf = new char[33];
        boolean negative = (i < 0);
        int charPos = 32;

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = digits[-(i % radix)];
            i = i / radix;
        }
        buf[charPos] = digits[-i];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }

    /**
     *  递归调用
     * @param  num 十进制数
     * @param  radix 要转换成的进制数
     */
    public static String reIntegerToAnyDecimal(int num,int radix) {
        String digit = "0123456789abcdef";
        String str = "";
        if(num == 0){
            return "";
        }else {
            str = reIntegerToAnyDecimal(num / radix,radix);
            return str + digit.charAt(num % radix);
        }
    }

    /**
     * 任何一个正整数都可以用2的幂次方表示。
     * @param n 整数
     */
    public static void twoIntegerTo2Pow(int n) {
        //判断n为1，输出2(0)，结束
        if (n != 1) {
            //判断n为2，输出2，结束
            if (n != 2) {
                int i = 0;
                while (Math.pow(2, i) <= n) {
                    i++;
                }
                //计算最大的2的幂次方i-1
                //先输出一个2
                System.out.print("2");
                //如果是2的1次，什么都不输出
                if (i - 1 == 1) {
                } else {
                    //输出左括号
                    System.out.print("(");
                    //递归调用
                    twoIntegerTo2Pow(i - 1);
                    //输出右括号
                    System.out.print(")");
                }
                //减去已经输出的值
                n -= Math.pow(2, i - 1);
                //判断剩余的n是否为0
                if (n == 0) {
                    return;
                }
                //不为0，就输出+号
                System.out.print("+");
                //递归调用
                twoIntegerTo2Pow(n);
            } else {
                System.out.print("2");
                return;
            }
        } else {
            System.out.print("2(0)");
            return;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print(n + "的2的次幂表示:>");
        twoIntegerTo2Pow(n);
        Integer.toString(2,2);
    /*    System.out.println(0 + "~" + n + "的2的次幂表示");
        for (int i = 0; i < 20; i++) {
            System.out.print(i + "的2的次幂表示:>");
            twoIntegerTo2Pow(i);
            System.out.println();
        }*/
        //System.out.println();
/*        System.out.println(reIntegerToAnyDecimal(n,2));
        System.out.println(noReInterToAnyDecimal(n,2));*/
    }
}
