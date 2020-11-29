/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SerializableHero
 * Author:   苏晨宇
 * Date:     2020/10/13 9:14
 * Description: 序列化对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package charactor;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈序列化对象〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class SerializableHero implements Serializable {
    private static final long serialVersionUID=1L;
    public int num;
    public String name;
    public float hp;
    public SerializableHero(int i){
        this.num=i;
    }
}
 
