package www.epochong.homework.java.Chapter3;

import java.util.Scanner;

public class ChapterTwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int guess = (int) (Math.random() * 100);
        System.out.println("Guess [0,100)");
        while (true) {
            int guessInt = input.nextInt();
            if (guess == guessInt) {
                System.out.println("Your are right!");
                break;
            } else if (guessInt > guess){
                System.out.println("Too big! Continue.");
            } else {
                System.out.println("Too small! Continue.");
            }
        }
    }
}

