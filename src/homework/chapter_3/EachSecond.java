package www.epochong.homework.chapter_3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class EachSecond {
    public static void main(String[] args) {
        new Timer().schedule(new MyTimerTask1(), 2000);
        // 下面这段代码是每隔1秒,打印下当前的时间
        while (true) {
            try {
                Date date  = new Date();
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(s.format(date));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
