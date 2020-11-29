/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: TestConnectionPool
 * Author:   �ճ���
 * Date:     2020/10/21 16:38
 * Description: ���Դ�ͳ��ʽ�����ݿ����ӳصķ�ʽ
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ��һ�仰���ܼ�����<br>
 * �����Դ�ͳ��ʽ�����ݿ����ӳصķ�ʽ��
 *
 * @author �ճ���
 * @create 2020/10/21
 * @since 1.0.0
 */
public class TestConnectionPool {

    public static void main(String[] args) {
        List<Thread> list1 = new ArrayList<>();
        //��ͳ��ʽ����100������
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t = new TraditionThread("traditional working thread");
            t.start();
            list1.add(t);
        }
        for (Thread t : list1) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("��ͳ��ʽ��ʱ" + (t2 - t1) + "ms");

        List<Thread> list2 = new ArrayList<>();
        //�̳߳ط�ʽ����100������
        long t3 = System.currentTimeMillis();
        ConnectionPool cp = new ConnectionPool(10);
        for (int i = 0; i < 100; i++) {
            Thread t = new ThreadPool("connectionpool working thread", cp);
            t.start();
            list2.add(t);
        }
        for (Thread t : list2) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long t4 = System.currentTimeMillis();
        System.out.println("���ӳط�ʽ��ʱ" + (t4 - t3) + "ms");

    }
}
 
