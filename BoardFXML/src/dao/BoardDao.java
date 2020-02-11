package dao;


import java.util.List;
import java.util.Map;

import vo.BoardVO;


public interface BoardDao {
	
	public int insertContent (BoardVO bv) ;
	
	public List<BoardVO> displayBoardAll();
	
	public int updateBoard(Map<String, String> bmap) ;
	
	public int deleteBoard(String memId);
	
	public List<BoardVO> searchBoard(BoardVO bv);
	}


