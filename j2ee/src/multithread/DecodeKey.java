/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DecodeKey
 * Author:   苏晨宇
 * Date:     2020/10/19 9:19
 * Description: 破译密码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈破译密码〉
 *
 * @author 苏晨宇
 * @create 2020/10/19
 * @since 1.0.0
 */
public class DecodeKey {
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

    public static void main(String[] args) throws InterruptedException {
        String password = createString(3);
        System.out.println("password:" + password);
        LinkedList<String> psdList = new LinkedList<>();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    psdList.addLast(createString(3));
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (psdList.isEmpty()) Thread.sleep(1000);
                        else {
                            String enumPsw = psdList.poll();
                            System.out.println(enumPsw);
                            if (enumPsw.equals(password)) {
                                System.out.println("密码已破译为:" + enumPsw);
                                break;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        t1.start();
        t2.setDaemon(true);
        t2.start();
        if(t2.isInterrupted())t1.interrupt();
    }
}
 
