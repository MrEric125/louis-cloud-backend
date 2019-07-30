package com.louis.httpClient;

import com.google.common.collect.Lists;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/7/23
 * Description:
 *  http Client 基本用法，官方示例为：
 *  http://hc.apache.org/httpcomponents-client-4.5.x/
 *
 */
public class HttpClientTest {

    String baseUrl = "http://localhost:7888/";

    /**
     * post test
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test0() throws UnsupportedEncodingException {
        List<NameValuePair> formParams = Lists.newArrayList();
        formParams.add(new BasicNameValuePair("userName", "zhangsan"));
        formParams.add(new BasicNameValuePair("password", "123456"));
        HttpEntity httpEntity = new UrlEncodedFormEntity(formParams, "UTF-8");

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://localhost:7888/doPost");
        httpPost.setEntity(httpEntity);

        CloseableHttpResponse response = null;
        try {

            response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            System.out.println("响应状态为：" + response.getStatusLine());
            if (entity != null) {
                System.out.println("响应长度为" + entity.getContentLength());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (client != null)
                    client.close();
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(baseUrl + "send/httpclienttest");
            System.out.println("executing request :" + httpGet.getRequestLine());
            ResponseHandler<String> responseHandler = response -> {
                int code = response.getStatusLine().getStatusCode();
                if (code >= 200 && code < 300) {
                    HttpEntity entity = response.getEntity();

                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + code);
                }
            };
            String responseBody = null;
            try {
                responseBody = client.execute(httpGet, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(baseUrl + "send/conectionRelease");
            System.out.println("execution request" + httpGet.getRequestLine());
            CloseableHttpResponse response = client.execute(httpGet);
            System.out.println("--------------------------");
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
                try (InputStream content = entity.getContent()) {
                    int n;
                    while ((n = content.read()) != -1) {
                        System.out.println(n);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
