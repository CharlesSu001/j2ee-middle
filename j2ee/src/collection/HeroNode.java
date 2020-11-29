/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: HeroNode
 * Author:   苏晨宇
 * Date:     2020/10/13 20:49
 * Description: 英雄节点 按照血量倒排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import charactor.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈英雄节点 按照血量倒排序〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class HeroNode<T extends Comparable<T>> {
    //左子节点
    public HeroNode<T> leftNode;
    //右子节点
    public HeroNode<T> rightNode;

    public T heroes;

    public void add(T h) {
        //如果当前节点没有值 则赋值
        if (heroes == null) {
            heroes=h;
        }
        //如果当前节点有值则添加值
        else {
            if (h.compareTo(heroes) < 0) {
                if(leftNode==null)
                leftNode = new HeroNode<>();
                leftNode.add(h);
            } else {
                if(rightNode==null)
                rightNode = new HeroNode<>();
                rightNode.add(h);
            }

        }
    }

    public List<T> values() {
        List<T> list = new ArrayList<>();
        if (leftNode != null) list.addAll(leftNode.values());
        list.add(heroes);
        if (rightNode != null) list.addAll(rightNode.values());
        return list;
    }
    public static void main(String[] args){
        ArrayList<Hero> heroList=new ArrayList<>();
        Random r=new Random();
        for(int i=0;i<10;i++){
            float x=r.nextInt(500)+500;
            heroList.add(new Hero("hero"+i,x));
        }
        HeroNode roots=new HeroNode();
        for(Hero h:heroList){
            roots.add(h);
        }
        System.out.println(roots.values());
    }
}
 
