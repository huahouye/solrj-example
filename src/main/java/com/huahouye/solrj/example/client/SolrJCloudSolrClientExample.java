package com.huahouye.solrj.example.client;

import java.io.IOException;
import java.util.Arrays;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.huahouye.solrj.example.app.config.AppConfig;

/**
 * CloudSolrClient 连接 SolrCloud 的例子
 * 
 * @author xuzm
 *
 */
public class SolrJCloudSolrClientExample {
	@Autowired
	Environment env;

	@Value("${solrcloud.zk.host}")
	private String zkHostString;

	public void execute() throws SolrServerException, IOException {
		// 如果 zookeeper 使用了 chroot 的话，如果配置 Solr 的时候给他的值是 solr，那么这个参数后面要追加 /solr
		// 类似：String zkHostString =
		// "192.168.191.4:2181,192.168.191.4:2182/solr";
		SolrClient solr = new CloudSolrClient.Builder().withZkHost(zkHostString).build();

		ModifiableSolrParams params = new ModifiableSolrParams();
		params.set("qt", "/select");
		params.set("q", "id:ff808081545aa1ba01545aa1c8150256");
		params.set("fl", "id,keyWords");

		// SolrCloud 模式先要给定第一个参数，表示对吗一个 collection 进行操作，否者会报错。
		QueryResponse response = solr.query(env.getProperty("solr.default.collection"), params);
		System.out.println("response = " + response);
	}

	public static void main(String[] args) throws SolrServerException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		SolrJCloudSolrClientExample service = (SolrJCloudSolrClientExample) ctx
				.getBean("solrJCloudSolrClientExample");
		service.execute();
		ctx.close();
	}

}
