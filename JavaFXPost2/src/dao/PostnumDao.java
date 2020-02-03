package dao;

import java.util.List;

import vo.PostnumVO;


public interface PostnumDao {
	
//	List<PostnumVO> getSearch(Map<String, String> map);
	List<PostnumVO> getSearchdong(String dong);
	
	List<PostnumVO> getSearchzipcode(String zipcode);
	
	
}
