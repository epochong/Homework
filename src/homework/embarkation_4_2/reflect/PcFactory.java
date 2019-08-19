package www.epochong.homework.embarkation_4_2.reflect;

/**
 * @author epochong
 * @date 2019/4/29 8:53
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class PcFactory implements IFactory {

    @Override
    public CPU createCpu() {
        return new PcCpu();
    }

    @Override
    public RAM createRam() {
        return new PcRam();
    }
}
