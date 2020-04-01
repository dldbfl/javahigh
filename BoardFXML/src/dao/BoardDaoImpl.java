package dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.BoardVO;



public class BoardDaoImpl implements BoardDao {
	private SqlMapClient smc;
	private static BoardDaoImpl bDao;
	
	private BoardDaoImpl() {

		try {
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);
		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		rd.close();
		
	   }catch(IOException e) {
		   System.out.println("SqlMapClient 객체 생성 실패!");
			e.printStackTrace();
	   }
		
	}
	
	public static BoardDaoImpl getInstance () {
		
		if(bDao == null) {
			bDao = new BoardDaoImpl();

		}
		return bDao;
  }


	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		
		try{
			Object obj = smc.insert("board.insertBoard", bv);
			
			if(obj == null) {	//성공
				cnt = 1;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		
		try {	
			cnt = smc.update("board.updateBoard", bv);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int board_no) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("board.deleteBoard", board_no);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> displayBoardAll() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			boardList = smc.queryForList("board.displayBoardAll");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = smc.queryForList("board.searchBoard", bv);
			
		}catch(SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public boolean getBoard(int board_no) {
		boolean chk = false;
		
		try {
			int cnt = (int) smc.queryForObject("board.getBoard", board_no);
			
			if(cnt > 0) {
				chk = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			chk = false;
		}
		return chk;
	}


	
	
}
