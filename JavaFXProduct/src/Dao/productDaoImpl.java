package Dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import Dao.productDao;
import Vo.productVo;



public class productDaoImpl implements productDao{

	
	private static productDaoImpl instance;
	private SqlMapClient smc= null;
	
	private productDaoImpl() {

    	try {
    	Charset charset =Charset.forName("UTF-8");							//한글 깨짐 방지
		Resources.setCharset(charset);										//한글 깨짐 방지
		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");	//ibatis의 설정 파일을 읽어온다(ibatis객체를 만들때 필요한 객체를설정하려고)
		smc =SqlMapClientBuilder.buildSqlMapClient(rd);		//ibatis를 쓰기위한 Client객체 생성
			rd.close();
    	} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	
	public static productDaoImpl getInstance() {
		if(instance == null) {
			instance = new productDaoImpl();
		}
		return instance;
	}

	
	@Override
	public List<productVo> COMBO1() {
		List<productVo> COMBO1 = new ArrayList<productVo>();
		
		try {
			COMBO1=smc.queryForList("productTest.selectpd");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return COMBO1;
	}



	@Override
	public List<productVo> COMBO2(String A) {
		List<productVo> COMBO2 = new ArrayList<>();
		
		try {
			COMBO2=smc.queryForList("productTest.selectpd2",A);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return COMBO2;
	}
	
	
	
	
}
