package service;

import java.util.List;
import java.util.Map;

import dao.PostnumDao;
import dao.PostnumDaoImpl;
import vo.PostnumVO;


public class PostnumServiceImpl implements PostnumService {

	private static PostnumServiceImpl instance;
	private PostnumServiceImpl() {}
	
	public static PostnumService getInstance() {
		if (instance == null) {
			instance = new PostnumServiceImpl();
		}
		return instance;
	}
	
	PostnumDao  PostnumDao = PostnumDaoImpl.getInstance();
//	@Override
//	public List<PostnumVO> getSearch(Map<String, String> map) {
//		return PostnumDao.getSearch(map);
//	}

	@Override
	public List<PostnumVO> getSearchdong(String dong) {
		
		return PostnumDao.getSearchdong(dong);
	}

	@Override
	public List<PostnumVO> getSearchzipcode(String zipcode) {
		
		return PostnumDao.getSearchzipcode(zipcode);
	}


	

}
