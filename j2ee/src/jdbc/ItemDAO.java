/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ItemDAO
 * Author:   苏晨宇
 * Date:     2020/10/21 10:00
 * Description: 类ItemDAO，实现接口DAO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package jdbc;

import collection.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈类ItemDAO，实现接口DAO〉
 *
 * @author 苏晨宇
 * @create 2020/10/21
 * @since 1.0.0
 */
public class ItemDAO implements DAO {
    public ItemDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载驱动");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载驱动失败");
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.1.0.1:3306/how2java?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "admin");
    }

    @Override
    public void add(Item item) {
        String sql = "insert into item values(null,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setInt(2, item.getPrice());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                item.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Item item) {
        String sql = "update item set name=? ,price=? where id=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setInt(2, item.getPrice());
            ps.setInt(3, item.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        String sql = "delete from item where id=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Item get(int id) {
        Item item = null;
        String sql = "select * from item where id=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                item = new Item();
                String name = rs.getString(2);
                int price = rs.getInt(3);
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<Item> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Item> list(int start, int count) {
        List<Item> list = new ArrayList<>();
        String sql = "select * from item order by id desc limit ?,?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                Item item = new Item();
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
 
