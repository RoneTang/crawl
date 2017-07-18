package com.tangr.bean;

import com.tangr.util.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tangr on 2017-04-17.
 */
public class ZhiHuPicBean {

    private String question; // 问题
    private ArrayList<String> picUrl; // 图片链接
    public HashSet<String> picUrlSet = new HashSet<>();

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setPicUrl(ArrayList<String> picUrl) {
        this.picUrl = picUrl;
    }


    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getPicUrl() {
        return picUrl;
    }


    public ZhiHuPicBean(String url) {

        //picUrl = new ArrayList<String>();
        int count = 0;
        int offset = 0;
        String tempUrl;
        while (true) {
            tempUrl = getRealUrl(url, offset);
            offset += 20;
            System.out.println("-----------------------------------");
            // 判断url是否合法
            if (url != "") {
                System.out.println("正在抓取知乎链接：" + tempUrl);

                // 根据url获取该问答的细节
                String content = Util.doGet(tempUrl);
                System.out.println(content);
                Pattern pattern;
                Matcher matcher;
                // 匹配标题
           /* pattern = Pattern.compile("<h1.+?>(.+?)</h1>");
            matcher = pattern.matcher(content);
            if (matcher.find()) {
                question = matcher.group(1);
            }*/
                // 匹配答案
                pattern = Pattern.compile("(https://pic.+?b.(jpg|png|jpeg))");
                matcher = pattern.matcher(content);
                boolean isFind = matcher.find();
                while (isFind) {
                    // picUrl.add(matcher.group(1));
                    if (matcher.group(1).length() < 100)
                        picUrlSet.add(matcher.group(1));
                    isFind = matcher.find();
                }

                pattern = Pattern.compile("src=.\"(https.+?.(jpeg|png|jpg))\\\\");
                matcher = pattern.matcher(content);
                isFind = matcher.find();
                while (isFind) {
                    // picUrl.add(matcher.group(1));
                    if (matcher.group(1).length() < 100)
                        picUrlSet.add(matcher.group(1));
                    isFind = matcher.find();
                }
            }

            if (count != picUrlSet.size())
                count = picUrlSet.size();
            else
                break;
        }
    }

    private String getRealUrl(String url, int offset) {
        /*Pattern pattern = Pattern.compile("question/(.*?)");
        Matcher matcher = pattern.matcher(url);*
        if (matcher.find()) {
             System.out.println(url);
        } else {
            return "";
        }*/

        url = "https://www.zhihu.com/api/v4/questions/" + url + "/answers?include=data%5B*%5D.is_normal%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Cmark_infos%2Ccreated_time%2Cupdated_time%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cupvoted_followees%3Bdata%5B*%5D.author.badge%5B%3F(type%3Dbest_answerer)%5D.topics&offset=" + offset + "&limit=20&sort_by=default";
        return url;
    }
}
