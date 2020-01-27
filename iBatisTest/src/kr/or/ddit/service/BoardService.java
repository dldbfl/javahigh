package kr.or.ddit.service;


import java.util.List;

import kr.or.ddit.vo.BoardVO;

public interface BoardService {

	public int insertContent (BoardVO bv) ;
	
	public List<BoardVO> displayBoardAll();
	
	public int updateBoard(BoardVO bv) ;
	
	public int deleteBoard(String memId);
	
	public List<BoardVO> searchBoard(BoardVO bv);
}
