/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AutoIncrement
 * Author:   苏晨宇
 * Date:     2020/10/20 19:11
 * Description: 自增长练习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package jdbc;

import java.sql.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈自增长练习〉
 *
 * @author 苏晨宇
 * @create 2020/10/20
 * @since 1.0.0
 */
public class AutoIncrement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin"); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             Statement s = c.createStatement()) {
            ps.setString(1, "亚索");
            ps.setFloat(2, 500);
            ps.setInt(3, 100);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int id = -1;
            if (rs.next()) {
                id = rs.getInt(1);
                //System.out.println(id);

            }
            System.out.println("刚插入的数据的id是:" + id);
            for (int i = id - 1; i > 0; i--) {
                int target = i;
                ResultSet rs1 = s.executeQuery("select id from hero where id=" + target);
                if (rs1.next()) {
                    System.out.println("要删除的id存在，为：" + target);
                    String deleteSql = "delete from hero where id=" + target;
                    s.execute(deleteSql);
                    break;
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 
