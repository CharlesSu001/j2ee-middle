package property; /**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Item
 * Author:   苏晨宇
 * Date:     2020/10/4 10:26
 * Description: 物品类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

/**
 * 〈一句话功能简述〉<br>
 * 〈物品类〉
 *
 * @author 苏晨宇
 * @create 2020/10/4
 * @since 1.0.0
 */
public abstract class Item {
    //    String name;//物品名
//    int price;//价格
//
//    public static void main(String[] args){
//        Item bloodVial=new Item();
//        bloodVial.name="bloodVial";
//        bloodVial.price=50;
//
//        Item strawSandals=new Item();
//        strawSandals.name="strawSandals";
//        strawSandals.price=300;
//
//        Item sword=new Item();
//        sword.name="sword";
//        sword.price=350;
//    }
    //1.私有化构造方法
//    private Item() {
//
//    }
//
//    //2.静态属性 指向一个实例 但不创建对象
//    private static Item instance;
//
//    //3.getInstance方法，返回静态属性
//    public static Item getInstance() {
//        if (instance == null) {
//            instance = new Item();//如果为空，则指向一个对象
//        }
//        return instance;
//    }
    String name;
    int price;

    //    public void buy() {
//        System.out.println("购买");
//    }
//
//    public void effect() {
//        System.out.println("物品使用后，可以有效果");
//    }
//
//    public String toString() {
//        return name + ":" + price;
//    }
//
//    public void finalize() {
//        System.out.println("回收乡下人");
//    }
//
//    public boolean equals(Object o) {
//        if (o instanceof Item) {
//            Item i = (Item) o;
//            return i.price == this.price;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Item i = new Item();
//        i.name="hp";
//        i.price=50;
//        Item i2=new Item();
//        i2.name="mp";
//        i2.price=100;
//        i.effect();
//        MagicPotion mp = new MagicPotion();
//        mp.effect();
//        System.out.println(i);
//        System.out.println(i.equals(i2));
//    }
    public abstract boolean disposable();

    public static void main(String[] args) {

        Item i = new Item() {
            public boolean disposable() {
                return true;
            }

        };
        System.out.println(i.disposable());
    }
}
 
