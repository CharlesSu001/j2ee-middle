/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TraditionThread
 * Author:   苏晨宇
 * Date:     2020/10/21 16:43
 * Description: 创建100个线程，每个线程创建新的连接
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br>
 * 〈创建100个线程，每个线程创建新的连接〉
 *
 * @author 苏晨宇
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
            System.out.println(this.getName()+" 获得了连接并开始工作");
            ps.setString(1, "土狗");
            ps.setInt(2, 3);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
 
