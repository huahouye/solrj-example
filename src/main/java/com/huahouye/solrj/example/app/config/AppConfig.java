package com.huahouye.solrj.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.huahouye.solrj.example.client.SolrJCloudSolrClientExample;
import com.huahouye.solrj.example.client.SolrJHttpSolrClientExampleImpl;

@Configuration
@ComponentScan(basePackages = { "com.huahouye.solr" })
@PropertySource(value = "classpath:config/com/huahouye/solr/example/configuration.properties")
public class AppConfig {
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
	public SolrJHttpSolrClientExampleImpl solrJHttpSolrClientExampleImpl() {
		return new SolrJHttpSolrClientExampleImpl();
	}
	
	@Bean
	public SolrJCloudSolrClientExample solrJCloudSolrClientExample() {
		return new SolrJCloudSolrClientExample();
	}
}
