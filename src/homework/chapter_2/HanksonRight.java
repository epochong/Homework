package ChapterTwo;

import java.util.Scanner;

public class HanksonRight {
    /**
     * 辗转相除法的递归调用
     * @param a 整数1
     * @param b 整数2
     * @return a,b的最大公约数
     */
    private static int gcd(int a , int  b) {
        if(a % b == 0) {
            return  b;
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
        return (a * b / gcd(a,b));
    }

    /**
     * 求x的个数
     * @param a0 a0
     * @param a1 a1
     * @param b0 b0
     * @param b1 b1
     * @param max max
     * @return 满足条件的x的个数
     */
    private static int getCount(int a0, int a1, int b0, int b1,int max) {
        int count = 0;
        for (int x = 1; x <= max; x++) {
            if(gcd(x,a0) == a1 && multiple(x,b0) == b1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 插入排序
     * @param arr 待排序数组
     */
    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr,j,j-1);
                }
            }
        }
    }

    /**
     * 交换数组中两个数的值
     * @param arr 数组
     * @param i 位置 i
     * @param j 位置 j
     */
    private static void swap(int[] arr, int i,int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 拷贝数组
     * @param arr 源数组
     * @return arr的数组拷贝
     */
    private static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);
        return res;
    }
    /**
     * 获取正确的输入数据
     * @return 一个数组，包含n个数，这两个数输入正确的输入格式，可以用来求最大公约数，和最小公倍数
     */
        private static int[] getLegalFormat() {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[4];
        boolean judge = true;
        String str[] = new String[4];
        for (int i = 0; i < 4; i++) {
            str[i] = null;
        }
        int[] numStr = new int[4];
        for (int i = 0; i < 4; i++) {
            numStr[i] = 0;
        }
        //对输入异常的处理
        while (judge) {
            for (int i = 0; i < 4; i++) {
                str[i] = input.next();
            }
            try {
                for (int i = 0; i < 4; i++) {
                    Integer.parseInt(str[i]);
                }
            } catch (NumberFormatException e) {
                System.out.println("The input format is wrong, please input again!");
                e.printStackTrace();
                continue;
            }
            for (int i = 0; i < 4; i++) {
                numStr[i] = Integer.parseInt(str[i]);
            }
            for (int i = 0; i < 4; i++) {
                if (numStr[i] < 1) {
                    System.out.println("You must input two positive integers!Input again!");
                    judge = true;
                    continue;
                }
            }
            if (numStr[0] % numStr[1] != 0 && numStr[3] % numStr[2] != 0) {
                System.out.println("You must ensure a0 % a1 == 0 and b1 % b0 == 0.");
                continue;
            } else {
                judge = false;
            }

        }
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input n:");
        int n = input.nextInt();
        int[] result = new int[n];
        System.out.println("Input " + n + " row numbers(row by 4 cols,ensure a0 % a1 == 0 and b1 % b0 == 0):" );
        for (int i = 0; i < result.length; i++) {
            int[] data = getLegalFormat();
            int[] arr = copyArray(data);
            insertionSort(data);
            result[i] = getCount(arr[0],arr[1],arr[2],arr[3],data[data.length - 1]);
        }
        for (int aResult : result) {
            System.out.println(aResult);
        }
    }
}