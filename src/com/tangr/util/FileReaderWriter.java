package com.tangr.util;

import com.tangr.bean.ZhiHuPicBean;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.HashSet;

/**
 * Created by tangr on 2017-04-17.
 */
public class FileReaderWriter {
    public static void downLoadPics(ZhiHuPicBean zhiHuPicBean, String filePath) throws Exception {
        // 文件路径+标题
        String dir = filePath + zhiHuPicBean.getQuestion();
        File fileDir = new File(dir);
        fileDir.mkdirs();

        HashSet<String> set = zhiHuPicBean.picUrlSet;
        int count = 1;
        for (String urlSet : set) {

            URL url = new URL(urlSet);
            DataInputStream dis = new DataInputStream(url.openStream());
            String newImageName = dir + "/" + "图片" + count + ".jpg";
            // 建立一个新的文件
            FileOutputStream fos = new FileOutputStream(new File(newImageName));
            byte[] buffer = new byte[1024];
            int length;
            System.out.println("正在下载......第 " + count + "张图片......请稍后");
            // 开始填充数据
            while ((length = dis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            dis.close();
            fos.close();
            System.out.println("第 " + count + "张图片下载完毕......");
            count++;

        }

    }
}
