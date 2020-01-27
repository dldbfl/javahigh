package kr.or.ddit.basic;

import java.math.BigDecimal;

public class enumEx {

	public enum Planet{
		수성(2439), 금성(6052), 지구(6371), 화성(3390),
		목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);
	
	private int round;
	
	Planet (int helf){
		round = helf; 
	}
	public int getRound() {
		return round;
	}
	}
	
	public static void main(String[] args) {
		
		
		Planet[] pl =Planet.values();
		for(int i=0; i<pl.length; i++) {
				double tt= pl[i].getRound()*pl[i].getRound()*Math.PI;
			BigDecimal t1= new BigDecimal(tt);
			System.out.println(pl[i].name()+"==>" +t1);
		}
		System.out.println();
	}
}
