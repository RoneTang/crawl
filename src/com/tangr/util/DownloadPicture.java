package com.tangr.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class DownloadPicture implements Runnable {
    private ArrayList<String> arrayList;
    private volatile int count = 0;
    private volatile String filePath;
    private volatile String questionTiltle;

    public DownloadPicture(ArrayList<String> arrayList, String filePath, String questionTiltle) {
        this.arrayList = arrayList;
        this.filePath = filePath;
        this.questionTiltle = questionTiltle;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                String tempURL = null;
                if (count < arrayList.size())
                    tempURL = arrayList.get(count);
                else {
                    break;
                }
                if (tempURL.isEmpty()) break;
                count++;
                try {
                    savePicture(tempURL);
                    System.out.println(Thread.currentThread().getName() + "------下载当前的图片号码是" + count + "--URL是" + tempURL);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //System.out.println(Thread.currentThread().getName() + "------当前的图片号码是" + count + "--URL是" + tempURL);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void savePicture(String urlData) throws IOException {
        // 文件路径+标题
        String dir = filePath + questionTiltle;
        File fileDir = new File(dir);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        URL url = new URL(urlData);
        DataInputStream dis = new DataInputStream(url.openStream());
        String newImageName = dir + "/" + "图片" + count + ".jpg";
        // 建立一个新的文件
        FileOutputStream fos = new FileOutputStream(new File(newImageName));
        byte[] buffer = new byte[1024];
        int length;
        //System.out.println("正在下载......第 " + count + "张图片......请稍后");
        // 开始填充数据
        while ((length = dis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        dis.close();
        fos.close();

    }
}
