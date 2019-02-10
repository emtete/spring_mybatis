package org.victor.mapper;

import java.util.List;

import org.victor.domain.BoardVO;

public interface BoardMapper {

	public List<BoardVO> getList();
	
	public BoardVO read(Long bno);
	
	public void insert(BoardVO board);

	public void insertSelectKey(BoardVO board);
	
	public int update(BoardVO board);
	
	public int delete(Long bno);
}

