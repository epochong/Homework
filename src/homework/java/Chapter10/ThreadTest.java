package www.epochong.homework.java.Chapter10;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("Thread1");
        myThread1.start();
        MyThread myThread2 = new MyThread("Thread2");
        myThread2.start();
    }
}
