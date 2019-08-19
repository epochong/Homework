package www.epochong.homework.chapter_6;

import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/5/29 12:38
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe ���Ǹ�ʮ��������nת����b���ơ�������b=2~16��
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
     * ����x��λ��,����Ϊ1λ������1,Ϊ2λ������2
     * @param x Ҫ��λ����ֵ
     * @return x��λ��
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
        // ÿ�ε���������λ����
        while (i >= 65536) {
            q = i / 100;
            // ʵ����: r = i - (q * 100); r�õ�i�ĺ���λ�Ĵ�С ��Ϊ65536,��r = 36,r ȷ��һ������λ��
            r = i - ((q << 6) + (q << 5) + (q << 2));
            i = q;
            //DigitOnes���i����λ�ĸ�λ
            buf [--charPos] = DigitOnes[r];
            //DigitOnes���i����λ��ʮλ
            buf [--charPos] = DigitTens[r];
        }
        // �½�������ģʽΪ��С������
        // assert(i <= 65536, i);
        for (;;) {
            q = (i * 52429) >>> (16+3);
            // r = i-(q*10) ...
            r = i - ((q << 3) + (q << 1));
            buf [--charPos] = digits [r];
            i = q;
            if (i == 0) {break;}
        }
        //signΪ��־,�����Ϊ0����'-'��ʾ����
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
         * ������С��2�����36��radix = 10
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
     *  �ݹ����
     * @param  num ʮ������
     * @param  radix Ҫת���ɵĽ�����
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
     * �κ�һ����������������2���ݴη���ʾ��
     * @param n ����
     */
    public static void twoIntegerTo2Pow(int n) {
        //�ж�nΪ1�����2(0)������
        if (n != 1) {
            //�ж�nΪ2�����2������
            if (n != 2) {
                int i = 0;
                while (Math.pow(2, i) <= n) {
                    i++;
                }
                //��������2���ݴη�i-1
                //�����һ��2
                System.out.print("2");
                //�����2��1�Σ�ʲô�������
                if (i - 1 == 1) {
                } else {
                    //���������
                    System.out.print("(");
                    //�ݹ����
                    twoIntegerTo2Pow(i - 1);
                    //���������
                    System.out.print(")");
                }
                //��ȥ�Ѿ������ֵ
                n -= Math.pow(2, i - 1);
                //�ж�ʣ���n�Ƿ�Ϊ0
                if (n == 0) {
                    return;
                }
                //��Ϊ0�������+��
                System.out.print("+");
                //�ݹ����
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
        System.out.print(n + "��2�Ĵ��ݱ�ʾ:>");
        twoIntegerTo2Pow(n);
        Integer.toString(2,2);
    /*    System.out.println(0 + "~" + n + "��2�Ĵ��ݱ�ʾ");
        for (int i = 0; i < 20; i++) {
            System.out.print(i + "��2�Ĵ��ݱ�ʾ:>");
            twoIntegerTo2Pow(i);
            System.out.println();
        }*/
        //System.out.println();
/*        System.out.println(reIntegerToAnyDecimal(n,2));
        System.out.println(noReInterToAnyDecimal(n,2));*/
    }
}
