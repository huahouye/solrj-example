package com.huahouye.solrj.example.spring.data.solr.model;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "weshop") // collection name
public class Weshop implements Serializable {

	private static final long serialVersionUID = -7800731474515071627L;

	@Id // required
	@Field("id") // solr conf managed-schema <uniqueKey>id</uniqueKey>
	private String id;
	
	@Field("area_name")
	private String areaName;

	@Field("keyWords") // copyField
	private String[] keyWords;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String[] getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String[] keyWords) {
		this.keyWords = keyWords;
	}

	@Override
	public String toString() {
		return "Weshop [id=" + id + ", areaName=" + areaName + ", keyWords=" + Arrays.toString(keyWords) + "]";
	}

}
