package www.epochong.homework.embarkation_4_2;

/**
 * @author epochong
 * @date 2019/4/28 17:48
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
interface CPU {
    void printCpu();
}
class MacCpu implements CPU {

    @Override
    public void printCpu() {
        System.out.println("use Mac CPU");
    }
}
class PcCpu implements CPU {

    @Override
    public void printCpu() {
        System.out.println("use Pc CPU");
    }
}
interface RAM {
    void printRam();
}
class MacRam implements RAM {
    @Override
    public void printRam() {
        System.out.println("use Mac RAM");
    }
}

class PcRam implements RAM {
    @Override
    public void printRam() {
        System.out.println("use PC RAM");
    }
}

interface IFactory {
    CPU createCpu();
    RAM createRam();
}

class MacFactory implements IFactory {

    @Override
    public CPU createCpu() {
        return new MacCpu();
    }

    @Override
    public RAM createRam() {
        return new MacRam();
    }
}

class PcFactory implements IFactory {

    @Override
    public CPU createCpu() {
        return new PcCpu();
    }

    @Override
    public RAM createRam() {
        return new PcRam();
    }
}

/**
 * 工厂类,通过参数传递类名,通过类名
 */
class Factory {
    public static IFactory getInstance(String classname) {
        IFactory iFactory = null;
        try {
            iFactory = (IFactory) Class.forName(classname).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return iFactory;
    }
}


public class ComputerProduct {
    public void buyCpu(CPU cpu) {
        cpu.printCpu();
    }
    public void buyRam(RAM ram) {
        ram.printRam();
    }

    public static void main(String[] args) {
        ComputerProduct computerProduct = new ComputerProduct();
        System.out.println(">Create by simple abstract factory");
        IFactory iFactory = new MacFactory();
        IFactory iFactory1 = new PcFactory();
        computerProduct.buyCpu(iFactory.createCpu());
        computerProduct.buyCpu(iFactory1.createCpu());
        computerProduct.buyRam(iFactory.createRam());
        computerProduct.buyRam(iFactory1.createRam());
        System.out.println("-----------------------------");
        System.out.println(">Create by reflect");
        IFactory MacFactory = Factory.getInstance("www.homework.embarkation_4_2.MacFactory");
        computerProduct.buyCpu(MacFactory.createCpu());
        computerProduct.buyRam(MacFactory.createRam());
        IFactory PcFactory = Factory.getInstance("www.homework.embarkation_4_2.PcFactory");
        computerProduct.buyCpu(PcFactory.createCpu());
        computerProduct.buyRam(PcFactory.createRam());

    }
}
