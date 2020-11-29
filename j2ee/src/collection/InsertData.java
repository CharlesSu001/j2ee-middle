/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: InsertData
 * Author:   苏晨宇
 * Date:     2020/10/14 16:34
 * Description: Arrat]yList和LinkedList插入效率对比
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈Arrat]yList和LinkedList插入效率对比〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class InsertData {
    private static void insertLast(List<Integer> list, String type) {
        int num = 100 * 1000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            list.add(i, i);
        }
        long end = System.currentTimeMillis();
        System.out.format("%s在最后插入100000条数据耗时%dms%n",type,end-start);
    }

    private static void insertMiddle(List<Integer> list, String type) {
        int num = 100 * 1000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            list.add(i/2, i);
        }
        long end = System.currentTimeMillis();
        System.out.format("%s在中间插入100000条数据耗时%dms%n",type,end-start);
    }
    public static void main(String[] args){
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new LinkedList<>();
        insertLast(list1,"ArrayList");
        insertLast(list2,"LinkedList");

        insertMiddle(list1,"ArrayList");
        insertMiddle(list2,"LinkedList");
    }
}
 
