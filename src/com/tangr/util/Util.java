package com.tangr.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by tangr on 2017-04-17.
 */
public class Util {

    public static String doGet(String url){
        // 定义一个字符串用来存储网页内容
        StringBuilder result = new StringBuilder();
        // 定义一个缓冲字符输入流
        BufferedReader in = null;

        try {
            // 将string转成url对象
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection urlConnection = realUrl.openConnection();
            // 设置cookie
            String cookie="_zap=8d85ceb5-1de0-46cd-84b8-b5a260f99825; q_c1=d6e19e7416f740bd8a22f9b9256951b6|1492264226000|1492264226000; r_cap_id=\"OTlmMGFmMjQ4MjE2NGVmODk4NTkyMWYyOGY5ZmEwMzA=|1492414346|4b7ae344137baef6fbd5af7b0147ea07a335a4fd\"; cap_id=\"Y2EzZTlkYjZmNGQ5NGJmZWI5YjMyMTEzMGRmYmFlZDY=|1492414346|7f4239914453c2d7e233dd1cee4a48a5bc8b7279\"; _zap=e900c60d-06bf-4bf1-90aa-fa3bda499bb9; _xsrf=39726b65ce9eeac81cb7d98a6c845c91; l_cap_id=\"NWRlMDA0MjVkNzMzNDBjMjhlZDc1MjdiMDNjMmM5ZDY=|1492434391|83f3d5c5db1c6f5d40f2902d3f88e55ed1bf5144\"; aliyungf_tc=AQAAALbQFxw9qgEAeq1DfTi3Ksf1pBZr; d_c0=\"AIBCzRosnwuPTq8-KnWNmxUBt1rJjDNNWec=|1492440432\"; __utmt=1; __utma=51854390.1578440391.1492440430.1492440430.1492440430.1; __utmb=51854390.2.10.1492440430; __utmc=51854390; __utmz=51854390.1492440430.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmv=51854390.100--|2=registration_date=20160908=1^3=entry_date=20160908=1; z_c0=Mi4wQUdBQVVuVjVnZ29BTUlKa2lzaWVDeGNBQUFCaEFsVk5sdndiV1FETGFPX1Y2WENwb284MUxmY3ZqWmJkMFFlRTJn|1492440445|6c5d5301af6f90818a21dc718aa82effe34e66d0";
            urlConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36");
            urlConnection.setRequestProperty("Cookie",cookie);
            // 开始实际的连接
            urlConnection.connect();
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            // 用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {

            try {

                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }

        return result.toString();
    }
}
