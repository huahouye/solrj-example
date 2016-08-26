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

/**
 * HttpSolrClient 的例子
 * 
 * @author xuzm
 *
 */
public class SolrJHttpSolrClientExample {
	@Autowired
	Environment env;

	@Value("${solr.host}")
	private String urlString;

	public void execute() throws SolrServerException, IOException {
		SolrClient solr = new HttpSolrClient.Builder(urlString).build();

		// http://localhost:8983/solr/spellCheckCompRH?q=epod&spellcheck=on&spellcheck.build=true
		ModifiableSolrParams params = new ModifiableSolrParams();
		params.set("qt", "/select");
		params.set("q", "id:ff808081545aa1ba01545aa1c8150256");
		params.set("fl", "id,keyWords");

		QueryResponse response = solr.query(params);
		System.out.println("response = " + response);
	}
}