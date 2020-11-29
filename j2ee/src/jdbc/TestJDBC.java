/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: TestJDBC
 * Author:   �ճ���
 * Date:     2020/10/20 10:51
 * Description: JDBCѧϰ
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��һ�仰���ܼ�����<br>
 * ��JDBCѧϰ��
 *
 * @author �ճ���
 * @create 2020/10/20
 * @since 1.0.0
 */
public class TestJDBC {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ���������");
            // ���������ݿ��Connection����
            // ������Ҫ�ṩ��
            // ���ݿ������ڵ�ip:127.0.0.1 (����)
            // ���ݿ�Ķ˿ںţ� 3306 ��mysqlר�ö˿ںţ�
            // ���ݿ����� how2java
            // ���뷽ʽ UTF-8
            // �˺� root
            // ���� admin

            c = DriverManager
                    .getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                                    "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                            "root", "admin");

            System.out.println("���ӳɹ�����ȡ���Ӷ��� " + c);

            s=c.createStatement();

            System.out.println("��ȡStatement���� "+s);

            String sql="insert into hero values(null,"+"'��Ī'"+","+313.0f+","+50+")";
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

 
