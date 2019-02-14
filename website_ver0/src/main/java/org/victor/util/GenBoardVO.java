package org.victor.util;

import org.springframework.stereotype.Component;
import org.victor.domain.BoardVO;

@Component
public class GenBoardVO {

	public BoardVO genBoardVO( Long bno, String title, String content, String writer) {
		BoardVO board = new BoardVO();
		
		board.setBno(bno);
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		return board;
	}
}
