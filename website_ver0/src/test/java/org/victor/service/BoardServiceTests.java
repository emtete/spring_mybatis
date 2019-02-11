package org.victor.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.victor.domain.BoardVO;
import org.victor.util.GenBoardVO;
import org.victor.util.GenLog;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter( onMethod_ = @Autowired )
	private BoardService service;
	
	private GenBoardVO genBoard = new GenBoardVO();
	
//	@Test
	public void getListTest() {
		
		service.getList();
	}
	
//	@Test
	public void getTest() {
		
		service.get(6L);
	}
	
//	@Test
	public void registerTest() {
		
		BoardVO board =  genBoard.genBoardVO( 0L, "등록타이틀", "등록컨텐츠", "등록작성자");
		
		service.register(board);
	}
	
//	@Test
	public void modifyTest() {
		
		BoardVO board =  genBoard.genBoardVO(7L, "수정타이틀", "수정컨텐츠", "수정작성자");
		
		service.modify(board);
	}
	
//	@Test
	public void removeTest() {
		
		service.remove(55L);
	}
	
	@Test
	public void totalTest() {
		registerTest();
		getListTest();
		getTest();
		modifyTest();
		removeTest();
	}
}





















