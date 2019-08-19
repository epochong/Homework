package www.epochong.homework.java.Chapter10;

public class IRunnable implements Runnable {
    int i = 0;
    @Override
    public void run() {
        while (i++ < 50) {
            System.out.println(i + ":new");
        }
    }
}
