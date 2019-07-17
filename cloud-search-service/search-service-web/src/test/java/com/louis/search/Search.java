package com.louis.search;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * @author John·Louis
 * @date create in 2019/7/9
 * description:
 */
@Slf4j
public class Search {

    Settings settings = Settings.builder().build();

    public static final String INDEX = "create_by_ava";

    TransportClient client = null;

    @Before
    public void before() {
      /*  try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress
                            (InetAddress.getByName("129.28.189.234"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }*/
    }
    @Test
    public void searchIds() {
        QueryBuilder queryBuilder = QueryBuilders.idsQuery().addIds("1", "2");
        searchNoPage(queryBuilder);
    }
    @Test
    public void searchByTerm() {
//        name: 要搜索的字段
//        value: 要搜索的值
        QueryBuilder queryBuilder = QueryBuilders.termQuery("content", "of");
        searchNoPage(queryBuilder);

    }

    @Test
    public void searchByQueryString() {
        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery("content");
        search(queryBuilder, null, null);
    }

    @Test
    public void searchWithHighLight() {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();

    }
    private void searchNoPage(QueryBuilder queryBuilder) {
        this.search(queryBuilder, null, null);
    }

    private void searchWithPage(QueryBuilder queryBuilder, Integer fromSize, Integer pageSize) {
        search(queryBuilder, fromSize, pageSize);
    }

    private void search(QueryBuilder queryBuilder,Integer fromSize,Integer pageSize) {
        String field = queryBuilder.getName();
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field(field).preTags("<em>").postTags("<em>");


        SearchResponse response = client
                .prepareSearch(INDEX)
                .setFrom(fromSize == null ? 0 : fromSize)
                .setSize(pageSize == null ? 10 : pageSize)
                .setTypes("article").setQuery(queryBuilder)
                .highlighter(highlightBuilder)

                .get();
        SearchHits hits = response.getHits();
        log.info("查询总结果：{}", hits.getTotalHits());
       /* hits.forEach(x->{
            System.out.println(x.getSourceAsString());
            Map<String, Object> source = x.getSource();
            Map<String, HighlightField> highlightFields = x.getHighlightFields();
            if (MapUtils.isNotEmpty(highlightFields)) {
                System.out.println(highlightFields);
            }
            System.out.println(source);
        });*/
    }
}
