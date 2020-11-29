/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: Transaction
 * Author:   �ճ���
 * Date:     2020/10/20 19:39
 * Description: ������ϰ
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * ��һ�仰���ܼ�����<br>
 * ��������ϰ��
 *
 * @author �ճ���
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
                System.out.format("��ͼɾ��id=%d ������%n",id);
                st4Delete.execute(delete + id);
            }
            while (true) {
                System.out.println("�Ƿ�Ҫɾ������(Y/N)");
                String ins = sc.next();
                if (ins.equals("Y")) {
                    c.commit();
                    System.out.println("�ύɾ��");
                    break;
                } else if (ins.equals("N")) {
                    System.out.println("����ɾ��");
                    break;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 
