/**
 * Copyright (C), 2015-2020, XXX���޹�˾
 * FileName: TestReflection
 * Author:   �ճ���
 * Date:     2020/10/21 17:17
 * Description: ���Է������
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package refection;

import charactor.Hero;

import java.lang.reflect.Constructor;

/**
 * ��һ�仰���ܼ�����<br>
 * �����Է�����ơ�
 *
 * @author �ճ���
 * @create 2020/10/21
 * @since 1.0.0
 */
public class TestReflection {
    public static void main(String[] args) {
//        String className = "charactor.Hero";
//        try {
//            Class pClass1 = Class.forName(className);
//            Class pClass2 = Hero.class;
//            Class pClass3 = new Hero().getClass();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        try {
            //ʹ�÷���ķ�ʽ��������
            String className = "charactor.Hero";
            //�����
            Class pClass=Class.forName(className);
            //������
            Constructor c= pClass.getConstructor();
            //ͨ��������ʵ����
            Hero h2= (Hero) c.newInstance();
            h2.name="gareen";
            System.out.println(h2);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
 
