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

public class BoardDaoImpl implements BoardDao{
	private BoardDao boardDao;
	private SqlMapClient smc;
	/*private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;*/
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);
		Reader rd;
		try {
		rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		
		//1-2위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
		smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		rd.close();// Reader객체 닫기
		}catch(IOException e) {
			System.out.println("SqlMapClient 객체 생성 실패!");
			e.printStackTrace();
		}
	}
	
	public static BoardDaoImpl getInstance() {
		if(dao ==null) {
			dao = new BoardDaoImpl();
		}
		return dao;
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
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			boardList = smc.queryForList("board.getBoardAll");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = smc.queryForList("board.getSearchBoard", bv);
			
		}catch(SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}

}
