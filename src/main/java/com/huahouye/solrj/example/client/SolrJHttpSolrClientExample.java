package com.huahouye.solrj.example.client;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;

/**
 * HttpSolrClient 的例子
 * @author xuzm
 *
 */
public class SolrJHttpSolrClientExample {
  public static void main(String[] args) throws SolrServerException, IOException {
	  String urlString = "http://192.168.191.4:8983/solr/status-center";
	  SolrClient solr = new HttpSolrClient.Builder(urlString).build();

    // http://localhost:8983/solr/spellCheckCompRH?q=epod&spellcheck=on&spellcheck.build=true
    ModifiableSolrParams params = new ModifiableSolrParams();
    params.set("qt", "/select");
    params.set("q", "id:2");

    QueryResponse response = solr.query(params);
    System.out.println("response = " + response);
  }
}