/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Entry
 * Author:   苏晨宇
 * Date:     2020/10/14 18:53
 * Description: 键值对
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

/**
 * 〈一句话功能简述〉<br> 
 * 〈键值对〉
 *
 * @author 苏晨宇
 * @create 2020/10/14
 * @since 1.0.0
 */
public class Entry {
    public Entry(Object key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }
    public Object key;
    public Object value;
    @Override
    public String toString() {
        return "[key=" + key + ", value=" + value + "]";
    }

}
 
