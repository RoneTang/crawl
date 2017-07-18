package com.tangr.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tangr on 2017-04-17.
 */
public class Util {

    public static Map<String, String> getInfo(String url) {
        /*// 定义一个字符串用来存储网页内容
        StringBuilder result = new StringBuilder();
        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        try {
            // 将string转成url对象
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection urlConnection = realUrl.openConnection();
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

        }*/

        String result = doGet(url);

        System.out.println(result);

        String regexTitle = "<title .+?>(.+?)\\? - 知乎</title>";
        String regexQuestion = "question/(\\d+)";
        Pattern pattern = Pattern.compile(regexTitle);
        Matcher matcher = pattern.matcher(result);
        String Title = null;
        String Question = null;
        if (matcher.find()) {
            //System.out.println(matcher.group(1));
            Title = matcher.group(1);
        }

        pattern = Pattern.compile(regexQuestion);
        matcher = pattern.matcher(url);
        if (matcher.find()) {
            //System.out.println(matcher.group(1));
            Question = matcher.group(1);
        }

        Map<String, String> mapInfo = new HashMap<String, String>();
        mapInfo.put("title", Title);
        mapInfo.put("question", Question);
        return mapInfo;
    }

    public static String doGet(String url) {
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
            String cookie = "_zap=e900c60d-06bf-4bf1-90aa-fa3bda499bb9; d_c0=\"AIBCzRosnwuPTq8-KnWNmxUBt1rJjDNNWec=|1492440432\"; q_c1=d6e19e7416f740bd8a22f9b9256951b6|1497754546000|1492264226000; r_cap_id=\"NTNlZTIzY2U3N2E3NDE0MGI1NGJlYmI1ODEwYWMyNjY=|1497867081|a0b32c5633117cdc70e0b817b585b9d2a3580cfa\"; cap_id=\"MTg0MjU0ODM2MWFhNGNhOTk3MWE1NTI2ZGZlMGU4NzY=|1497867081|582e2e65f071ddf2bb52793cc0441f94352ea1d5\"; z_c0=Mi4wQUdBQVVuVjVnZ29BZ0VMTkdpeWZDeGNBQUFCaEFsVk5UakJ2V1FBUWpzWl9ua0VmbzczdlktT05qYWVVZmM0WXdn|1497867086|6e39d6b07785ca8b66ec0c05d55a2743335208b8; __utma=51854390.1817676522.1500285077.1500285294.1500302796.3; __utmb=51854390.0.10.1500302796; __utmc=51854390; __utmz=51854390.1500302796.3.3.utmcsr=zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/; __utmv=51854390.100--|2=registration_date=20160908=1^3=entry_date=20160908=1; _xsrf=04b8ad836fde0b0ddce1161ebef79dca";
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36");
            urlConnection.setRequestProperty("Cookie", cookie);
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
