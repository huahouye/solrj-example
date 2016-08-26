package com.huahouye.solrj.example.spring.data.solr.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huahouye.solrj.example.spring.data.solr.SpringDataSolrConfig;
import com.huahouye.solrj.example.spring.data.solr.model.Weshop;
import com.huahouye.solrj.example.spring.data.solr.repository.WeshopRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataSolrConfig.class)
public class WeshopRepositoryTest {
	@Autowired
	private WeshopRepository weshopRepository;

	@Test
	public void findByIdTest() {
		try {
			List<Weshop> weshops = weshopRepository.findById("ff808081545aa1ba01545aa1c8150256");
			assertNotNull(weshops);
			assertTrue(weshops.size() > 0);
			for (Weshop r : weshops) {
				System.out.println(r.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
