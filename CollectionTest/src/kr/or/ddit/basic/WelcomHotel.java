package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class WelcomHotel {
	private Scanner scan;
	private Map<String, Customer> room;
	private List<String> list; 
	public WelcomHotel() {
		scan = new Scanner(System.in);
		room =new HashMap<>();
		list =new ArrayList<>();
	}
	public static void main(String[] args) {
		
		new WelcomHotel().hotelStart();
	}
	
	public void hotelMenu() {
		System.out.println("\t\t\t__________________________________________________________________");
		System.out.print("\t\t\t| 1. 체크인\t | ");
		System.out.print("2. 체크아웃\t | ");
		System.out.print("3. 객실 상태\t | ");
		System.out.print("4. 업무 종료\t | ");
		System.out.println();
	}
	
	public void roomEmpty() {
		int roomsNum=100;
		for(int i =0; i<30; i++) {
			roomsNum += 1;
			String strRoom = String.valueOf(roomsNum);
			room.put(strRoom, new Customer("...", "미등록", "미등록", "공실", "미등록" ));
		}
	}
	public void  hotelStart() {
		System.out.println();
		System.out.println("\t\t\t호텔에 오신걸 환영합니다.");
		roomEmpty();
		System.out.println();
		while(true) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t 호텔 메인 화면");
			hotelMenu();
			int menu =Integer.parseInt(scan.nextLine());
			
			switch(menu) {
			
			case 1 : checkIn();
				break;
			case 2 : checkOut();
				break;
			case 3 : roomList();
				break;
			case 4 :
				System.out.println("프로그램을 종료합니다...");
				return;
			default :
				System.out.println(" 잘못 입력했습니다. 다시입력해주세요");
			}
		
		}
	}

	private void roomList() {
		int cnt=0;
		Set<String> keys =room.keySet();
		Iterator<String> it =keys.iterator();
		
		while(it.hasNext()) {
			String key =  (String) it.next();
//			System.out.println(key+ "호 => "+room.get(key).getStatue());
			list.add(key);
		}
		System.out.print("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒현재 입실상황▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		Collections.sort(list);
		for(String li : list) {
			if(cnt%5==0) {
				System.out.println();
			}
			System.out.print(li +"호  => "+room.get(li).getStatue()+"\t" + room.get(li).getName()+"\t");
			cnt++;
		}
		list.clear();
		System.out.println();
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		
	}

	private void checkOut() {
		int yesNo;
		
		boolean in_out = true;
		while(in_out) {
			System.out.println();
			System.out.println("체크아웃 하실 객실 번호를 입력해주세요.");
			System.out.print("객실번호 >> ");
			String roomNumber = scan.nextLine();
			
			System.out.println();
			System.out.print("이름 >> ");
			String name = scan.nextLine();
			
			if(room.get(roomNumber).getStatue().equals("공실")) {
				System.out.println(roomNumber + "객실은 현재 공실 상태입니다.");
				break;
			}else if(room.get(roomNumber).getRoomNumber().equals(roomNumber)
				  && room.get(roomNumber).getName().equals(name)){
				room.put(roomNumber, new Customer("...", "미등록", "미등록", "공실", "미등록" ));
				System.out.println("체크아웃이 완료 되었습니다.");
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}else if(room.get(roomNumber).getRoomNumber().equals(roomNumber)
				  != room.get(roomNumber).getName().equals(name)) {
				System.out.println("객실과 고객이름이 불일치합니다.");
				System.out.println("체크아웃을 계속하시겠습니까?");
				System.out.println(" 1.네\r 2.아니요");
				while(in_out) {
				yesNo =Integer.parseInt(scan.nextLine());
					if(yesNo == 1) {
						in_out=false;
						
					}else if (yesNo ==2) {
						return;
					}else {
						System.out.println("다시입력해주세요.");
						in_out=true;
					}
				}
					
			}
		}
	}

	private void checkIn() {
		int yesNo;
		boolean in_out =true;
		String roomNumber;
		String statue;
		
		while(in_out) {
			System.out.println();
			System.out.print("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒현재 입실상황▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			roomList();
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t\t101호~130호사이의 객실번호를 입력해주세요");
			 roomNumber =scan.nextLine();
			
			 if(!room.get(roomNumber).getStatue().equals("공실")) {
				 System.out.println(roomNumber + "다른손님이 사용중입니다.");
				 return;
			 }
			 System.out.println("\t\t\t\t\t"+roomNumber +"호 로 예약 해드릴까요?");
			 System.out.println("\t\t\t\t\t 1.여기로할꼐요\r\t\t\t\t\t 2.다시 고를래요\r\t\t\t\t\t 3.예약안해요");
			 yesNo = Integer.parseInt(scan.nextLine());
			 if(yesNo == 1) {
				 System.out.println("\t\t\t\t\t예약을 위해 간단한 인적사항을 받겠습니다.");
				 statue = "예약";
				 in_out=false;
					System.out.println();
					System.out.println();
					System.out.print("\t\t\t\t\t이름을 입력해주세요");
					String name = scan.nextLine();
					
					System.out.println();
					System.out.print("\t\t\t\t\t나이를 입력해주세요");
					String age = scan.nextLine();
					
					System.out.println();
					System.out.print("\t\t\t\t\t전화번호를 입력해주세요");
					String tel = scan.nextLine();
					
					room.put(roomNumber, new Customer(name, age, tel, statue, roomNumber));
					System.out.println();
					System.out.println("\t\t\t\t\t"+name + "님 예약완료 !!");
					return;
			 }else if(yesNo == 2){
				 
			 }else if(yesNo == 3) {
				 return;
			 }else {
				 System.out.println("잘못 입력하셨습니다.");
				 System.out.println();
			 }
		
		}
	}

}

class Customer {
	private String name;
	private String age;
	private String tel;
	private String statue;
	private String roomNumber;
	
	public Customer(String name, String age, String tel, String statue, String roomNumber) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.statue = statue;
		this.roomNumber = roomNumber;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	
}
