/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Item
 * Author:   苏晨宇
 * Date:     2020/10/13 19:54
 * Description: Item类实现LOL接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

/**
 * 〈一句话功能简述〉<br>
 * 〈Item类实现LOL接口〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class Item implements LOL, Comparable<Item> {
    int id;
    String name;
    int price;

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public int compareTo(Item anotherItem) {
        if (this.price < anotherItem.price)
            return 1;
        else
            return -1;
    }

    public String toString() {
        return "Item=" + name + ", price=" + price + "\r\n";
    }
}
 
