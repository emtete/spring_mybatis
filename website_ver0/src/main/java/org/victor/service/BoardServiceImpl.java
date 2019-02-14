package org.victor.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.victor.domain.BoardVO;
import org.victor.mapper.BoardMapper;
import org.victor.util.GenLog;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	public GenLog log;
	
	
	@Override
	public List<BoardVO> getList() {

		log.log("getList");
		
		return mapper.getList();
	}

	@Override
	public BoardVO get(Long bno) {

		log.log("get", bno);
		
		return mapper.read(bno);
	}

	@Override
	public void register(BoardVO board) {

		log.log("register", board);
		
		mapper.insertSelectKey(board);
	}

	@Override
	public boolean modify(BoardVO board) {

		log.log("modify", board);
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {

		log.log("remove", bno);
		
		return mapper.delete(bno) == 1;
	}

}









