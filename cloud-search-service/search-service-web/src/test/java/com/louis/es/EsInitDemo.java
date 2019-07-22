package com.louis.es;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author John·Louis
 * @date create in 2019/7/9
 * description:
 *
 *  1.创建一个Settings 对象 相当于一个配置信息，主要配置集群信息
 *  2. 创建一个客户端client
 *  3.shiyong client 对象创建一个索引库
 *  4，关闭client 对象
 *
 */
public class EsInitDemo {


    Settings settings = Settings.builder().build();

    public static final String INDEX = "create_by_ava";

    TransportClient client = null;

    @Before
    public void before() {
        /*try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress
                            (InetAddress.getByName("129.28.189.234"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 创建索引
     */
    @Test
    public void createIndex() {
        client.admin()
                .indices()
                .prepareCreate(INDEX)
                //执行操作
                .get();
    }

    /**
     * 创建mapping
     */
    @Test
    public void createMapping() {
        try {
            XContentBuilder contentBuilder = XContentFactory.jsonBuilder()
                    .startObject()
                        .startObject("article")
                            .startObject("properties")
                                .startObject("id")
                                    .field("type", "long")
                                     .field("store", true)
                                .endObject()
                                .startObject("title")
                                    .field("type","text")
                                    .field("store",true)
//                                    .field("analyzer","ik_smart")
                                .endObject()
                                .startObject("content")
                                    .field("type","text")
                                    .field("store",true)
//                                    .field("analyzer","ik_smart")
                                .endObject()
                            .endObject()
                        .endObject()
                    .endObject();

            client.admin().indices()
//                    设置要做映射的索引
                    .preparePutMapping(INDEX)
//                    设置type
                    .setType("article")
                    .setSource(contentBuilder)

                    .get();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    @Test
    public void createDocument() {
        try {
            XContentBuilder builder = XContentFactory
                    .jsonBuilder()
                    .startObject()
                    .field("id", 1)
                    .field("title", "this is titile")
                    .field("content", "this is content")
                    .endObject();

            client.prepareIndex()
                    .setIndex(INDEX)
                    .setType("article")
                    .setId("1")
//                    设置文档信息
                    .setSource(builder)
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void creteDocumentByDomain() {
        ObjectMapper objectMapper = new ObjectMapper();
        LicenseWord licenseWord = new LicenseWord();
        licenseWord.initList(null);

        for (int i = 3; i <100 ; i++) {
            Article article = Article
                    .builder()
                    .id(i)
                    .content(licenseWord.getContentWord(i))
                    .title(licenseWord.getContentWord(i))
                    .build();

            try {
                String string = objectMapper.writeValueAsString(article);
                System.out.println(string);
                client.prepareIndex().setIndex(INDEX)
                        .setType("article")
                        .setId(String.valueOf(i))
                        .setSource(string, XContentType.JSON).get();
                Thread.sleep(100);

                System.out.println(i);
            } catch (JsonProcessingException | InterruptedException e) {
                e.printStackTrace();
            }

        }


    }


    @After
    public void after() {
        client.close();

    }

}
