/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestConnectionPool
 * Author:   苏晨宇
 * Date:     2020/10/21 16:38
 * Description: 测试传统方式和数据库连接池的方式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
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
 * 〈一句话功能简述〉<br>
 * 〈测试传统方式和数据库连接池的方式〉
 *
 * @author 苏晨宇
 * @create 2020/10/21
 * @since 1.0.0
 */
public class TestConnectionPool {

    public static void main(String[] args) {
        List<Thread> list1 = new ArrayList<>();
        //传统方式创建100个连接
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
        System.out.println("传统方式耗时" + (t2 - t1) + "ms");

        List<Thread> list2 = new ArrayList<>();
        //线程池方式创建100个连接
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
        System.out.println("连接池方式耗时" + (t4 - t3) + "ms");

    }
}
 
