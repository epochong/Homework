package www.epochong.homework.chapter_4.test;


import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/4/20 23:18
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */

interface Computer {
    void printComputer();
}

class MacBookComputer implements Computer{

    @Override
    public void printComputer() {
        System.out.println("macbook");
    }
}

class XiaoMiBookComputer implements Computer {

    @Override
    public void printComputer() {
        System.out.println("xiaomibook");
    }
}

class ComputerFactory {
    public static Computer getInstance(String computer) {
        if (computer.equals("macbook")) {
            return new MacBookComputer();
        } else if (computer.equals("xiaomibook")) {
            return new XiaoMiBookComputer();
        }
        return null;
    }
}
public class Client {
    public void buyComputer(Computer computer) {
        computer.printComputer();
    }

    public static void main(String[] args) {
        Client client = new Client();
        System.out.println("input book:");
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        Computer computer = ComputerFactory.getInstance(type);
        client.buyComputer(computer);

    }

}
