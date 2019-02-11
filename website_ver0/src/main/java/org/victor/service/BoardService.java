package org.victor.service;

import java.util.List;

import org.victor.domain.BoardVO;

public interface BoardService {
	
	public List<BoardVO> getList();
	
	public BoardVO get(Long bno);
	
	public void register(BoardVO board);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	

}
