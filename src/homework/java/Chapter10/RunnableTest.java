package www.epochong.homework.java.Chapter10;

public class RunnableTest {
    public static void main(String[] args) {
        IRunnable iRunnable = new IRunnable();
        Thread thread = new Thread(iRunnable);
        thread.start();
        int n = 0;
        while (n++ < 100) {
            System.out.println(n + ":Main");
        }
    }
}
