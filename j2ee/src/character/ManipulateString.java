/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ManipulateString
 * Author:   苏晨宇
 * Date:     2020/10/7 20:02
 * Description: 操作字符串
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package character;

/**
 * 〈一句话功能简述〉<br>
 * 〈操作字符串〉
 *
 * @author 苏晨宇
 * @create 2020/10/7
 * @since 1.0.0
 */
public class ManipulateString {
    public void firstToUpperCase(String str) {
        System.out.println(str);
        String[] splitStr = str.split(" ");
        String result = "";
        for (int i = 0; i < splitStr.length; i++) {
            if (Character.isLowerCase(splitStr[i].charAt(0))) {
                String src = String.valueOf(splitStr[i].charAt(0));
                String des = String.valueOf(Character.toUpperCase(splitStr[i].charAt(0)));
                splitStr[i] = splitStr[i].replaceFirst(src, des);
                result += splitStr[i] + " ";
            }
        }
        result.trim();
        System.out.println(result);
    }

    private int tongueTwist(String str) {
        str.trim();
        int count = 0;
        String[] s = str.split(" ");
        for (String i : s) {
            if (i.charAt(0) == 'p') count++;
        }
        return count;
    }

    private String upperAndLower(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i % 2 == 0) {
                cs[i] = Character.toUpperCase(cs[i]);
            }
        }
        String result = new String(cs);
        return result;

    }

    private String upperCaseTwo(String str) {
        int index = str.lastIndexOf("two");
        String substr1 = str.substring(0, index);
        String substr2 = str.substring(index, str.length());
        //System.out.println(substr1);
        //System.out.println(substr2);
        char[] subarray = substr2.toCharArray();
        subarray[0] = Character.toUpperCase(subarray[0]);
        String newStr = new String(subarray);
        String result = substr1 + newStr;
        return result;
    }

    public static void main(String[] args) {
        ManipulateString m = new ManipulateString();
        m.firstToUpperCase("let there be light");
        String twistStr = "peter piper picked a peck of pickled peppers";
        System.out.format("%s中有%d个p开头的单词%n", twistStr, m.tongueTwist(twistStr));
        String str = "lengendary";
        System.out.println(m.upperAndLower(str));
        String upperTwo = "Nature has given us that two ears, two eyes, and but one tongue, " +
                "to the end that we should hear and see more than we speak";
        System.out.println(m.upperCaseTwo(upperTwo));

    }
}

 
