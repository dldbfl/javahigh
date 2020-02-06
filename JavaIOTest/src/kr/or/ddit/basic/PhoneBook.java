package kr.or.ddit.basic;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 

public class PhoneBook {
	private Scanner scan;
	private Map<String, phone> phoneBookMap;
	
	public PhoneBook() {
		scan = new Scanner(System.in);
		phoneBookMap = new HashMap<>();
	}
	
	// 메뉴를 출력하는 메서드
	public void displayMenu(){
		System.out.println();
		System.out.println("메뉴를 선택하세요.");
		System.out.println(" 1. 전화번호 등록");
		System.out.println(" 2. 전화번호 수정");
		System.out.println(" 3. 전화번호 삭제");
		System.out.println(" 4. 전화번호 검색");
		System.out.println(" 5. 전화번호 전체 출력");
		System.out.println(" 6. 저장");
		System.out.println(" 7. 불러오기");
		System.out.println(" 0. 프로그램 종료");
		System.out.print(" 번호입력 >> ");		
	}
	
	// 프로그램을 시작하는 메서드
	public void phoneBookStart(){
		System.out.println("===============================================");
		System.out.println("===============================================");
		
		while(true){
			
			displayMenu();  // 메뉴 출력
			
			int menuNum = scan.nextInt();   // 메뉴 번호 입력
			
			switch(menuNum){
				case 1 : insert();		// 등록
					break;
				case 2 : update();		// 수정
					break;
				case 3 : delete();		// 삭제
					break;
				case 4 : search();		// 검색
					break;
				case 5 : displayAll();	// 전체 출력
					break;
				case 6 : save();	// 전체 저장
					break;
				case 7 : load();	// 불러오기
					break;
				case 0 :
					System.out.println("프로그램을 종료합니다...");
					return;
				default :
					System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch문
		} // while문
	}
	
	private void load() {
		Set<String> keySet = phoneBookMap.keySet();
		
		try {
			ObjectInputStream ois = new ObjectInputStream
										(new BufferedInputStream
												(new FileInputStream("E:/D_Other/phone/phone.txt")));
			
			Object obj = null;
			
			phoneBookMap.clear();
			
			try {
				while((obj = ois.readObject()) != null) {
					//읽어온 테이터를 원래의 객체형으로 변환후 사용한다.
					phone ph = (phone)obj;
					System.out.println("이름 : " + ph.getName());
					System.out.println("번호 : " + ph.getTel());
					System.out.println("주소 : " + ph.getAddr());
					
					phoneBookMap.put(ph.getName(), ph);
				}
				
				ois.close();
				
			} catch (ClassNotFoundException e) {
				
			} catch (EOFException e) {
				
			}
				
		}catch (IOException e) {
			e.printStackTrace();
			//더이상 읽어올 객체가 없으면 예외 발생
			System.out.println("출력작업 끝");
			}
		}		
		
		

	private void save() {
		Set<String> keySet = phoneBookMap.keySet();
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream
										(new BufferedOutputStream
											(new FileOutputStream("E:/D_Other/phone/phone.txt")));
			
			
				Iterator<String> it = keySet.iterator();
				while(it.hasNext()) {

					String name = it.next(); //키값을 얻는다.
					phone p = phoneBookMap.get(name);
					System.out.println(p.toString());
					oos.writeObject(p);
				
			}
			oos.close();

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	//이름을 이용한 전화번호 정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요");
		System.out.println("이름 >> ");
		String name = scan.next();
		
		phone p = phoneBookMap.get(name);
		if(p == null) {
			System.out.println(name + "씨 전화번호 정보가 없습니다.");
		}else {
			System.out.println(name + "씨의 전화번호 정보");
			System.out.println("이름 : " + p.getName());
			System.out.println("전화번호 : " + p.getTel());
			System.out.println("주소 : " + p.getAddr());
		}
		System.out.println("검색작업 완료");
	}

	
	//전화번호 정보를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.println("이름 >> ");
		String name = scan.next();
		//remove(key) =>삭제 성공하면 삭제된 value값을 반환하고 실패하면 null을 반환한다.
		if(phoneBookMap.remove(name) == null) {
			System.out.println(name + "씨는 등록된 사람이 아닙니다.");
		}else {
			System.out.println(name + "씨 정보를 삭제했습니다.");
		}
		System.out.println("삭제 작업 완료");
	}

	/*
	 	전화번호 정보를 수정하는 메서드
	*/
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요");
		System.out.println("이름 >> ");
		String name = scan.next();
		
		//수정할 자료가 있는지 검사
		if(phoneBookMap.get(name) == null) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}
		
		System.out.println("전화번호 >>");
		String tel = scan.next();
		
		System.out.println("주소 >> ");
		scan.nextLine(); //버퍼에 남아있을지 모를 엔터키값 제거
		
		String addr = scan.nextLine();
		
		phone p = new phone(name, tel, addr);
		 //같은 key값에 데이터를 저장하면 value값이 변경된다.
		phoneBookMap.put(name, p);
		System.out.println(name + "씨 정보 수정 완료");
	}

	/*
	 	전체 자료를 출력하는 메서드
	 */
	private void displayAll() {
		Set<String> keySet = phoneBookMap.keySet();
		System.out.println("============================================");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("============================================");
		
		if(keySet.size() == 0) {
			System.out.println("등록된 전화번호 정보가 존재하지 않습니다.");
		}else {
			Iterator<String> it = keySet.iterator();
			int cnt = 0;
			while(it.hasNext()) {
				cnt++;
				String name = it.next(); //키값을 얻는다.
				phone p = phoneBookMap.get(name);
				
				System.out.println(" " + cnt + "\t"
									+ p.getName() + "\t"
									+ p.getTel() + "\t"
									+ p.getAddr());
			}
		}
		System.out.println("====================================");
		System.out.println("출력 완료");
	}

	/*
	 	새로운 전화번호 정보를 등록하는 메서드
	 	이미 등록된 사람은 등록되지 않는다.
	 */
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
		System.out.println("이름 => ");
		String name = scan.next();
		
		//이미 등록된 사람이니 검사
		//get()메서드로 값을 가져올때 가져올 자료가 없으면 null을 반환한다.
		if(phoneBookMap.get(name) != null) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return; //메서드 종료
		}
		
		System.out.println("전화번호 >> ");
		String tel = scan.next();
		
		System.out.println("주 소 >> ");
		//입력버퍼에 남아있는 엔터키까지 읽어봐버리는 역활을 수행
		 // next() 호출 후 nextLine()호출시 혹시 남아있을지 모를 쓰레기 값을 위해 한번만 호출한다
		scan.nextLine(); 
		
		String addr = scan.nextLine();
		
		phoneBookMap.put(name, new phone(name, tel, addr));
		System.out.println(name + "씨 등록 완료");
		return;
	}

	public static void main(String[] args) {
		new PhoneBook().phoneBookStart();
	}

}

/*
 	전화번호 정보를 저장할 수 있는 VO클래스
 */

class phone implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6125390201992101113L;
	
	private String name; //이름
	private String tel; //번호
	private String Addr; //주소
	
	public phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		Addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	
	@Override
	public String toString() {
		return "phone [name=" + name 
				+ ", tel=" + tel 
				+ ", Addr=" + Addr + "]";
	}

}

