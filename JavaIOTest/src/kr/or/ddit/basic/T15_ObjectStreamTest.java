package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T15_ObjectStreamTest {
	public static void main(String[] args) {
		//	Member 인스턴스 생성
		Member mem1 = new Member("이누리", 20, "대전");
		Member mem2 = new Member("누리", 20, "황도");
		Member mem3 = new Member("리", 20, "백도");
		Member mem4 = new Member("바리", 20, "적도");
		
		try {
			//객체를 파일에 저장하기
			
			//출력용 스트림 객체 생성
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("e:/D_Other/memObj.bin")));
			
			//쓰기 작업
			oos.writeObject(mem1); //직렬화
			oos.writeObject(mem2); //직렬화
			oos.writeObject(mem3); //직렬화
			oos.writeObject(mem4); //직렬화
				
			System.out.println("쓰기 완료");
			oos.close();
			
			//==========================================================
			
			// 저장한 객체를 읽어와 출력하기
			
			//	입력용 스트림 객체 생성
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("e:/D_Other/memObj.bin")));
			
			Object obj = null;
			
			try {
				while((obj = ois.readObject()) != null) {
					//읽어온 데이터를 원래의 객체형으로 반환 후 사용한다.
					Member mem = (Member)obj;
					System.out.println("이름 : " + mem.getName());
					System.out.println("나이 : " + mem.getAge());
					System.out.println("주소 : " + mem.getAddr());
				}
				ois.close();
			}catch(ClassNotFoundException e) {
				
			}
		}catch(IOException e) {
				e.printStackTrace();
				// 더 이상 읽어올 객체가 없으면 예외 발생
				System.out.println("출력 끝..");
		}
	}
}

class Member implements Serializable{
	//자바는 Serializable인터페이스를 구현한 클래스만 직렬화할수있도록 제한하고 있어
	//구현안하면 직렬화하다가 java.io.NotSerializableException 예외가 발생해
	
	//transient => 직렬화가되지않을 멤버변수에 지정한다. // 일시적인
	//				 	   (* static 필드도 직렬화가 되지않는다)
	//					   직렬화가 되지 않는 멤버변수는 기본값으로 저장된다.
	//					   (참조형 변수 : null, 숫자형 변수 : 0)
	private String name;
	private transient int age;
	private String addr;
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}