/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: IOExercise
 * Author:   苏晨宇
 * Date:     2020/10/13 10:52
 * Description: i/O
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package stream;

import java.io.*;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈i/o综合练习〉
 *
 * @author 苏晨宇
 * @create 2020/10/13
 * @since 1.0.0
 */
public class IOExercise {
    public static void copyFile(String srcFile, String destFile) {
        File f1 = new File(srcFile);
        File f2 = new File(destFile);
        try (FileInputStream fis = new FileInputStream(f1); FileOutputStream fos = new FileOutputStream(f2)) {
            byte[] data = new byte[1024 * 1000];
            int len = 0;
            while ((len = fis.read(data)) != -1) {
                fos.write(data, 0, len);
                //System.out.println("1");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copyFolder(String srcFolder, String destFolder) {
        File f1 = new File(srcFolder);
        File f2 = new File(destFolder);
        if (!f2.exists()) f2.mkdirs();
        for (File file : Objects.requireNonNull(f1.listFiles())) {
            if (file.isDirectory()) {
                copyFolder(file.getAbsolutePath(), f2.getAbsolutePath() + '/' + file.getName());
            } else {
                copyFile(file.getAbsolutePath(), f2.getAbsolutePath() + '/' + file.getName());
            }
        }
    }

    public static void search(File folder, String search) {
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isDirectory()) search(file, search);
            else {
                boolean flag = false;
                try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                    while (true) {
                        String line = br.readLine();
                        if(line==null)break;
                        if (line.contains(search)) {
                            flag = true;
                            break;
                        }

                    }
                    if (flag) System.out.format("找到子目标字符串%s,在文件:%s%n", search, file.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        String file1 = "E:/project/j2ee/src/stream/ClassTemplate";
        String file2 = "E:/project/j2ee/src/stream/ClassTemplateCopy";
        String folder1 = "F:/360Downloads/";
        String folder2 = "G:/360Downloads/";
        String searchfolderstr = "E:/project/j2ee";
        File searchfolder = new File(searchfolderstr);
        copyFile(file1, file2);
        copyFolder(folder1, folder2);
        search(searchfolder, "File");

    }
}
 
