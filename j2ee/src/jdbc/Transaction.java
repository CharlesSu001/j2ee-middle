/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Transaction
 * Author:   苏晨宇
 * Date:     2020/10/20 19:39
 * Description: 事务练习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈事务练习〉
 *
 * @author 苏晨宇
 * @create 2020/10/20
 * @since 1.0.0
 */
public class Transaction {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin");
             Statement st4Query = c.createStatement();
             Statement st4Delete = c.createStatement();
             Scanner sc = new Scanner(System.in)) {

            String delete = "delete from hero where id=";
            String query = "select id from hero order by id asc limit 0,10";
            c.setAutoCommit(false);
            ResultSet rs = st4Query.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                System.out.format("试图删除id=%d 的数据%n",id);
                st4Delete.execute(delete + id);
            }
            while (true) {
                System.out.println("是否要删除数据(Y/N)");
                String ins = sc.next();
                if (ins.equals("Y")) {
                    c.commit();
                    System.out.println("提交删除");
                    break;
                } else if (ins.equals("N")) {
                    System.out.println("放弃删除");
                    break;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 
