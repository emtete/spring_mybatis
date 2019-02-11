package org.victor.util;

import org.springframework.stereotype.Component;
import org.victor.domain.BoardVO;

@Component
public class GenLog {

	public void log( String methodName ) {
		System.out.println("\n\n\n");
		System.out.println( methodName );
	}
	
	public void log( String methodName, Long bno ) {
		System.out.println("\n\n\n");
		System.out.println( methodName + "'s bno : " + bno );
	}
	
	public void log( String methodName, BoardVO board ) {
		System.out.println("\n\n\n");
		System.out.println( methodName + "'s BoardVO : " + board );
	}
}
