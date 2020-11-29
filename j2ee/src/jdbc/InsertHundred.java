/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: InsertHundred
 * Author:   �ճ���
 * Date:     2020/10/20 16:16
 * Description: ����100������
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package jdbc;


import com.mysql.cj.protocol.Resultset;

import java.sql.*;

/**
 * ��һ�仰���ܼ�����<br>
 * ������100�����ݡ�
 *
 * @author �ճ���
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

            // ��ȡ���ݿ��������Ʒ����
            System.out.println("���ݿ��Ʒ����:\t"+dbmd.getDatabaseProductName());
            // ��ȡ���ݿ��������Ʒ�汾��
            System.out.println("���ݿ��Ʒ�汾:\t"+dbmd.getDatabaseProductVersion());
            // ��ȡ���ݿ�������������ͱ���֮��ķָ��� ��test.user
            System.out.println("���ݿ�ͱ�ָ���:\t"+dbmd.getCatalogSeparator());
            // ��ȡ�����汾
            System.out.println("�����汾:\t"+dbmd.getDriverVersion());

            System.out.println("���õ����ݿ��б�");
            // ��ȡ���ݿ�����
            ResultSet rs = dbmd.getCatalogs();

            while (rs.next()) {
                System.out.println("���ݿ�����:\t"+rs.getString(1));
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
//            //��ȷ�������ǣ�thisispassword
//            String password = "thisispassword1";
//
//            String sql = "select * from user where name = '" + name + "' and password = '" + password + "'";
//
//            // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
//            ResultSet rs = s.executeQuery(sql);
//
//            if (rs.next())
//                System.out.println("�˺�������ȷ");
//            else
//                System.out.println("�˺��������");
//
//            String sql2="select count(*) from hero";
//            ResultSet rs1=s.executeQuery(sql2);
//            int total=0;
//            while(rs1.next()){
//                total=rs1.getInt(1);
//                System.out.println(total);
//            }
//
//            System.out.println("һ����"+total+"������");
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }
}
 
