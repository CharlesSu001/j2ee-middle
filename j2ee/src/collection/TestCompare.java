/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestCompare
 * Author:   苏晨宇
 * Date:     2020/10/14 19:59
 * Description: 测试比较累
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试比较方法〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class TestCompare {
    public static void main(String[] args) {
        List<Item> itemList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            itemList.add(new Item("item-" + i, i * 10));
        }
        System.out.println(itemList);
        Collections.sort(itemList);
        System.out.println(itemList);
        TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i=0;i<10;i++){
            ts.add(i);
        }
        for(Integer i:ts){
            System.out.println(i);
        }
    }

}
 
