package www.epochong.homework.java.Chapter10;

public class TeacherTest {
    public static void main(String[] args) {
        PaperGiveOut paperGiveOut = new PaperGiveOut();
        new Thread(paperGiveOut,"teacher1").start();
        new Thread(paperGiveOut,"teacher2").start();
        new Thread(paperGiveOut,"teacher3").start();
    }
}
