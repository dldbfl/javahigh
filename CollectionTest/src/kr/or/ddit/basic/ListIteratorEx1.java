package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorEx1 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
	
		ListIterator it = list.listIterator();
		
		while(it.hasNext()) {						//커서위치 앞에서부터 시작해서 마지막에 끝난다
			System.out.println(it.next());
		}
		
		System.out.println("==========================================");
		
		while(it.hasPrevious()) {					//커서위치 마지막에서부터 시작해서 앞에서 끝난다
			System.out.println(it.previous());
		}
		System.out.println("==========================================");
		
		while(it.hasNext()) {						//커서위치 앞에서부터 시작해서 마지막에 끝난다
			System.out.println(it.next());
		}
		
		System.out.println("==========================================");
		
		while(it.hasPrevious()) {					//커서위치 마지막에서부터 시작해서 앞에서 끝난다
			System.out.println(it.previous());
		}
	}
	
}
