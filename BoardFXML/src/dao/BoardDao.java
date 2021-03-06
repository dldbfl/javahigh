package dao;


import java.util.List;

import vo.BoardVO;


public interface BoardDao {
	
	public int insertBoard (BoardVO bv) ;
	
	public List<BoardVO> displayBoardAll();
	
	public int updateBoard(BoardVO bv);
	
	public int deleteBoard(int board_no);
	
	public List<BoardVO> searchBoard(BoardVO bv);
	
	public boolean getBoard(int board_no);
	}


