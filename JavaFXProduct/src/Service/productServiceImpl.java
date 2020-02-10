package Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import Dao.productDao;
import Dao.productDaoImpl;
import Vo.productVo;




public class productServiceImpl implements productService{
	private productDaoImpl productDao;
	private static productServiceImpl instance;
	private SqlMapClient smc= null;
	
	private productServiceImpl() {
		productDao = productDaoImpl.getInstance();
		
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
	
	public static productService getInstance() {
		if (instance == null) {
			instance = new productServiceImpl();
		}
		return instance;
	}
	
	
	
	

	@Override
	public List<productVo> COMBO1() {
		// TODO Auto-generated method stub
		return productDao.COMBO1();
	}

	@Override
	public List<productVo> COMBO2(String A) {
		// TODO Auto-generated method stub
		return productDao.COMBO2(A);
	}

}
