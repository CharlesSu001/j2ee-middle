/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Support
 * Author:   苏晨宇
 * Date:     2020/10/6 17:12
 * Description: Suooprt类 继承Hero 实现Healer接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package charactor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Suooprt类 继承Hero 实现Healer接口〉
 *
 * @author 苏晨宇
 * @create 2020/10/6
 * @since 1.0.0
 */
public class Support extends Hero implements Healer {
    @Override
    public void heal(){
        System.out.println("治疗啊 憨批");
    }
}
 
