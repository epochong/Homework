package www.epochong.homework.java.chapter5;

import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/5/9 14:25
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class Two {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] strings = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strings[i] = str.substring(i,i+1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 97) {
                strings[i] = strings[i].toLowerCase();
            } else {
                strings[i] = strings[i].toUpperCase();
            }
        }
        for (String i : strings
             ) {
            System.out.print(i);
        }
    }
}
