package com.xq.es;/*
 * @Description TODO
 * @Date $ $
 * @Param $
 * @Author Savanna
 * @Return $
 * @Version 1.0
 */

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class Index_Delete {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        DeleteIndexRequest deleteIndexRequest=new DeleteIndexRequest("order");
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = acknowledgedResponse.isAcknowledged();
        System.out.println("索引删除："+acknowledged);
        restHighLevelClient.close();
    }
}
