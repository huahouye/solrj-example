package com.huahouye.solrj.example.spring.data.solr.repository;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.huahouye.solrj.example.spring.data.solr.model.Weshop;

public interface WeshopRepository extends SolrCrudRepository<Weshop, String> {
	
	List<Weshop> findById(String id);
	
}
