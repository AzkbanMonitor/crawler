package com.hjx.crawler;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Slf4j
public class CrawlerFirst {
    public static void main(String[] args) throws IOException {
        //1、打开浏览器，创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2、输入网址，创建get请求
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");

        //3、按回车，发起请求，返回响应
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        //4、解析响应，获取数据
        //判断状态码是否为200
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpResponseEntity = httpResponse.getEntity();
            String content = EntityUtils.toString(httpResponseEntity, "utf-8");
            System.out.println(content);

        }


    }
}
