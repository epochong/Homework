package ChapterOne;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class VersionOne {
    private static class date{
        int year;
        int month;
        int day;
    }

    public static void main(String[] args) throws IOException {
/*        String str; //定义String变量用来保存每一次读到的每一行的数据
        String[] s = new String[2];//定义数组用来保存需要的数据*/
        int inBeginDate,inEndDate;
        String strBeginDate,strEndDate;
        /*对下面的数据进行筛选*/
        Scanner input = new Scanner(System.in);
        File inDatFile = new File("F:\\Program\\sort\\IDEA\\HomeWork\\in.dat");
        File inTxtFile = new File("F:\\Program\\sort\\IDEA\\HomeWork\\in.txt");
        Writer inDat = new FileWriter(inDatFile);
        Writer inTxt = new FileWriter(inTxtFile);
        System.out.println("Please enter eight digits year, month and day.");
        System.out.println("Please input the date begin:");
        String beginDate = input.nextLine();
        inDat.write(beginDate + "\r\n");
        inTxt.write(beginDate + "\r\n");
        System.out.println("Please enter eight digits year, month and day.");
        System.out.println("Please input the date end:");
        String endDate = input.nextLine();
        inDat.write(endDate + "\r\n");
        inTxt.write(endDate + "\r\n");
        inTxt.close();
        inDat.close();
        BufferedReader in = new BufferedReader(new FileReader("F:\\Program\\sort\\IDEA\\HomeWork\\in.dat"));//打开文件创建数据流
        strBeginDate = in.readLine();
        inBeginDate = Integer.parseInt(strBeginDate);
        strEndDate = in.readLine();
        inEndDate = Integer.parseInt(strEndDate);

//
//            for(int i = 0;(str = in.readLine()) != null && i < s.length; i++){
//                if(str.length() == 8){
//                    try {
//                        Integer.parseInt(str);
//                    } catch (NumberFormatException e){
//                        System.out.println("Input error!Date is not all digits!");
//                        e.printStackTrace();
//                    }
//                    s = Arrays.copyOf(s,s.length+1);  //扩容  如果对内存没有要求可以直接声明一个大容量的数组
//                    s[i] = str.substring(0,8);//获取子串保存到数组中
//                } else {
//                    System.out.println("Input error!Length is wrong!");
//                }
//            }
        if (inBeginDate > inEndDate) {
            System.out.println("Begin date must big than end date");
        }
        if (inBeginDate / 10000 % 100 > 12) {
            in.close();
        }
        date today = new date();
        date term = new date();
        int sumDays,year,day;
        today.year = Integer.parseInt(strEndDate.substring(0,4));
        today.month = Integer.parseInt(strEndDate.substring(4,6));
        today.day = Integer.parseInt(strEndDate.substring(6,8));
        term.month = 12;               /*设置变量的初始值：月*/
        term.day = 31;                 /*设置变量的初始值：日*/
        for(sumDays = 0, year = inBeginDate; year < today.year; year++)
        {
            term.year = year;
            sumDays += days(term);     /*计算从2010年至指定年的前一年共有多少天*/
        }
        sumDays += days(today);       /*加上指定年中到指定日期的天数*/
        day = sumDays % 5;               /*求余数*/

        File outFile = new File("F:\\Program\\sort\\IDEA\\HomeWork\\out.txt");
        Writer out = new FileWriter(outFile);
        if(day >= 0 && day < 3) {
            System.out.println(day);
            System.out.println("he was fishing at that day.\n");
            out.write("he was fishing at that day.\n");   /*打印结果*/
        }
        else {
            System.out.println(day);
            System.out.println("He was sleeping at that day.");
            out.write("He was sleeping at that day.\n");
        }
        out.close();
    }

    private static int days(date day) {
        int day_tab[][] =
                {{0,31,28,31,30,31,30,31,31,30,31,30,31},      /*平均每月的天数*/
                        {0,31,29,31,30,31,30,31,31,30,31,30,31}
                };
        int lp = day.year % 4 == 0 && day.year % 100 != 0 || day.year % 400 == 0 ? 1 : 0;
        /*判定year为闰年还是平年，lp=0为平年，非0为闰年*/
        for(int i = 1; i < day.month; i++)            /*计算本年中自1月1日起的天数*/ {
            day.day += day_tab[lp][i];
        }
        return day.day;
    }
}

