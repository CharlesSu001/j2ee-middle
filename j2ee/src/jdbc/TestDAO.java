/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestDAO
 * Author:   苏晨宇
 * Date:     2020/10/21 10:36
 * Description: 测试DAO层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package jdbc;

import collection.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试DAO层〉
 *
 * @author 苏晨宇
 * @create 2020/10/21
 * @since 1.0.0
 */
public class TestDAO {
    public static void main(String[] args) {
        ItemDAO test = new ItemDAO();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(new Item("item-" + i, i));
        }
        System.out.println(items);
        //增加
        for (int i = 0; i < 100; i++) {
            test.add(items.get(i));
        }
        //删除
        test.delete(0);

        //获取
        Item item = test.get(7114);
        System.out.println(item);
        item.setName("无尽之剑");

        //更新
        test.update(item);

        //查询
        List<Item> query1 = test.list();
        System.out.println(query1);

        //分页查询
        List<Item> query2 = test.list(2, 10);
        System.out.println(query2);
    }
}
 
