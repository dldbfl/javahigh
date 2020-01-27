package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.stream.events.Namespace;

public class T03_ArrayListTest {

	public static void main(String[] args) {
		// 문제 ) 5명의 사람 이름을 입력하여 ArrayList에 저장하고
		//		이 중에 '김'씨 성의 이름을 출력하시오.
		//		(단, 입력은 Scanner를 이용하여 입력 받는다)
		ArrayList<String > al = new ArrayList<>();
		Scanner sc =new Scanner(System.in);
		System.out.println("입력하세요");
		for(int i = 0; i<5; i++) {
			System.out.println(i + "번째 사람 ");
			String names = sc.nextLine();
			al.add(names);
		}
		for(String name : al) {
			if(name.startsWith("김")) {
				System.out.println(name);
			}
			
//			if(name.indexOf("김") ==0) {
//				System.out.println(name);
//			}
//			if(name.charAt(0)=='김') {
//				System.out.println(name);
//			}
//			if(name.substring(0,1).equals("김")) {
//				System.out.println(name);
//			}
		}
		
	}

}
