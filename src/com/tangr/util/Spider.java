package com.tangr.util;

import com.tangr.bean.ZhiHuPicBean;

/**
 * Created by tangr on 2017-04-17.
 */
public class Spider {

    public static void downloadPic(String url, String name) throws Exception {
        // 构造方法传url，获取ZhiHuPicBean
        ZhiHuPicBean zhiHuPicBean = new ZhiHuPicBean(url);
        // 获取ZhiHuPicBean中的图片列表
        //ArrayList<String> picList = zhiHuPicBean.getPicUrl();
        zhiHuPicBean.setQuestion(name);
        // 打印结果
        System.out.println("");
        System.out.println("标题：" + zhiHuPicBean.getQuestion());
        System.out.println("");
        System.out.println(zhiHuPicBean.picUrlSet.size());
        /*for (String pic : picList) {
            if (pic.length() < 100)
                System.out.println(pic);
        }*/
        for (String set : zhiHuPicBean.picUrlSet) {

            System.out.println(set);
        }
        System.out.println("");

        String addr = "E:/知乎爬虫/";
        System.out.println("即将开始下载图片到"+addr+zhiHuPicBean.getQuestion());
        System.out.println("");
        System.out.println("开始下载................");
        System.out.println("");
        // 把图片下载到本地文件夹
        FileReaderWriter.downLoadPics(zhiHuPicBean, addr);
        System.out.println("");
        System.out.println("图片下载完毕，请到"+addr+zhiHuPicBean.getQuestion()+"里去看看吧！！！");
    }

}
