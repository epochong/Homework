package EmbarkationTwo;

import java.util.Scanner;

public class Turing {
    /**
     * 实现将一个字符串转换成对应的二进制扩展码
     * @param str
     * @return 返回str的二进制扩展码
     */
    private static String toBinaryExtend(String str) {
        char[] arr = str.toCharArray();
        if (arr[0] == '0') {
            return "0";
        }
        StringBuilder cur = new StringBuilder();
        cur = cur.append("010");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '1') {
                cur = cur.append("10");
            } else {
                cur = cur.append("0");
            }
        }
        return cur.append("110").toString();
    }

    /**
     * 打印数组当前状态的值
     * @param arr 待打印数组
     * @param i 操作到数组中第 i 个字符
     * @param state 此时图灵机的状态
     */
    private static void printArray(char[] arr, int i, int state) {
        System.out.printf("第%2d步:",i + 1);
        System.out.printf("内部状态:%-2d 当前值:%c 扩展码:",state,arr[i]);
        for (char ch: arr
             ) {
            System.out.print(ch);
        }
        System.out.println();
    }

    /**
     * 图灵机实现乘的过程
     * @param str 二进扩展码
     * @return 对应二进制扩展码的完成乘2之后得到的扩展码
     */
    private static String processXNMultiTwo(String str) {
        int state = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (state == 0 && arr[i] == '0') {
                printArray(arr,i,state);
                arr[i] = '0';
                state = 0;
            } else if (state == 0 && arr[i] == '1') {
                printArray(arr,i,state);
                arr[i] = '0';
                state = 1;
            } else if (state == 1 && arr[i] == '0') {
                printArray(arr,i,state);
                arr[i] = '1';
                state = 0;
            } else if (state == 1 && arr[i] == '1') {
                printArray(arr,i,state);
                arr[i] = '0';
                state = 10;
            } else if (state == 10 && arr[i] == '0') {
                printArray(arr,i,state);
                arr[i] = '1';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char anArr : arr) {
            sb.append(anArr);
        }
        sb.append("1");
        printArray(sb.toString().toCharArray(),arr.length,11);
        sb.append("0");
        printArray(sb.toString().toCharArray(),arr.length + 1,0);
        System.out.println("STOP");
        return sb.toString();
    }

    /**
     * 求一个字符串对应的二进制
     * @param str 待求二进制的字符串
     * @return str的二进制表示
     */
    private static String extendToBinary(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1' && arr[i + 1] == '0') {
                sb.append('1');
            } else if ((i + 1) < arr.length && arr[i] == '0' && arr[i + 1] == '0') {
                sb.append('0');
            } else if (arr[i] == '1' && arr[i + 1] == '1') {
                sb.append(',');
                i++;
            }
        }
        return sb.toString();
    }

    /**
     * 求一个字符串(二进制)的整数形式
     * @param str 待求整数的二进制字符串
     * @return str的对应的十进制整数
     */
    private static int binaryToInt(String str) {
        int n = str.length() - 1;
        String indexStr = str.substring(0,str.length() - 1);
        char[] arr = indexStr.toCharArray();
        int sum = 0;
        boolean judge = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                judge = true;
            }
            if (judge) {
                sum += (arr[i] - 48) * Math.pow(2,n - i - 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("通过图灵机(XN * 2) 的方式在扩展的二进位上实现 * 2操作");
        System.out.print("输入一个整数:");
        int before = input.nextInt();
        String beforeStr = Integer.toBinaryString(before);
        String beforeBinaryExtend = toBinaryExtend(beforeStr);
        String afterBinaryExtend = processXNMultiTwo(beforeBinaryExtend);
        System.out.println("最终的扩展码:" + afterBinaryExtend);
        String afterBinary = extendToBinary(afterBinaryExtend);
        System.out.println("最终的二进制码:" + afterBinary);
        int afterResult = binaryToInt(afterBinary);
        System.out.println("最终值:" + afterResult);
    }
}