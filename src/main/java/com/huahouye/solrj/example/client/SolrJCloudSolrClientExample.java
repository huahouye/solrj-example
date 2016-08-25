package com.huahouye.solrj.example.client;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;

/**
 * CloudSolrClient 连接 SolrCloud 的例子
 * @author xuzm
 *
 */
public class SolrJCloudSolrClientExample {

	public static void main(String[] args) throws SolrServerException, IOException {
		// 如果 zookeeper 使用了 chroot 的话，如果配置 Solr 的时候给他的值是 solr，那么这个参数后面要追加 /solr
		// 类似：String zkHostString = "192.168.191.4:2181,192.168.191.4:2182/solr";
		String zkHostString = "172.17.194.150:2181,172.17.194.151:2181/solr";
		SolrClient solr = new CloudSolrClient.Builder().withZkHost(zkHostString).build();
		
		ModifiableSolrParams params = new ModifiableSolrParams();
		params.set("qt", "/select");
		params.set("q", "id:2");
		params.set("fl", "id,responseCode");

		// SolrCloud 模式先要给定第一个参数，表示对吗一个 collection 进行操作，否者会报错。
		QueryResponse response = solr.query("weshop", params);
		System.out.println("response = " + response);
	}

}
