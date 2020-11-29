/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: InsertHundred
 * Author:   苏晨宇
 * Date:     2020/10/20 16:16
 * Description: 插入100条数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package jdbc;


import com.mysql.cj.protocol.Resultset;

import java.sql.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈插入100条数据〉
 *
 * @author 苏晨宇
 * @create 2020/10/20
 * @since 1.0.0
 */
public class InsertHundred {
    public static void execute(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin"); Statement s = c.createStatement()) {
            boolean isQuery = s.execute(sql);
            if(isQuery) {
                ResultSet rs=s.getResultSet();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString(2);
                    float hp = rs.getFloat("hp");
                    int damage = rs.getInt(4);
                    System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
                }
            }

            DatabaseMetaData dbmd = c.getMetaData();

            // 获取数据库服务器产品名称
            System.out.println("数据库产品名称:\t"+dbmd.getDatabaseProductName());
            // 获取数据库服务器产品版本号
            System.out.println("数据库产品版本:\t"+dbmd.getDatabaseProductVersion());
            // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
            System.out.println("数据库和表分隔符:\t"+dbmd.getCatalogSeparator());
            // 获取驱动版本
            System.out.println("驱动版本:\t"+dbmd.getDriverVersion());

            System.out.println("可用的数据库列表：");
            // 获取数据库名称
            ResultSet rs = dbmd.getCatalogs();

            while (rs.next()) {
                System.out.println("数据库名称:\t"+rs.getString(1));
            }

            // s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void list(int start, int count){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection c=DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin");Statement s=c.createStatement()){
            String sql="select *from hero limit "+start*count+","+count;
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        execute("select * from hero");
        list(2,5);
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
//                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
//                "root", "admin");
//             Statement s = c.createStatement();
//
//        ) {
//            String name = "dashen";
//            //正确的密码是：thisispassword
//            String password = "thisispassword1";
//
//            String sql = "select * from user where name = '" + name + "' and password = '" + password + "'";
//
//            // 执行查询语句，并把结果集返回给ResultSet
//            ResultSet rs = s.executeQuery(sql);
//
//            if (rs.next())
//                System.out.println("账号密码正确");
//            else
//                System.out.println("账号密码错误");
//
//            String sql2="select count(*) from hero";
//            ResultSet rs1=s.executeQuery(sql2);
//            int total=0;
//            while(rs1.next()){
//                total=rs1.getInt(1);
//                System.out.println(total);
//            }
//
//            System.out.println("一共有"+total+"条数据");
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }
}
 
