package com.huahouye.solrj.example.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = { "com.huahouye.solrj.example.client" })
@PropertySource(value = "classpath:config/com/huahouye/solr/example/configuration.properties")
public class ClientConfig {
	/**
	 * ${…} 的 @Value 注解需要这个
	 * 
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public SolrJHttpSolrClientExample solrJHttpSolrClientExampleImpl() {
		return new SolrJHttpSolrClientExample();
	}
	
	@Bean
	public SolrJCloudSolrClientExample solrJCloudSolrClientExample() {
		return new SolrJCloudSolrClientExample();
	}
}
