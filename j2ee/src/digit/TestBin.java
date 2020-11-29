/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestBin
 * Author:   苏晨宇
 * Date:     2020/10/7 9:59
 * Description: 装箱拆箱练习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package digit;

/**
 * 〈一句话功能简述〉<br>
 * 〈装箱拆箱练习〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public class TestBin {
    public static void main(String[] args) {
//        byte b = 1;
//        short s = 2;
//        float f = 3f;
//        double d = 4;
//        //自动装箱
//        Byte b1 = b;
//        Short s1 = s;
//        Float f1 = f;
//        Double d1 = d;
//        //自动拆箱
//        byte b2 = b1;
//        short s2 = s1;
//        float f2 = f1;
//        double d2 = d1;
//        System.out.println(Byte.MAX_VALUE);

//        float f=3.14f;
//        Float f1=f;
//        System.out.println(String.valueOf(f));
//        System.out.println(f1.toString());
//        String str="3.1a4";
//        float f2=Float.parseFloat(str);
        Integer n = Integer.MAX_VALUE;
        double e = Math.pow(1 + 1d / n, n);
        System.out.println(e);
        System.out.println(Math.E);

    }
}
 
