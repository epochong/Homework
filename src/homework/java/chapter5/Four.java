package www.epochong.homework.java.chapter5;

import edu.princeton.cs.algs4.StdDraw;

import java.util.*;

/**
 * @author epochong
 * @date 2019/5/9 14:49
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class Four {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("输入最小值");
        int left = input.nextInt();
        System.out.println("输入最大值");
        int right = input.nextInt();
        System.out.println("输入产生几个随机数");
        int n = input.nextInt();
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            int ran = left + random.nextInt(right - left + 1);
            if (map.containsKey(ran)) {
                map.put(ran,map.get(ran) + 1);
            } else {
                map.put(ran,0);
            }

            System.out.print(ran + " ");
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        StdDraw.setXscale(0,right);
        StdDraw.setYscale(0,max);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()
             ) {
            StdDraw.filledRectangle(entry.getKey(),1,1,(double)entry.getValue());
        }

    }
}
