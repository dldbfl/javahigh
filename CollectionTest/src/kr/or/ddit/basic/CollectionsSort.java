package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSort {

	public static void main(String[] args) {
		List<String> temp =new ArrayList<>();
		temp.add("가나다라");
		temp.add("동해물과");
		temp.add("나랏말싸미");
		temp.add("abc초콜렛");
		
		sortlogic(temp);
	}

	private static void sortlogic(List<String> temp) {
		System.out.println("===========================");
		for(String str : temp) {
			System.out.println(str);
		}
		//sort 오름차순~~~~~~
		
		Collections.sort(temp);
		System.out.println("===========================");
		for(String str : temp) {
			System.out.println(str);
		}
		//sort 내림차순~~~~~
		Collections.sort(temp, Collections.reverseOrder());
		System.out.println("===========================");
		for(String str : temp) {
			System.out.println(str);
		}
	}

}
