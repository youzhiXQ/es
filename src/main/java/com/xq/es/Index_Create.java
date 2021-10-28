package com.xq.es;

/*
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
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

public class Index_Create {

    public static void main(String[] args) throws IOException {

        RestHighLevelClient client=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 创建索引
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("order");
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引创建："+acknowledged);

        client.close();


    }
}
