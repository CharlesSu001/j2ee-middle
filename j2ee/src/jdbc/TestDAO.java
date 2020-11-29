/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: TestDAO
 * Author:   �ճ���
 * Date:     2020/10/21 10:36
 * Description: ����DAO��
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package jdbc;

import collection.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * ��һ�仰���ܼ�����<br>
 * ������DAO�㡵
 *
 * @author �ճ���
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
        //����
        for (int i = 0; i < 100; i++) {
            test.add(items.get(i));
        }
        //ɾ��
        test.delete(0);

        //��ȡ
        Item item = test.get(7114);
        System.out.println(item);
        item.setName("�޾�֮��");

        //����
        test.update(item);

        //��ѯ
        List<Item> query1 = test.list();
        System.out.println(query1);

        //��ҳ��ѯ
        List<Item> query2 = test.list(2, 10);
        System.out.println(query2);
    }
}
 
