package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {

	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q =new LinkedList();
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("= Stack =");
		while(!st.empty()) {				//empty()는 st의 객체가  비어있는지 유무 확인
			System.out.println(st.pop());	//맨위에 저장된 객체를 꺼낸다.
		}
		System.out.println("= Queue =");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		Object w =q.element();
		System.out.println(w);
	}
	

}
