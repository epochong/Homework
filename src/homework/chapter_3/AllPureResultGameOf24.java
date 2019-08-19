package www.epochong.homework.chapter_3;

import java.util.HashMap;
import java.util.Scanner;

public class AllPureResultGameOf24 {
    private static final int CardsNumber = 4;
    private static final int ResultValue = 24;
    private static double number[] = new double[CardsNumber];
    private static String result[] = new String[CardsNumber];
    private static HashMap<Integer,String> map = new HashMap<>();
    private static int hashSize = 0;
    private static int addSize = 0;
    private static int multiSize = 0;

    private static void PointsGame(int n) {
        if (n == 1) {
            if (Math.abs(number[0] - ResultValue) == 0) {
                String[] addSplit = result[0].split("\\+");
                String[] multiSplit = result[0].split("\\*");
                if (addSplit.length == 4 && addSize == 0 && !map.containsValue(result[0])) {
                    map.put(hashSize++,result[0]);
                    addSize++;
                    return;
                } else if(addSplit.length == 4 && addSize > 0){
                    return;
                }
                if (multiSplit.length == 4 && multiSize == 0 && !map.containsValue(result[0])) {
                    map.put(hashSize++,result[0]);
                    multiSize++;
                    return;
                } else if (multiSplit.length == 4 && multiSize > 0) {
                    return;
                }
                if (!map.containsValue(result[0])) {
                    map.put(hashSize++,result[0]);
                }
                return ;
            } else {
                return ;
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
                //避免了因交换律产生的多个重复的解
                if (a <= b) {
                    result[i] = '(' + expa + '+' + expb + ')';
                    number[i] = a + b;
                    PointsGame(n - 1);
                }
                result[i] = '(' + expa + '-' + expb + ')';
                number[i] = a - b;
                PointsGame(n - 1);


                result[i] = '(' + expb + '-' + expa + ')';
                number[i] = b - a;
                PointsGame(n - 1);

                if (a <= b) {
                    result[i] = '(' + expa + '*' + expb + ')';
                    number[i] = a * b;
                    PointsGame(n - 1);
                }
                if (b != 0) {
                    result[i] = '(' + expa + '/' + expb + ')';
                    number[i] = a / b;
                    PointsGame(n - 1);
                }

                if (a != 0) {
                    result[i] = '(' + expb+ '/' + expa + ')';
                    number[i] = b / a;
                    PointsGame(n - 1);
                }
                number[i] = a;
                number[j] = b;
                result[i] = expa;
                result[j] = expb;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < CardsNumber; i++) {
            System.out.println("the " + (i + 1) + "th number");
            int x = input.nextInt();
            number[i] = x;
            result[i] = String.valueOf(x);
        }
        PointsGame(CardsNumber);
        for (int mapKey : map.keySet()
                ) {
            System.out.println(map.get(mapKey));
        }
    }
}
