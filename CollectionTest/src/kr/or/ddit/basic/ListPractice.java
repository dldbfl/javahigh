package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class ListPractice {
	public static void main(String[] args) {
		List <Object> p =new ArrayList<Object>();
		List <Object> h =new ArrayList<Object>();
		
		p.add(123);
		p.add(456);
		p.add("자바");
		p.add(789);
		p.add(12345);
		
		h.add(123);
		h.add(456);
		h.add("자바");
		h.add(789);
		h.add(12345);
		
		System.out.println("\r add(Object)--p안에 Object타입으로 요소입력>> " + p);
		System.out.println("\r add(Object)--h안에 Object타입으로 요소입력>> " + h);
		System.out.println("\r get(1)--p에 특정인덱스의 요소값으로 반환한다. >> " + p.get(1));
		System.out.println("\r size()--p안에 요소의 총갯수(길이) >> " + p.size());
		System.out.println("\r contains(789)--p안에 789라는 요소가 있는지 확인  (boolean타입) >> " + p.contains(789));
		System.out.println("\r containsAll(h.get(1))-- h의 모든요소값이 p에 있는지 확인 (boolean타입) >>" + p.containsAll(h));
		p.remove("자바");
		System.out.print("\r remove(\"자바\")--자바 요소만 제거 >> ");
		System.out.println(">> p 출력 >>" + p + "\r");
		System.out.print(" remove(0)--0번째 인덱스만 제거>> " + p.remove(0));
		System.out.println(" >> p 출력 >>" + p);
		
		p.set(2, 56789);
		System.out.println("\r p.set(2,56789)--p에 2번째 인덱스를 56789로 변경한다 >> " + p);
		p.addAll(h);
		System.out.println("\r p.addAll(h)--p에 h의 전체 요소를 넣는다 >> " + p +"※ 중복값 허용");
		
		p.addAll(1, h);
		System.out.println("\r p.addAll(1,h)--p에 h의 전체 요소를 넣는다 >> " + p +"※ 중복값 허용");
		
		p.clear();
		System.out.println("\r p.clear()--p안에 있는 모든요소를 제거한다. ");
		System.out.print("\r p.isEmpty()--p안에 요소값이 있는지 확인  >> "+ p.isEmpty());
		System.out.println(" >> p 출력 >>" + p);
		h.clear();
		System.out.print("\r h.clear()--h안에 있는 모든요소를 제거한다 >> ");
		System.out.println(" h 출력 >>" + h);
		p.add(123);
		p.add(456);
		p.add(789);
		p.add(12345);
		System.out.print("\r add(Object)--p안에 Object타입으로 요소입력 >> ");
		System.out.println("p 출력 >> " + p);
		h.add(123);
		h.add(12345);
		System.out.print("\r add(Object)--p안에 Object타입으로 요소입력 >> ");
		System.out.println("h 출력 >> " + h);
		p.retainAll(h);
		System.out.print("\r p.retainAll(h)--p안에 h의 요소값이 같은 값을 제외한 나머지를 삭제한다. >> ");
		System.out.print("h 출력 >> " + h);
		System.out.println(", p 출력 >> " + p);
		
		System.out.println("\r p.equals(h)--p의요소값과 h의 요소값 같은지확인(boolean타입) >> " + p.equals(h));
		
		System.out.println("\r p.lastIndexOf(12345)--p안에 12345라는 요소값이 있으면 그해당 값의 마지막 인덱스를 반환한다. >> " + p.lastIndexOf(12345));
		
		System.out.println("\r p.toString()--p를 문자열로 반환한다. >> " + p.toString());
		System.out.println("\r p.hashCode() p의 해쉬코드를 반환한다. >> " + p.hashCode());
		p.add(66435);
		p.add(4353);
		p.add(8);
		System.out.println(p);
		System.out.println("\r p.subList(2, 5)-- 2번쨰 인덱스부터 시작해서 5번째 앞까지 잘라서 출력한다. >> " + p.subList(2, 5));		
		
		
	}
}
