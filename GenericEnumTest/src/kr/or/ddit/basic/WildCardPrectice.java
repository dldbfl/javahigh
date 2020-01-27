package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class WildCardPrectice {
	public static void main(String[] args) {
		FruitBox2<Fruit2> fruitBox2 = new FruitBox2<>();
		FruitBox2<Apple2> appleBox2 = new FruitBox2<>();
		
		fruitBox2.add(new Apple2());
		fruitBox2.add(new Grape2());
		
		appleBox2.add(new Apple2());
		appleBox2.add(new Apple2());
		
		Juicer2.makeJuice(fruitBox2);
	}
}

class Juicer2{
	static void makeJuice(FruitBox2<Fruit2> box) {
		
		String fruitListStr ="";
		
		int cnt =0;
		for(Fruit2 f : box.getFruitList()) {
			if(cnt ==0) {
				fruitListStr += f;
			}else {
				fruitListStr += "," +f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + "=> 쥬스완성!");
	}
}

class Fruit2{
	private String name;

	
	
	public Fruit2(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "과일(" + name + ")";
	}
	
	
}

class Apple2 extends Fruit2{
	public Apple2() {
		super("사과");
	}
}

class Grape2 extends Fruit2{
	public Grape2() {
		super("포도");
	}
}

class FruitBox2<T>{
	
	private List<T> fruitList;
	
	public FruitBox2() {
		fruitList =new ArrayList<>();
		
	}


	public List<T> getFruitList() {
		return fruitList;
	}

	public void setFruitList(List<T> fruitList) {
		this.fruitList = fruitList;
	}
	public void add(T fruit) {
		fruitList.add(fruit);
	}
	
}

class Juice2 {
	 private String name;

	 
	public Juice2(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	 @Override
	public String toString() {
		return "쥬스[" + name +"]";
	}
}

