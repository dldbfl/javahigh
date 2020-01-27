package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorPractice {

	public static void main(String[] args) {
		ArrayList<String> al =new ArrayList<String>();
			
		al.add("one");
		al.add("two");
		al.add("two");
		al.add("three");
		al.add("three");
		al.add("three");
		al.add("five");
		
		for(int i=0; i<al.size(); i++) {
			String value =al.get(i);
			System.out.println(value);
		}
		Iterator<String> ai =al.iterator();
		
		while(ai.hasNext()) {
			System.out.println(ai.next());
		}
		System.out.println("!----------------------------!");
		
		HashSet<String> hs = new HashSet<String>();
			hs.add("one");
			hs.add("two");
			hs.add("two");
			hs.add("three");
			hs.add("three");
			hs.add("five");
			Iterator<String> hi =hs.iterator();
			while(hi.hasNext()){
				System.out.println(hi.next());
			}
			
			/* HashMap은  iterator 기능이 없음.*/
		HashMap<String,Integer> a = new HashMap<String, Integer>();
		a.put("one", 1);
		a.put("two", 2);
		a.put("three", 3);
		a.put("four", 4);
		System.out.println(a.get("one"));
		System.out.println(a.get("two"));
		System.out.println(a.get("three"));

	}
}
