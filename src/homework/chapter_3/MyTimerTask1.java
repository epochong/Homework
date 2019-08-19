package www.epochong.homework.chapter_3;

import java.util.Timer;
import java.util.TimerTask;

// 自定义一个类继承于TimerTask并重写run方法
class MyTimerTask1 extends TimerTask {
    @Override
    public void run() {
        new Timer().schedule(new MyTimerTask2(), 1000 );
    }
}