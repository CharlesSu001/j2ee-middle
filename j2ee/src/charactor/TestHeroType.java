package charactor; /**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestHeroType
 * Author:   苏晨宇
 * Date:     2020/10/6 16:50
 * Description: 测试枚举类型
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import charactor.HeroType;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试枚举类型〉
 *
 * @author 苏晨宇
 * @create 2020/10/6
 * @since 1.0.0
 */
public class TestHeroType {
    public static void main(String[] args) {
        for (HeroType type : HeroType.values()) {
            switch (type) {
                case TANK:
                    System.out.println("坦克");
                    break;
                case WARRIOR:
                    System.out.println("战士");
                    break;
            }
        }
    }

}
 
