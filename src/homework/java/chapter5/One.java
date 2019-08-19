package www.epochong.homework.java.chapter5;

/**
 * @author epochong
 * @date 2019/5/9 14:22
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class One {
    public static void main(String[] args) {
        String helloWorld = "Hello World";
        for (int i = helloWorld.length() - 1; i >= 0; i --) {
            System.out.print(helloWorld.charAt(i));
        }
    }
}
