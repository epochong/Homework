package www.epochong.homework.chapter_3;

import java.util.Timer;

public class MyTimerTask {
    private static int count = 0;

    public void run() {
        count = count % 2;
        count++;
        System.out.println("bombing!");
        new Timer().schedule(new MyTimerTask1(), 1000 * count);
    }

}
