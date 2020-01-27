package kr.or.ddit.basic;

class Util3{
	public static <K, V> boolean compare(Pair3<K, V> p1, Pair3<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare =p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}

class Pair3<K, V>{
	private K key;
	private V value;
	
	public Pair3(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
}
public class GenericPrectice {
	public static void main(String[] args) {
		
		Pair3<Integer, String> p1 = new Pair3<Integer, String>(1, "홍길동");
		Pair3<Integer, String> p2 = new Pair3<Integer, String>(1, "홍길동");
		
		boolean result1 =Util3.<Integer, String>compare(p1,p2);
		
			if(result1) {
				System.out.println("논리(의미)적으로 동일한 객체임");
			}else {
				System.out.println("논리(의미)적으로 동일한 객체 아님");
				
			}
			Pair<String, String> p3 = new Pair("001", "홍길동");
			Pair<String, String> p4 = new Pair("002", "홍길동");
			
		boolean result2 =Util.compare(p3, p4);
		
		if(result2) {
			System.out.println("논리(의미)적으로 동일한 객체임");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체 아님");
			
		}
	}
}