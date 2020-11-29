/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestPreparedStatement
 * Author:   苏晨宇
 * Date:     2020/10/20 18:46
 * Description: 预编译测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package jdbc;

import java.sql.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈预编译测试〉
 *
 * @author 苏晨宇
 * @create 2020/10/20
 * @since 1.0.0
 */
public class TestPreparedStatement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "insert into hero values(null,?,?,?)";
        int count=10000000;

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin");
             Statement s = c.createStatement();
             PreparedStatement ps = c.prepareStatement(sql)) {
            long t1=System.currentTimeMillis();
            for(int i=0;i<count;i++){
                String sql10="insert into hero values(null,"+"'提莫'"+","+313.0f+","+50+")";
                s.execute(sql10);
            }
            s.close();
            long t2=System.currentTimeMillis();
            System.out.println("statement耗时"+(t2-t1)+"ms");


            long t3=System.currentTimeMillis();
            for(int i=0;i<count;i++){
                ps.setString(1,"提莫");
                ps.setFloat(2,313.0f);
                ps.setInt(3,50);
                ps.execute();
            }

            long t4=System.currentTimeMillis();
            System.out.println("statement耗时"+(t4-t3)+"ms");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
 
