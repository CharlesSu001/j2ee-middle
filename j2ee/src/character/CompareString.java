/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CompareString
 * Author:   苏晨宇
 * Date:     2020/10/8 8:58
 * Description: 比较字符串
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package character;

import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈比较字符串〉
 *
 * @author 苏晨宇
 * @create 2020/10/8
 * @since 1.0.0
 */
public class CompareString {
    private static int count = 0;
    private static String[] putInto = new String[100];

    private static String createString(int len) {
        char[] cs = new char[len];
        for (int i = 0; i < len; i++) {
            Random r = new Random();
            int type = r.nextInt(3);
            switch (type) {
                case 0:
                    cs[i] = (char) (r.nextInt(26) + 97);
                    break;
                case 1:
                    cs[i] = (char) (r.nextInt(26) + 65);
                    break;
                case 2:
                    cs[i] = (char) (r.nextInt(10) + 48);
                    break;


            }


        }
        String str = new String(cs);
        return str;
    }

    private void countDuplicate() {
        String[] str = new String[100];
        for (int i = 0; i < 100; i++) {
            str[i] = createString(2);
            System.out.print(str[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println("");
        }
        for(String s1:str){
            int repeat=0;
            for(String s2:str){
                if(s1.equalsIgnoreCase(s2)){
                    repeat++;
                    if(repeat==2){
                        putIntoArray(s1);
                        break;
                    }
                }
            }
        }

    }

    private static void putIntoArray(String s) {
        for (int i = 0; i < count; i++) {
            if (putInto[i].equalsIgnoreCase(s)) return;
        }//已有重复元素不再添加
        putInto[count++] = s;//没有重复元素，添加
    }
    private void printDuplicate(){
        System.out.format("总共有%d种重复的字符串%n分别是:%n",count);
        for(int i=0;i<count;i++){
            System.out.print(putInto[i]+" ");
        }
        //System.out.println("");

    }

    public static void main(String[] args) {
        CompareString test = new CompareString();
        test.countDuplicate();
        test.countDuplicate();
        test.printDuplicate();
    }
}
 
