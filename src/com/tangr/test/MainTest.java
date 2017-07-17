package com.tangr.test;

import com.tangr.util.Spider;

/**
 * Created by tangr on 2017-04-17.
 */
public class MainTest {

    public static void main(String[] args) throws Exception {

        // 定义即将访问的链接
        String url = "34787703";
        String title = "你见过的最漂亮的紧身牛仔裤大长腿是什么样的？";
        // 访问链接并获取页面内容
        Spider.downloadPic(url,title);

    }

}
