package org.victor.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {

	@Setter( onMethod_ = @Autowired )
	private DiParent parent;
	
	
//	@Test
	public void diTest() {
		
		assertNotNull(parent);
		log.info(parent);
	}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con = 
			DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:59161:xe",
				"system",
				"oracle")){
			
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}










