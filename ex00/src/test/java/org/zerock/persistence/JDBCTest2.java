package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest2 {
	
	
	@Test
	public void jdbcTest() {
		Connection con;
		String id = "system";
		String pw = "oracle";
		String url = "jdbc:oracle:thin:@localhost:59161:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
			log.info(con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
		
		
	}
}
