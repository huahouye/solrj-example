package com.huahouye.solrj.example.client.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huahouye.solrj.example.client.ClientConfig;
import com.huahouye.solrj.example.client.SolrJCloudSolrClientExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ClientConfig.class)
public class SolrJCloudSolrClientExampleTest {
	@Autowired
	SolrJCloudSolrClientExample solrJCloudSolrClientExample;
	
	@Test
	public void executeTest(){
		try {
			solrJCloudSolrClientExample.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
