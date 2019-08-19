package www.epochong.homework.chapter_3;

import java.util.Scanner;

public class GameOf24 {
    private static final int CardsNumber = 4;
    private static final int ResultValue = 24;
    private static double number[] = new double[CardsNumber];
    private static String result[] = new String[CardsNumber];

    private static boolean PointsGame(int n) {
        if (n == 1) {
            if (Math.abs(number[0] - ResultValue) == 0) {
                System.out.println(result[0]);
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a;
                double b;
                String expa;
                String expb;
                a = number[i];
                b = number[j];
                number[j] = number[n - 1];

                expa = result[i];
                expb = result[j];
                result[j] = result[n - 1];

                result[i] = '(' + expa + '+' + expb + ')';
                number[i] = a + b;
                if (PointsGame(n - 1)) {
                    return true;
                }

                result[i] = '(' + expa + '-' + expb + ')';
                number[i] = a - b;
                if (PointsGame(n - 1)) {
                    return true;
                }

                result[i] = '(' + expb + '-' + expa + ')';
                number[i] = b - a;
                if (PointsGame(n - 1)) {
                    return true;
                }

                result[i] = '(' + expa + '*' + expb + ')';
                number[i] = a * b;
                if (PointsGame(n - 1)) {
                    return true;
                }

                if (b != 0) {
                    result[i] = '(' + expa + '/' + expb + ')';
                    number[i] = a / b;
                    if (PointsGame(n - 1)) {
                        return true;
                    }
                }

                if (a != 0) {
                    result[i] = '(' + expb+ '/' + expa + ')';
                    number[i] = b / a;
                    if (PointsGame(n - 1)) {
                        return true;
                    }
                }
                number[i] = a;
                number[j] = b;
                result[i] = expa;
                result[j] = expb;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int x;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < CardsNumber; i++) {
            System.out.println("the " + i + "th number");
            x = input.nextInt();
            number[i] = x;
            result[i] = String.valueOf(x);
        }
        if (PointsGame(CardsNumber)) {
            System.out.println("Success.");
        } else {
            System.out.println("Fail.");
        }
    }
}
