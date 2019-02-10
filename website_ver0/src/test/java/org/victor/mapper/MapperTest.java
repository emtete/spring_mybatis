package org.victor.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.victor.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {
	
	@Setter( onMethod_ = @Autowired )
	private BoardMapper boardMapper;
	
	
	public BoardVO genBoard(int ran) {
		
		BoardVO board = new BoardVO();
		board.setContent("새로운 내용"+ran);
		board.setTitle("새로운 타이틀"+ran);
		board.setWriter("새로운 작성자"+ran);
		
		return board;
	}
	
	
//	@Test
	public void getListTest() {
		
		boardMapper.getList().forEach( board -> log.info(board) );
		System.out.println("getListTest Complete");
		System.out.println("\n\n\n");
	}
	
	
//	@Test
	public void readTest() {
		
		log.info( boardMapper.read(44L) );
		System.out.println("readTest Complete");
		System.out.println("\n\n\n");
	}
	
	
//	@Test
	public void insertTest() {
		
		BoardVO board = genBoard(3);
		
		boardMapper.insert(board);
		System.out.println("insertTest() : "+board);
		System.out.println("insertTest Complete");
		System.out.println("\n\n\n");
	}
	
	
//	@Test
	public void insertSelectKeyTest() {
		
		BoardVO board = genBoard(2);
		
		boardMapper.insertSelectKey(board);
		log.info(board);
		System.out.println("insertSelectKeyTest Complete");
		System.out.println("\n\n\n");
	}
	
	
//	@Test
	public void updateTest() {
		
		BoardVO board = genBoard(2);
		board.setBno(45L);
		
		log.info( boardMapper.update(board) );
		System.out.println("updateTest Complete");
		System.out.println("\n\n\n");
	}
	
	
//	@Test
	public void deleteTest() {
		
		log.info( boardMapper.delete(46L) );
		System.out.println("deleteTest Complete");
		System.out.println("\n\n\n");
	}
	
	
	@Test
	public void totalTest() {
		
		getListTest();
		readTest();
		insertTest();
		insertSelectKeyTest();
		updateTest();
		deleteTest();
		
		System.out.println("deleteTest Complete");
		System.out.println("\n\n\n");
	}
	
	
}
