package com.huahouye.solrj.example.client;

import java.io.IOException;
import java.util.Arrays;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.huahouye.solrj.example.app.config.AppConfig;

/**
 * HttpSolrClient 的例子
 * 
 * @author xuzm
 *
 */
public class SolrJHttpSolrClientExampleImpl {
	@Autowired
	Environment env;

	@Value("${solr.host}")
	private String urlString;

	public void execute() throws SolrServerException, IOException {
		SolrClient solr = new HttpSolrClient.Builder(urlString).build();

		// http://localhost:8983/solr/spellCheckCompRH?q=epod&spellcheck=on&spellcheck.build=true
		ModifiableSolrParams params = new ModifiableSolrParams();
		params.set("qt", "/select");
		params.set("q", "id:2");

		QueryResponse response = solr.query(params);
		System.out.println("response = " + response);
	}

	public static void main(String[] args) throws SolrServerException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		SolrJHttpSolrClientExampleImpl service = (SolrJHttpSolrClientExampleImpl) ctx
				.getBean("solrJHttpSolrClientExampleImpl");
		service.execute();
		ctx.close();
	}
}