/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: GiantDragon
 * Author:   苏晨宇
 * Date:     2020/10/6 16:22
 * Description: 饿汉式单例模式 只创建一个实例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package charactor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈饿汉式单例模式 只创建一个实例〉
 *
 * @author 苏晨宇
 * @create 2020/10/6
 * @since 1.0.0
 */
public class GiantDragon {
    //私有化构造方法，外部无法通过new进行实例化
    private GiantDragon(){

    }
    //准备一个类属性，指向一个实例化对象 类属性 只有一个
    private static GiantDragon instance=new GiantDragon();
    //public static方法，提供给调用者获取13行定义的对象
    public static GiantDragon getInstance(){
        return instance;
    }
}
 
