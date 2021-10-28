package com.xq.es;/*
 * @Description TODO
 * @Date $ $
 * @Param $
 * @Author Savanna
 * @Return $
 * @Version 1.0
 */

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

public class Index_Search {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        GetIndexRequest getIndexResponse=new GetIndexRequest("order");
        GetIndexResponse indexResponse = restHighLevelClient.indices().get(getIndexResponse, RequestOptions.DEFAULT);
        System.out.println(indexResponse.getAliases());
        System.out.println(indexResponse.getMappings());
        System.out.println(indexResponse.getSettings());

        restHighLevelClient.close();
    }
}
