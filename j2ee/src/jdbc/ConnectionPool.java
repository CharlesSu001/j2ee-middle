/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: ConnectionPool
 * Author:   �ճ���
 * Date:     2020/10/21 11:15
 * Description: ���ݿ����ӳ�
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ��һ�仰���ܼ�����<br>
 * �����ݿ����ӳء�
 *
 * @author �ճ���
 * @create 2020/10/21
 * @since 1.0.0
 */
public class ConnectionPool {
    List<Connection> cs = new ArrayList<Connection>();
    int size;

    public ConnectionPool(int size) {
        this.size = size;
        init();
    }

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection c = DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                                "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                        "root", "admin");
                cs.add(c);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        while (cs.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection c = cs.remove(0);
        return c;
    }

    public synchronized void returnConnection(Connection c) {
        cs.add(c);
        this.notifyAll();
    }

}
 
