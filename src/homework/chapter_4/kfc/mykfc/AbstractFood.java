package www.epochong.homework.chapter_4.kfc.mykfc;

/**
 * @author epochong
 * @date 2019/4/19 17:25
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class AbstractFood {
    //类别
    protected String kind;
    //数量
    protected int num;
    //价格
    protected float price;

    //合计
    public float totalPrice(){
        return this.num * this.price;
    }
}
