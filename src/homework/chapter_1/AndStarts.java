/**
* @file AndStarts
* @author epochong
* @date 2019/2/27 
* @params Initial trial time and termination time
* @return Is the man fishing or drying his net
* @email 876459397@qq.com
* @CSDN https://blog.csdn.net/wfcn_zyq
*/
package www.epochong.homework.chapter_1;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class AndStarts {
    private static class date{
        int year;
        int month;
        int day;
    }

    public static void main(String[] args) throws IOException {
    boolean judge = false;
    String[] s = new String[2];//定义数组用来保存需要的数据
    int inBeginDate,inEndDate;
    String strInBeginDate,strInEndDate;
    /*对下面的数据进行筛选*/

        while (!judge) {
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
        strInBeginDate = in.readLine();
        inBeginDate = Integer.parseInt(strInBeginDate);
        if (strInBeginDate.length() != 8) {
            System.out.println("Date must be 8 digits!");
            judge = false;
            continue;
        }
        s = Arrays.copyOf(s,s.length+1);  //扩容  如果对内存没有要求可以直接声明一个大容量的数组
        s[0] = strInBeginDate.substring(0,8);
        strInEndDate = in.readLine();
        if (strInEndDate.length() != 8) {
            System.out.println("Date must be 8 digits!");
            judge = false;
            continue;
        }
        in.close();
        inEndDate = Integer.parseInt(strInEndDate);
        s = Arrays.copyOf(s,s.length+1);  //扩容  如果对内存没有要求可以直接声明一个大容量的数组
        s[1] = strInEndDate.substring(0,8);
        if (inBeginDate > inEndDate) {
            System.out.println("Begin date must big than end date");
            judge = false;
            continue;
        }
        if(!(isRightDate(inBeginDate / 10000,inBeginDate / 100 % 100, inBeginDate % 100) &&
                isRightDate(inEndDate / 10000,inEndDate / 100 % 100,inEndDate % 100))) {
            System.out.println("The date is wrong");
            judge = false;
            continue;
        }

        judge = true;

    }
    date today = new date();
    date term = new date();
    int sumDays,year,day;
    today.year = Integer.parseInt(s[1].substring(0,4));
    today.month = Integer.parseInt(s[1].substring(4,6));
    today.day = Integer.parseInt(s[1].substring(6,8));
    term.month = 12;               /*设置变量的初始值：月*/
    term.day = 31;                 /*设置变量的初始值：日*/
        for(sumDays = 0, year = 2010; year < today.year; year++) {
        term.year = year;
        sumDays += days(term);     /*计算从2010年至指定年的前一年共有多少天*/
    }
    sumDays += days(today);       /*加上指定年中到指定日期的天数*/
    day = sumDays % 5;               /*求余数*/

    File outFile = new File("F:\\out.txt");
    Writer out = new FileWriter(outFile);
        if(day >= 0 && day < 3) {
        System.out.println("he was fishing at that day.\n");
        out.write("he was fishing at that day.\n");   /*打印结果*/
    }
        else {
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

    private static boolean isRightDate(int year, int month, int day) {
        int day_tab[][] =
                {{0,31,28,31,30,31,30,31,31,30,31,30,31},      /*平均每月的天数*/
                        {0,31,29,31,30,31,30,31,31,30,31,30,31}
                };
        if (year > 2019 || (year == 2019 && month > 3) || (year == 2019 && month == 3 && day > 2) || (month > 12)) {
            return false;
        }
        int lp = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0;
        return day_tab[lp][month] >= day;
    }
}

