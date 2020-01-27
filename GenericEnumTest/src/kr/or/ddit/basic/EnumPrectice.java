package kr.or.ddit.basic;

public class EnumPrectice {

	public enum City {서울, 대전, 대구, 부산, 광주};

	public enum Season{
		봄("봄이다"), 여름("여름이내"), 가을("가을이구나"), 겨울("추워");
	
		private String content;
		
		Season(String input){
			content =input;
		}
		public String getContent() {
			return content;
		}
	}
	
	public static void main(String[] args) {
		
		
		City myCity1;
		City myCity2;
		
		myCity2= City.대구;
		myCity1= City.valueOf("대전");
		
		System.out.println(myCity1.name());
		System.out.println(myCity1.ordinal());
		System.out.println(myCity2.name());
		System.out.println(myCity2.ordinal());
		System.out.println(myCity1.compareTo(myCity2));
		
		Season[] enumArr =Season.values();
		for(int i =0; i<enumArr.length; i++) {
			System.out.println(enumArr[i].name()+ " "+ enumArr[i].getContent());
		}
	}

}
