package com.huahouye.solrj.example;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.lucene.analysis.cn.smart.HMMChineseTokenizer;

/**
 * Solr lucene-analyzers-smartcn 的使用例子。
 * HMMChineseTokenizer 可以单独出来给 Java 应用使用，也可以在 schema.xml 配置文件中使用。
 * @author xuzm
 *
 */
public class SolrJAnalyzersSmartcnExample {

	public static void main(String[] args) throws IOException {

		HMMChineseTokenizer chineseTokenizer = new HMMChineseTokenizer();
		Reader reader = new StringReader("Solr 自带的简体中文分析器，可以单独出来给 Java 应用使用，也可以在 schema.xml 配置文件里面使用。");
		chineseTokenizer.setReader(reader);
		chineseTokenizer.reset();

		while (chineseTokenizer.incrementToken()) {
			System.out.println(chineseTokenizer.cloneAttributes());
		}

		chineseTokenizer.end();
		chineseTokenizer.close();
	}

}
