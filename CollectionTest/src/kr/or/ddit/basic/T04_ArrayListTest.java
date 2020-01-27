package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class T04_ArrayListTest {
	public static void main(String[] args) {
		// 문제1) 5명의 별명을 입력하여 ArrayList에 저장하고
		//		 별명의 길이가 제일 긴 별명을 출력하시오.
		//		(단, 각 별명의 길이는 모두 다르게 입력한다.)
		/*ArrayList<String> al =new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			System.out.println("입력하세요");
			String name = sc.nextLine();
			al.add(name);
		}
		String maxal ="";
		for(int i=0; i<al.size(); i++) {
			if(maxal.length() < al.get(i).length()) {
				maxal =al.get(i);
			}
		}
		System.out.println("제일 긴 별명 : " + maxal);
		*/
		// 문자 2) 문제 1에서 별명의 길이가 같은 것을 여러개 입력했을 때도 처리하도록 하시오
		
		ArrayList<String> al =new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			String name = sc.next();
			al.add(name);
		}
		
		int maxlen =al.get(0).length();
		for(int i=1; i<al.size(); i++) {
			if(maxlen <al.get(i).length()) {
				maxlen =al.get(i).length();
			}
		}
		
		System.out.println("제일 긴 별명들");
		for(int i=0; i<al.size(); i++) {
			if(maxlen==al.get(i).length()) {
				System.out.println(al.get(i));
			}
		}
	}
}
