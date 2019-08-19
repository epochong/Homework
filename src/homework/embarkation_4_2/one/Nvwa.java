package www.epochong.homework.embarkation_4_2.one;

/**
 * @author epochong
 * @date 2019/4/29 9:15
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class Nvwa {
    public static Person getInstance(String person) {
        if (person.equals("M")) {
            return new Man();
        } else if (person.equals("W")) {
            return new Woman();
        } else if (person.equals("R")) {
            return new Robot();
        }

        return null;
    }
}
