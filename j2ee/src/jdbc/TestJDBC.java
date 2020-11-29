/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestJDBC
 * Author:   苏晨宇
 * Date:     2020/10/20 10:51
 * Description: JDBC学习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 〈一句话功能简述〉<br>
 * 〈JDBC学习〉
 *
 * @author 苏晨宇
 * @create 2020/10/20
 * @since 1.0.0
 */
public class TestJDBC {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载驱动");
            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 how2java
            // 编码方式 UTF-8
            // 账号 root
            // 密码 admin

            c = DriverManager
                    .getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                                    "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                            "root", "admin");

            System.out.println("连接成功，获取连接对象： " + c);

            s=c.createStatement();

            System.out.println("获取Statement对象： "+s);

            String sql="insert into hero values(null,"+"'提莫'"+","+313.0f+","+50+")";
            s.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(s!=null)
                try{
                    s.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            if(c!=null)
                try{
                    c.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
        }

    }
}

 
