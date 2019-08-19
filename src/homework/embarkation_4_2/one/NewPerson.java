package www.epochong.homework.embarkation_4_2.one;

import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/5/4 13:13
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public  class NewPerson {
    public  void newPerson(Person person) {
        person.printPerson();
    }

    public static void main(String[] args) {
        NewPerson newPerson = new NewPerson();
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        Person person = Nvwa.getInstance(type);
        newPerson.newPerson(person);
    }
}