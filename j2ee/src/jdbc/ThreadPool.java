/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThreadPool
 * Author:   苏晨宇
 * Date:     2020/10/21 16:51
 * Description: 数据库连接池方式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据库连接池方式〉
 *
 * @author 苏晨宇
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
        System.out.println(this.getName() + " 获得了连接，并开始工作");
        String sql = "insert into item values(null,?,?)";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "赖瓜子");
            ps.setInt(2, 5);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}
 
