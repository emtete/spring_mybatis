package org.victor.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DiSampleTest {
	
	@Autowired
	private DiParent parent;
	
	@Test
	public void DiTest() {
		assertNotNull(parent);
		
		log.info(parent);
		log.info("---------------------");
		log.info(parent.getChild());
	}

}
