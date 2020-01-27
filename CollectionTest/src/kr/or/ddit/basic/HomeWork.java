package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.management.openmbean.ArrayType;

public class HomeWork {

	public static void main(String[] args) {

		List<Object> list =new ArrayList<>();
		List<Object> list2 =new ArrayList<>();
		
		list.add(true);									//객체추가
		list.add(0, "하나둘");							//index에 값수정
		list.add("하나둘셋넷");		
		
		list2.add("한국");
		list2.add("미국");
		list.addAll(list2);								//객체전체를 추가
		System.out.println(list);
		
		list2.add("하나둘셋");							
		System.out.println(list.contains("하나둘셋넷"));	//객체비교 
		System.out.println(list.containsAll(list2));	//객체전체를 비교
		
		list.clear();									//list 객체모두삭제
		list2.clear();									//list 객체모두삭제
		
		list.add("가나다라");								
		list.add(12345);
		list.add("강");
		
		list2.add("가나다라");								
		list2.add(12345);
		list2.add("강");
		System.out.println(list);

		System.out.println(list.equals(list2)+"입니다.");	// 컬렉션비교
		list.get(0);
		System.out.println(list.get(0));				//index에서 객체 조회
		List list3 = new ArrayList<>();
		list3.add(2351);
		System.out.println(list.hashCode());			//list의 hashCode값을 반환한다.
		System.out.println(list3.hashCode());			//list3의 hashCode값을 반환한다.
		System.out.println(list.indexOf(12345));		//해당 객체가 있으면 그객체의 index호출
		
		list2.clear();
		System.out.println(list2.isEmpty());			//list2가 비어있는지 확인
		list.iterator();
		list.add(9543);
		list2.add("한국");
		list2.add("미국");
		list2.add("중국");
		list2.add("영국");
		list2.add(12345);
		System.out.println(list);
		System.out.println(list2.lastIndexOf("미국"));	//동일한 객체가 있으면 해당 index 출력
		System.out.println(list2);
		list2.removeAll(list2);							//객체를 모두 삭제
		System.out.println(list2);
		
		list.add("가나다라");
		list.add('강');
		list2.add("한국");
		list2.add("미국");
		list2.add("중국");
		list2.add("영국");
		list2.add(9543);
		System.out.println(list);
		System.out.println(list2);
		
		list.retainAll(list2);						//list에서 list2에 포함된 객체만 남기고 다지운다.			
		System.out.println("list : "+list);
		System.out.println("list2 : " +list2);
		System.out.println(list.size());			//객체 사이즈 
		
		list.set(0, 2323);							//객체수정
		System.out.println(list);					
		System.out.println(list2.remove("한국"));		//list2에 "한국" 객체가 있어서 삭제하면 ture없으면 false 
		System.out.println(list2.remove(list));		//list2에서 list와 맞는 게 있으면 삭제 ture 없으면 false
		list.add(9);
		list.add(2);
		list.add(7);
		list.add(6);
		list.add(1);
		
		System.out.println(list);
		System.out.println(list.subList(2, 5));		// 2번쨰 인덱스부터 시작해서 5번째 앞까지 잘라서 출력한다.
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {						// interator로 list안에 있는것을 읽어와서 it 저장하면
			System.out.print(it.next());			//hasNext로 읽어올 요소가 있으면 true 없으면 false를 남겨서
		}
		
	}
}
