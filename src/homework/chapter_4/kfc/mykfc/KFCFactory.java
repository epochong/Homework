package www.epochong.homework.chapter_4.kfc.mykfc;

/**
 * @author epochong
 * @date 2019/4/19 21:22
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class KFCFactory implements Factory{
    //鸡腿堡
    @Override
    public ZingerBurger createZingerBurger(int num) {
        return new ZingerBurger(num);
    }
    //牛肉堡
    @Override
    public BeefBurger createBeefBurger(int num) {
        return new BeefBurger(num);
    }
    //烤鸡腿堡
    @Override
    public OrleansBurger createOrleansBurger(int num) {
        return new OrleansBurger(num);
    }
    //全虾堡
    @Override
    public ShrimpBurger createShrimpBurger(int num) {
        return new ShrimpBurger(num);
    }
    //烤翅
    @Override
    public ChickenWings createChickenWings(int num) {
        return new ChickenWings(num);
    }
    //烤鸡腿
    @Override
    public DrumStick createDrumStick(int num) {
        return new DrumStick(num);
    }
    //鸡米花
    @Override
    public PopcornChicken createPopcornChicken(int num) {
        return new PopcornChicken(num);
    }
    //生产薯条
    @Override
    public Chips createChips(int num){
        return new Chips(num);
    }
    //生产蛋挞
    @Override
    public EggTart createEggTart(int num){
        return new EggTart(num);
    }
    //生产圣代
    @Override
    public Sundae createSundae(int num){
        return new Sundae(num);
    }
    //生产奶茶
    @Override
    public Milky createMilky(int num){
        return new Milky(num);
    }
    //生产可乐
    @Override
    public Kola createKola(int num){
        return new Kola(num);
    }
    //生产咖啡
    @Override
    public Coffee createCoffee(int num){
        return new Coffee(num);
    }
    //生产单人套餐
    @Override
    public OneCombo createOneCombo(int num){
        return new OneCombo(num);
    }
    //生产双人套餐
    @Override
    public TwoCombo createTwoCombo(int num){
        return new TwoCombo(num);
    }
    //生产三人套餐
    @Override
    public ThreeCombo createThreeCombo(int num){
        return new ThreeCombo(num);
    }
}
