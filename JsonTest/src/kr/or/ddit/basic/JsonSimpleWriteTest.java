package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 	JSON : Javascript Object Notation.
 	JSON는 데이터를 주고 받기 위한 기본 포맷(문법)이다.
 	
	-	JSON에서 value값으로 가능한 데이터 타입
	
		1.	String
		2. 	number
		3. object(JSON object)
		4.	array
		5.	boolean
		6.	null
 */

public class JsonSimpleWriteTest {
	public static void main(String[] args) throws IOException {
		
		// JSON 데이터 생성
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name","이누리");
		jsonObj.put("job","학생");
		jsonObj.put("age",29);
		jsonObj.put("addr","선화동");
		
		//	JSONArray 데이터 생성
		JSONArray singerList = new JSONArray();
		
		JSONObject singer = new JSONObject();
		singer.put("name", "엑");
		singer.put("gender", "female");
		singer.put("age", 40);
		singerList.add(singer);

		singer = new JSONObject();
		singer.put("name", "익");
		singer.put("gender", "male");
		singer.put("age", 10);
		singerList.add(singer);

		singer = new JSONObject();
		singer.put("name", "크");
		singer.put("gender", "male");
		singer.put("age", 50);
		singerList.add(singer);
		
		jsonObj.put("singerList", singerList);
		
		FileWriter fw = new FileWriter("E:/myJsonFile.txt");
		fw.write(jsonObj.toString());
		fw.flush();
		fw.close();
		
		System.out.println("JSON 객체 내용 출력: "+jsonObj );
		
	
	}
}
