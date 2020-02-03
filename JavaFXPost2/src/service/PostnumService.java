package service;

import java.util.List;
import java.util.Map;

import vo.PostnumVO;

public interface PostnumService {

//	List<PostnumVO> getSearch(Map<String, String> map);
 
	List<PostnumVO> getSearchdong(String dong);
	List<PostnumVO> getSearchzipcode(String zipcode);

	
	
}
