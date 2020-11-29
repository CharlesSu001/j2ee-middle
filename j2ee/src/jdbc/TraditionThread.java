/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: TraditionThread
 * Author:   �ճ���
 * Date:     2020/10/21 16:43
 * Description: ����100���̣߳�ÿ���̴߳����µ�����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ��һ�仰���ܼ�����<br>
 * ������100���̣߳�ÿ���̴߳����µ����ӡ�
 *
 * @author �ճ���
 * @create 2020/10/21
 * @since 1.0.0
 */
public class TraditionThread extends Thread {
    public TraditionThread(String name) {
        super(name);
    }

    public void run() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "insert into item values (null,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin"); PreparedStatement ps = c.prepareStatement(sql)) {
            System.out.println(this.getName()+" ��������Ӳ���ʼ����");
            ps.setString(1, "����");
            ps.setInt(2, 3);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
 
