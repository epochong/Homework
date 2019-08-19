package www.epochong.homework.java.Chapter10;

import java.util.concurrent.Callable;

public class AddThread implements Callable<Object> {
    int begin;
    int end;
    int sum;
    public AddThread(int begin) {
        this.begin = begin;
        this.end = begin + 9;
    }



    @Override
    public Object call() throws Exception {
        while (begin++ <= end) {
            sum += begin;
        }
        return sum;
    }
}
