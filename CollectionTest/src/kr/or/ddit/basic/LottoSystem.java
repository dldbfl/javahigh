package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;

public class LottoSystem {
	int count =0;
	int money =1000;
	int bankbook =200000;
	int request=0;
	boolean logout;
	
	Scanner scan = new Scanner(System.in);
	List<Integer> users =new ArrayList<>();
	List<Integer> list =new ArrayList<>();
	List<Integer> checkNum =new ArrayList<Integer>();
	
	public static void main(String[] args) {
		LottoSystem start = new LottoSystem();
		start.gameStart();
	}
	public  void randomNum() {
		if(logout == false) {
			
			Set<Integer> stackNum = new HashSet<Integer>();
			list.clear();
			while(stackNum.size()<6) {
				stackNum.add((int)(Math.random()*45)+1);
			}
			list.addAll(stackNum);
			
			Collections.sort(list);
			System.out.println("오늘의 로또 번호 ");
			
			for(Integer li : list) {
				System.out.print (li +" ");
			}
			System.out.println();
		}
	}

	public void inputNum() {
		int n1,n2,n3,n4,n5,n6;
		if(logout == false) {
			do {
				System.out.println("중복되지 않는 정수 6개 입력");
				n1 =Integer.parseInt(scan.nextLine());
				n2 =Integer.parseInt(scan.nextLine());
				n3 =Integer.parseInt(scan.nextLine());
				n4 =Integer.parseInt(scan.nextLine());
				n5 =Integer.parseInt(scan.nextLine());
				n6 =Integer.parseInt(scan.nextLine());
				if( n1==n2|| n1==n3 || n1==n4 || n1==n5 || n1==n6
				 || n2==n3 || n2==n4 || n2==n5 || n2==n6 
				 || n3==n4 || n3==n5 || n3==n6 
				 || n4==n5 || n4==n6 
				 || n5==n6) {
					System.out.println("중복되는 숫자는 입력할 수 없습니다. 다시 입력해주세요.");
				}
			}while( n1==n2|| n1==n3 || n1==n4 || n1==n5 || n1==n6
				 || n2==n3 || n2==n4 || n2==n5 || n2==n6 
				 || n3==n4 || n3==n5 || n3==n6 
				 || n4==n5 || n4==n6 
				 || n5==n6);
			
			users.add(n1);
			users.add(n2);
			users.add(n3);
			users.add(n4);
			users.add(n5);
			users.add(n6);
		}
	}
	
	public void numCheck() {
		count=0;
		for(int i=0; i<users.size(); i++){
			for(int j=0; j<list.size(); j++){
				if(users.get(i)== list.get(j)){  // 값이 같은지 비교
					checkNum.add(users.get(i));	
						count++;
				}
			}
		}
		users.clear();
	}
	public void mybank() {
		if(logout == false) {
			int request=Integer.parseInt(scan.nextLine());
			int ttt =bankbook-request;
			if(ttt >=0) {
				bankbook=bankbook-request;
				money = request;
			}else {
				System.out.println("도박중독입니다.");
				System.out.println("집에 가서 발이나 닦고 주무세요.");
				int bye = 0;
				logout = true;
			}
			System.out.println("잔액" + ttt + "원 입니다.");
		}
	}
	public void buyLotto() {
		int lotto=0;
		int yesNo=0;
		if(logout == false) {
			System.out.println("로또를 구매 하시겠습니까?");
			System.out.println("1.네\t2.아니요");
			
			yesNo=Integer.parseInt(scan.nextLine());
			if(yesNo == 1) {
				if(this.money>=1000) {
					System.out.println("천원짜리 로또한장을 구매했습니다.");
					System.out.println("잔돈 " + (money-= 1000)+ "원 입니다.");
					
				}else if(yesNo ==2){
					System.exit(0);;
				}else {
					System.out.println("지갑에 금액이 부족합니다.");
					System.out.println("가까운 ATM기에서 돈을 인출하러갑니다.");		
					System.out.println("인출하실 금액을 입력해주세요");
					mybank();
				}
			}else {
				logout =true;
			}
		}
	}
	public void gameStart() {
		int ok = 0;
		System.out.println("로또 구매프로그램을 시작합니다.");
		System.out.println("지갑에 " +money+"원을 가지고 있습니다.");
			do {
				buyLotto();
				randomNum();
				inputNum();
				numCheck();
				
				if(logout == false) {
					if(count == 6) {
						System.out.println("축하드립니다!! 1등! 상금 200억원입니다.");
						System.out.println("1등 됬으니 해외로 튀자!!");
						ok=6;
					}else if (count == 5) {
						System.out.println("축하드립니다!! 2등! 상금 3억원입니다.");
						System.out.println("2등 됬으니 제주도 여행가자!!");
						ok=6;
					}else if(count == 4) {
						System.out.println("축하드립니다!! 3등! 상금 1만원입니다.");
					}else if(count == 3 ) {
						System.out.println("축하드립니다!! 4등! 상금 5백원");
					}else if(count ==2){
							System.out.println("아쉽지만 2개론부족해요..");
					}else if(count ==1) {
							System.out.println("1개라니....");
					}else if(count ==0){
							System.out.println("눈감고 찍어도 그거보다 1개는나오겠다.");
					}else if(logout == true) {
						ok=6;
					}
				}else {
					ok=6;
				}
			}while(ok!=6);
	}

}