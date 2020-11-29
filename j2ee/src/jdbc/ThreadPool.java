/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: ThreadPool
 * Author:   �ճ���
 * Date:     2020/10/21 16:51
 * Description: ���ݿ����ӳط�ʽ
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ��һ�仰���ܼ�����<br>
 * �����ݿ����ӳط�ʽ��
 *
 * @author �ճ���
 * @create 2020/10/21
 * @since 1.0.0
 */
public class ThreadPool extends Thread {
    private ConnectionPool cp;

    public ThreadPool(String name, ConnectionPool cp) {
        super(name);
        this.cp = cp;
    }

    public void run() {
        Connection c = cp.getConnection();
        System.out.println(this.getName() + " ��������ӣ�����ʼ����");
        String sql = "insert into item values(null,?,?)";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "������");
            ps.setInt(2, 5);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}
 
