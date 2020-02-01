package dao;

import java.util.List;
import java.util.Map;

import vo.PostnumVO;


public interface PostnumDao {
	
	List<PostnumVO> getSearch(Map<String, String> map);

	
}
