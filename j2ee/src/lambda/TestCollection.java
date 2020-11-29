/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestCollection
 * Author:   苏晨宇
 * Date:     2020/10/15 16:50
 * Description: 改造成引用构造器方式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 〈一句话功能简述〉<br> 
 * 〈改造成引用构造器方式〉
 *
 * @author 苏晨宇
 * @create 2020/10/15
 * @since 1.0.0
 */
public class TestCollection {
    public static void main(String[] args) {

        insertFirst(ArrayList<Integer>::new, "ArrayList");

        insertFirst(LinkedList<Integer>::new, "LinkedList");

    }

    private static void insertFirst(Supplier<List> s, String type) {
        List l=s.get();
        int total = 1000 * 100;
        final int number = 5;
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            l.add(0, number);
        }
        long end = System.currentTimeMillis();
        System.out.printf("在%s 最前面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
    }
}
 
