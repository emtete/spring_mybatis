package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		Try(Connection con = 
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
