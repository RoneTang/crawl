package com.tangr.util;

import com.tangr.bean.ZhiHuPicBean;

import java.util.ArrayList;

/**
 * Created by tangr on 2017-04-17.
 */
public class Spider {

    public static void downloadPic(String url, String title) throws Exception {
        // 构造方法传url，获取ZhiHuPicBean
        ZhiHuPicBean zhiHuPicBean = new ZhiHuPicBean(url);
        // 获取ZhiHuPicBean中的图片列表
        //ArrayList<String> picList = zhiHuPicBean.getPicUrl();
        zhiHuPicBean.setQuestion(title);
        // 打印结果
        System.out.println("");
        System.out.println("标题：" + zhiHuPicBean.getQuestion());
        System.out.println("");
        System.out.println(zhiHuPicBean.picUrlSet.size());
        /*for (String pic : picList) {
            if (pic.length() < 100)
                System.out.println(pic);
        }*/
        /*for (String set : zhiHuPicBean.picUrlSet) {

            System.out.println(set);
        }*/
        System.out.println("");

        String address = "E:/知乎爬虫/";
        System.out.println("即将开始下载图片到" + address + zhiHuPicBean.getQuestion());
        System.out.println("");
        System.out.println("开始下载................");
        System.out.println("");
        // 把图片下载到本地文件夹
        //FileReaderWriter.downLoadPics(zhiHuPicBean, address);

        ArrayList<String> test = new ArrayList<>();
        test.addAll(zhiHuPicBean.picUrlSet);
        DownloadPicture downloadPicture = new DownloadPicture(test, address, zhiHuPicBean.getQuestion());
        Thread thread_1 = new Thread(downloadPicture, "线程一");
        Thread thread_2 = new Thread(downloadPicture, "线程二");
        Thread thread_3 = new Thread(downloadPicture, "线程三");
        Thread thread_4 = new Thread(downloadPicture, "线程四");

        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();

        //System.out.println("");
        //System.out.println("图片下载完毕，请到" + address + zhiHuPicBean.getQuestion() + "里去看看吧！！！");
    }

}
