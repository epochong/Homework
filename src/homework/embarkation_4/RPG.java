package www.epochong.homework.embarkation_4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class RPG {
    /**
     * 对用户的输入做检查,确保只有输入0或1才能进行下一步
     * @return 整型0或1
     */
    private static int get01() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String re = input.nextLine();
            if (re.equals("0") || re.equals("1")) {
                return Integer.valueOf(re);
            } else {
                System.out.println("没有该选项,重新输入吧！");
            }
        }
    }

    /**
     * 对用户的输入做检查,确保只有输入0至2才能进行下一步
     * @return 整型0至2
     */
    private static int get02() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String re = input.nextLine();
            if (re.equals("0") || re.equals("1") || re.equals("2") ) {
                return Integer.valueOf(re);
            } else {
                System.out.println("没有该选项,重新输入吧！");
            }
        }
    }
    private static int get03() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String re = input.nextLine();
            if (re.equals("0") || re.equals("1") || re.equals("2") || re.equals("3") ) {
                return Integer.valueOf(re);
            } else {
                System.out.println("没有该选项,重新输入吧！");
            }
        }
    }
    private static int get04() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String re = input.nextLine();
            if (re.equals("0") || re.equals("1") || re.equals("2") || re.equals("3") || re.equals("4")) {
                return Integer.valueOf(re);
            } else {
                System.out.println("没有该选项,重新输入吧！");
            }
        }
    }
    private static int get05() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String re = input.nextLine();
            if (re.equals("0") || re.equals("1") || re.equals("2") || re.equals("3") || re.equals("4") || re.equals("5")) {
                return Integer.valueOf(re);
            } else {
                System.out.println("没有该选项,重新输入吧！");
            }
        }
    }

    /**
     * 设置种族
     * @param select 选择的选项
     * @return 对应的选项的的种族
     */
    private static String setRace(int select) {
        switch (select) {
            case 0 :
                return "人类";
            case 1:
                return "精灵";
            case 2:
                return "兽人";
            case 3:
                return "矮人";
            case 4:
                return "元素";
            default:
                return null;
        }
    }

    /**
     * 设置职业
     * @param op 种族
     * @return 对应种族的下属的选择的职业
     */
    private static String setOccupation(String op) {
        int select;
        switch (op) {
            case "人类":
                System.out.print("选择您的职业(0狂战士,1圣骑士,2刺客,3猎手,4祭司,5巫师):");
                select = get05();
                if (select == 0) {
                    return "狂战士";
                } else if (select == 1) {
                    return "圣骑士";
                } else if (select == 2) {
                    return "刺客";
                } else if (select == 3) {
                    return "猎手";
                } else if (select == 4) {
                    return "祭司";
                } else if (select == 5) {
                    return "巫师";
                }
                break;
            case "精灵":
                System.out.print("选择您的职业(0刺客,1猎手,2祭司,3巫师):");
                select = get03();
                if (select == 0) {
                    return "刺客";
                } else if (select == 1) {
                    return "猎手";
                } else if (select == 2) {
                    return "祭司";
                } else if (select == 3) {
                    return "巫师";
                }
                break;
            case "兽人":
                System.out.print("选择您的职业(0狂战士,1猎手,2祭司):");
                select = get02();
                if (select == 0) {
                    return "狂战士";
                } else if (select == 1) {
                    return "猎手";
                } else if (select == 2) {
                    return "祭司";
                }
                break;
            case "矮人":
                System.out.print("选择您的职业(0狂战士,1圣骑士,2祭司):");
                select = get02();
                if (select == 0) {
                    return "狂战士";
                } else if (select == 1) {
                    return "圣骑士";
                } else if (select == 2) {
                    return "祭司";
                }
                break;
            case "元素":
                System.out.print("选择您的职业(0祭司,1巫师):");
                select = get01();
                if (select == 0) {
                    return "祭司";
                } else if (select == 1) {
                    return "巫师";
                }
                break;
            default:
                return null;
        }
        return null;
    }

    /**
     * 设置其他的属性包括力量、敏捷、体力、智力
     * @param op 职业
     * @return 一个含有4个数的数组分别表示力量、敏捷、体力、智力
     */
    private static int[] setOther(String op) {
        int[] arr = new int[5];
        while (true) {
            switch (op) {
                case "狂战士":
                    arr[0] = (int) (Math.random() * 11) + 35;
                    arr[1] = (int) (Math.random() * 11) + 15;
                    arr[2] = (int) (Math.random() * 11) + 25;
                    arr[3] = (int) (Math.random() * 11);
                    arr[4] = 100 - arr[0] - arr[1] - arr[2] - arr[3];
                    break;
                case "圣骑士":
                    arr[0] = (int) (Math.random() * 11) + 20;
                    arr[1] = (int) (Math.random() * 11) + 10;
                    arr[2] = (int) (Math.random() * 11) + 25;
                    arr[3] = (int) (Math.random() * 11) + 15;
                    arr[4] = 100 - arr[0] - arr[1] - arr[2] - arr[3];
                    break;
                case "刺客":
                    arr[0] = (int) (Math.random() * 11) + 15;
                    arr[1] = (int) (Math.random() * 11) + 30;
                    arr[2] = (int) (Math.random() * 11) + 15;
                    arr[3] = (int) (Math.random() * 11) + 10;
                    arr[4] = 100 - arr[0] - arr[1] - arr[2] - arr[3];

                    break;
                case "猎手":
                    arr[0] = (int) (Math.random() * 11) + 10;
                    arr[1] = (int) (Math.random() * 11) + 35;
                    arr[2] = (int) (Math.random() * 11) + 5;
                    arr[3] = (int) (Math.random() * 11) + 30;
                    arr[4] = 100 - arr[0] - arr[1] - arr[2] - arr[3];
                    break;
                case "祭司":
                    arr[0] = (int) (Math.random() * 11) + 10;
                    arr[1] = (int) (Math.random() * 11) + 15;
                    arr[2] = (int) (Math.random() * 11) + 10;
                    arr[3] = (int) (Math.random() * 11) + 30;
                    arr[4] = 100 - arr[0] - arr[1] - arr[2] - arr[3];
                    break;
                case "巫师":
                    arr[0] = (int) (Math.random() * 11) + 5;
                    arr[1] = (int) (Math.random() * 11) + 15;
                    arr[2] = (int) (Math.random() * 11) + 5;
                    arr[3] = (int) (Math.random() * 11) + 15;
                    arr[4] = 100 - arr[0] - arr[1] - arr[2] - arr[3];
                    break;
                }
                if (arr[4] > 0) {
                     break;
                }
             }
                return arr;
    }

    /**
     * 显示 character各个属性信息
     * @param character character对象(RPG角色)
     */
    private static void show(Character character) {
        System.out.println("=========================");
        System.out.println("姓名" + "         " + character.getName());
        System.out.println("=========================");
        System.out.println("性别" + "         " + character.getSex());
        System.out.println("=========================");
        System.out.println("种族" + "         " + character.getRace());
        System.out.println("=========================");
        System.out.println("职业" + "         " + character.getOccupation());
        System.out.println("=========================");
        System.out.println("力量" + "         " + character.getPower());
        System.out.println("=========================");
        System.out.println("敏捷" + "         " + character.getAgility());
        System.out.println("=========================");
        System.out.println("体力" + "         " + character.getPhysical());
        System.out.println("=========================");
        System.out.println("智力" + "         " + character.getBrains());
        System.out.println("=========================");
        System.out.println("智慧" + "         " + character.getWit());
        System.out.println("=========================");
        System.out.println("生命值" + "       " + character.getLife());
        System.out.println("=========================");
        System.out.println("魔法值" + "       " + character.getMagic());
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        while (true) {
            Character character = new Character();
            while (true) {
                System.out.print("输入您游戏角色的姓名:");
                String name = input.nextLine();
                character.setName(name);
                if (name.length() >= 50) {
                    System.out.println("名字不能超过50个字符！重新输入吧！");
                } else {
                    break;
                }
            }
            System.out.print("选择您游戏角色的姓别(0男性,1女性):");
            int select = get01();
            if (select == 0) {
                character.setSex("男");
            } else {
                character.setSex("女");
            }
            System.out.print("选择您游戏角色的种族(0人类,1精灵,2兽人,3矮人,4元素):");
            select = get04();
            character.setRace(setRace(select));
            character.setOccupation(setOccupation(character.getRace()));
            int[] arr = setOther(character.getOccupation());
            character.setPower(arr[0]);
            character.setAgility(arr[1]);
            character.setPhysical(arr[2]);
            character.setBrains(arr[3]);
            character.setWit(arr[4]);
            character.setLife(arr[2] * 20);
            character.setMagic((arr[3] + arr[4]) * 10);
            show(character);
            System.out.println("你是否满意这个角色呢？你要满意我就存文件了,你要是不满意呢,那就重新创建了。");
            System.out.println("0.满意   1.也不行呀");
            select = get01();
            if (select == 0) {
                File file = new File("F:\\rpg.txt");
                Writer writer = new FileWriter(file);
                writer.write("姓名:" + character.getName() + "\r\n");
                writer.write("性别:" + character.getSex() + "\r\n");
                writer.write("种族:" + character.getRace() + "\r\n");
                writer.write("职业:" + character.getOccupation() + "\r\n");
                writer.write("力量:" + character.getPower() + "\r\n");
                writer.write("敏捷:" + character.getAgility() + "\r\n");
                writer.write("体力:" + character.getPhysical() + "\r\n");
                writer.write("智力:" + character.getBrains() + "\r\n");
                writer.write("智慧:" + character.getWit() + "\r\n");
                writer.write("生命值:" + character.getLife() + "\r\n");
                writer.write("生命值:" + character.getMagic() + "\r\n");
                writer.close();
                System.out.println("既然都满意了,那就祝您生活愉快吧!");
                System.out.println("bay:)");
                break;
            }
        }
    }
}
