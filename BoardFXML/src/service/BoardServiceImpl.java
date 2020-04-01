package service;


import java.util.List;


import dao.BoardDaoImpl;
import vo.BoardVO;

public class BoardServiceImpl implements BoardService{

	private static BoardServiceImpl Bsi;
	private BoardDaoImpl bdo;
	private BoardServiceImpl() {
	
	bdo = BoardDaoImpl.getInstance();
		
	}
	public static BoardServiceImpl getInstance () {
		if(Bsi == null) {			
			Bsi = new BoardServiceImpl();
		}
		return Bsi;
	}


	
	@Override
	public int insertBoard(BoardVO bv) {
		return bdo.insertBoard(bv);
	}
	@Override
	public int deleteBoard(int board_no) {
		return bdo.deleteBoard(board_no);
	}
	@Override
	public List<BoardVO> displayBoardAll() {		
		return bdo.displayBoardAll();
	}
	
	@Override
	public int updateBoard(BoardVO bv) {		
		return bdo.updateBoard(bv);	}
	
	
	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {		
		return bdo.searchBoard(bv);
	}
	@Override
	public boolean getBoard(int board_no) {
		return bdo.getBoard(board_no);
	}

}
