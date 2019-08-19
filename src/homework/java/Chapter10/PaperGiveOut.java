package www.epochong.homework.java.Chapter10;

public class PaperGiveOut implements  Runnable {
    private int paper = 1;
    @Override
    public void run() {
        while (true) {
            if (paper <= 80) {
                System.out.println(Thread.currentThread().getName() + "正在发放第" + paper++ + "份试卷。");
            }
        }

    }
}
