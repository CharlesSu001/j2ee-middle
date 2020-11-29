/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestGeneric
 * Author:   苏晨宇
 * Date:     2020/10/14 20:25
 * Description: 泛型类测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package generic;

import charactor.Hero;
import charactor.ADHero;
import charactor.APHero;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 〈一句话功能简述〉<br> 
 * 〈泛型类测试〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class TestGeneric {
    public static void iterate(ArrayList<? extends Hero> list){
        for(Hero hero:list){
            System.out.println(hero.name);
        }
    }
    public static void main(String[] args){
        HashSet<Number> numberHashSet=new HashSet<Number>();
        numberHashSet.add(1);
        numberHashSet.add(12.3);
        //numberHashSet.add("sfdf");
        ArrayList<Hero> list=new ArrayList<>();
        ArrayList<ADHero> list1=new ArrayList<>();
        ArrayList<APHero> list2=new ArrayList<>();
        iterate(list);
        iterate(list1);
        iterate(list2);
    }
}
 
