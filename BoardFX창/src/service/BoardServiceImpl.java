package service;

import java.util.List;

import dao.BoardDao;
import dao.BoardDaoImpl;
import vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
private BoardDao boardDao;
	
private static BoardServiceImpl service;
	
	public BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	
	@Override
	public int insertBoard(BoardVO bv) {
		return boardDao.insertBoard(bv);
	}

	@Override
	public boolean getBoard(int board_no) {
		return boardDao.getBoard(board_no);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		return boardDao.getAllBoardList();
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return boardDao.updateBoard(bv);
	}

	@Override
	public int deleteBoard(int board_no) {
		return boardDao.deleteBoard(board_no);
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		return boardDao.getSearchBoard(bv);
	}

}
