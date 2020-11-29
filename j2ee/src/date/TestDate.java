/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestDate
 * Author:   苏晨宇
 * Date:     2020/10/7 10:37
 * Description: 测试时间类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试时间类〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public class TestDate {
    private void RandomDate() {
        Date startDate = new Date(1995 - 1900, 1 - 1, 1, 0, 0, 0);
        Date endDate = new Date(1995 - 1900, 12 - 1, 31, 23, 59, 59);
        System.out.println("1995年第一天:" + startDate);
        System.out.println("1995年最后一天:" + endDate);
        long random = (long) (Math.random() * (startDate.getTime() - endDate.getTime() + 1) + endDate.getTime());
        Date ranDate = new Date(random);
        System.out.println("1995年随机时间:" + ranDate);

    }
//        Date d1 = new Date();
//        System.out.println(d1.toString());
//        System.out.println(d1.getTime());
//        System.out.println(System.currentTimeMillis());
//        TestDate test = new TestDate();
//        test.RandomDate();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//        Date d = new Date();
//        String str = sdf.format(d);
//        System.out.println(str);
//
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
//        Date d1 = new Date();
//        String str2 = sdf1.format(d1);
//        System.out.println(str2);

    //        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:dd");
//        String str="2020/1/9 11:21:32";
//        try{
//            Date d=sdf.parse(str);
//            System.out.println(d.toString());
//        }
//        catch (ParseException e){
//            e.printStackTrace();
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date startDate = new Date(1970 - 1900, 1 - 1, 1, 1, 1, 1);
//        Date endDate = new Date(2000 - 1900, 12 - 1, 31, 23, 59, 59);
//        Date[] randomDate = new Date[9];
//        long[] date = new long[9];
//        for (int i = 0; i < 9; i++) {
//            long random = (long) (Math.random() * (startDate.getTime() - endDate.getTime() + 1) + endDate.getTime());
//            randomDate[i] = new Date(random);
//            String str = sdf.format(randomDate[i]);
//            date[i] = randomDate[i].getTime();
//            System.out.print(str + " ");
//            if ((i + 1) % 3 == 0) System.out.println("");
//        }
//        //对日期进行排序
//        Arrays.sort(date);
//        for(int i=0;i<9;i++){
//            Date d=new Date(date[i]);
//            String str = sdf.format(d);
//            System.out.print(str + " ");
//            if ((i + 1) % 3 == 0) System.out.println("");
//        }
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private static String format(Date time) {
        return sdf.format(time);
    }

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();
        System.out.println("今天是:\t" + format(now));
        c.setTime(now);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DATE, -3);
        System.out.println("下个月倒数第三天是:\t" + format(c.getTime()));
    }
}

 
