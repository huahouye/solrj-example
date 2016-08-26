package com.huahouye.solrj.example.spring.data.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@PropertySource(value = "classpath:config/com/huahouye/solr/example/configuration.properties")
@EnableSolrRepositories(basePackages={"com.huahouye.solrj.example.spring.data.solr.repository"}, multicoreSupport = true)
public class SpringDataSolrConfig {
	@Autowired
	Environment env;
	
	@Bean
	public SolrClient solrClient() {
		return new CloudSolrClient.Builder().withZkHost(env.getProperty("solrcloud.zk.host")).build();
	}
	
	@Bean
	public SolrTemplate solrTemplate(SolrClient solrClient) throws Exception {
		return new SolrTemplate(solrClient);
	}

}
