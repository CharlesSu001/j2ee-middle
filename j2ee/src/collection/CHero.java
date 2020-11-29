/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Hero
 * Author:   苏晨宇
 * Date:     2020/10/13 19:45
 * Description: 英雄类实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

/**
 * 〈一句话功能简述〉<br> 
 * 〈英雄类实现〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class CHero implements LOL{
    String name;
    public CHero(String name){
        this.name=name;
    }
    @Override
    public String getName(){
        return this.name;
    }
}
 
