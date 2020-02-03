
package dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.PostnumVO;

public class PostnumDaoImpl implements PostnumDao {

	private static PostnumDaoImpl instance;
	private SqlMapClient smc;
	
	private PostnumDaoImpl(){
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println("SqlMapClient 객체 생성 실패");
			e.printStackTrace();
		}
	}
	
	public static PostnumDao getInstance() {
		if (instance == null) {
			instance = new PostnumDaoImpl();
		}
		return instance;
	}

//	@Override
//	public List<PostnumVO> getSearch(Map<String, String> map) {
//		List<PostnumVO> list = null;
//		try {
//			list = smc.queryForList("Postnum.search", map);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

	@Override
	public List<PostnumVO> getSearchdong(String dong) {
		
		List<PostnumVO> list = new ArrayList<PostnumVO>();
		try {
			list = smc.queryForList("Postnum.searchdong", dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<PostnumVO> getSearchzipcode(String zipcode) {
		
		List<PostnumVO> list = new ArrayList<PostnumVO>();
		try {
			list = smc.queryForList("Postnum.searchzipcode", zipcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	
	
	

}
