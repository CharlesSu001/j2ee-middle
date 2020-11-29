/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RecursiveSearchFile
 * Author:   苏晨宇
 * Date:     2020/10/15 19:46
 * Description: 递归查找文件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package multithread;

import java.io.File;

/**
 * 〈一句话功能简述〉<br>
 * 〈递归查找文件〉
 *
 * @author 苏晨宇
 * @create 2020/10/15
 * @since 1.0.0
 */
public class RecursiveSearchFile {
    static ThreadPool pool=new ThreadPool();
    public static void recursiveSearch(File file, String search) {
        if (file.isFile()) {
            SearchThread st = new SearchThread(file, search);
            pool.add(st);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fs : files)
                recursiveSearch(fs, search);
        }
    }

    public static void main(String[] args) {
        File file = new File("E:/project/j2ee");
        recursiveSearch(file, "out");

    }
}
 
