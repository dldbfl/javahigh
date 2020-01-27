package kr.or.ddit.basic;
enum Type {
	WALKING, RUNNING, TRACKING, HIKING
}

public class Shoes {
	public String name;
	
	public int size;
	
	public Type type;
	
	public static void main(String[] args) {
		
			Shoes shoes =new Shoes();
			
			shoes.name = "나이키";
			shoes.size = 230;
			shoes.type = Type.RUNNING;
			
			System.out.println("신발 이름  = " + shoes.name);
			System.out.println("신발 사이즈 = " + shoes.size);
			System.out.println("신발 종류 = " + shoes.type);
	}
}
