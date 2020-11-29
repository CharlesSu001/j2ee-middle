/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: TestORM
 * Author:   �ճ���
 * Date:     2020/10/20 20:26
 * Description: ORM����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package jdbc;

import charactor.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��ORM���ԡ�
 *
 * @author �ճ���
 * @create 2020/10/20
 * @since 1.0.0
 */
public class TestORM {
    public static void add(Hero h){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql="insert into hero values(null,?,?,?)";
        try(Connection c= DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin"); PreparedStatement ps=c.prepareStatement(sql)){
            String name=h.name;
            float hp=h.hp;
            int damage=h.damage;
            ps.setString(1,name);
            ps.setFloat(2,hp);
            ps.setInt(3,damage);
            ps.execute();
            System.out.format("�ɹ�����Ӣ��%s,hp=%f,damage=%d%n",name,hp,damage);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void delete(Hero h){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql="delete from hero where id=?";
        try(Connection c= DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin"); PreparedStatement ps=c.prepareStatement(sql)){

            ps.setInt(1,h.id);
            ps.execute();
            System.out.format("�ɹ�ɾ��Ӣ��%s id=%d,hp=%f,damage=%d%n",h.name,h.id,h.hp,h.damage);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void update(Hero h){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql="update hero set name=?, hp=?, damage=? where id=?";
        try(Connection c= DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin"); PreparedStatement ps=c.prepareStatement(sql)){

            ps.setString(1,h.name);
            ps.setFloat(2,h.hp);
            ps.setInt(3,h.damage);
            ps.setInt(4,h.id);
            ps.execute();
            System.out.format("�ɹ�����Ӣ��%s id=%d,hp=%f,damage=%d%n",h.name,h.id,h.hp,h.damage);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static List<Hero> list(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        List<Hero> list=new ArrayList<>();

        try(Connection c= DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin"); Statement s=c.createStatement()){
            String sql="select * from hero";
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                float hp=rs.getFloat(3);
                int damage=rs.getInt(4);
                Hero h=new Hero(id,name,hp,damage);
                list.add(h);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args){
        List<Hero> hs =list();
        System.out.println("���ݿ����ܹ���" + hs.size() + " ������");
        Hero h = new Hero();
        h.name = "�µ�Ӣ��";
        System.out.println("�¼�һ������");
        add(h);
        hs =list();
        System.out.println("���ݿ����ܹ���" + hs.size() + " ������");
        System.out.println("�����ָ�Ϊ Ӣ��101�����Ҹ��µ����ݿ�");
        h.name="Ӣ��101";
        update(h);
        System.out.println(h.name);
        System.out.println("ɾ��id=101������");
        delete(h);
        hs =list();
        System.out.println("���ݿ����ܹ���" + hs.size() + " ������");

    }
}
 
