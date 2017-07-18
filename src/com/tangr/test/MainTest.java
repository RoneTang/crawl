package com.tangr.test;

import com.tangr.util.Spider;
import com.tangr.util.Util;

import java.util.HashMap;

/**
 * Created by tangr on 2017-04-17.
 */
public class MainTest {

    public static void main(String[] args) throws Exception {

        // 定义即将访问的链接
        //String url = "39717954";
        //String title = "大家有没有不经意间看见的被美哭了的风景照片呢？";
        // 访问链接并获取页面内容
        //Spider.downloadPic(url,title);

        String url = "https://www.zhihu.com/question/62560062/answer/199857170";
        HashMap<String, String> mapInfo = (HashMap) Util.getInfo(url);
        //System.out.println(mapInfo.get("title"));
        //System.out.println(mapInfo.get("question"));
        Spider.downloadPic(mapInfo.get("question"), mapInfo.get("title"));
    }

}
