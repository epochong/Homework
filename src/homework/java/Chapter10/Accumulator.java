package www.epochong.homework.java.Chapter10;


public class Accumulator extends Thread {
    public static int sum;
    private int stratNum;

    public Accumulator(int startNum) {
        this.stratNum = startNum;
    }

    public static synchronized void add(int num) {
        sum += num;
    }

    @Override
    public void run() {
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += (stratNum + i);
        }

        add(sum);
    }

    public static void main(String[] args) throws Exception {
        Thread[] threadList = new Thread[10];

        for (int i=0; i < 10; i++) {
            threadList[i] = new Accumulator((10 * i) + 1);
            threadList[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threadList[i].join();
        }

        System.out.println("Sum is : " + sum);
    }
}

