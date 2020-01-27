package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortEx {
	public static void main(String[] args) {
		
		List<Student> stlist =new ArrayList<>();
		
		stlist.add(new Student("200123","홍길동",50,40,90));
		stlist.add(new Student("200121","변학도",30,90,80));
		stlist.add(new Student("200114","성춘향",20,80,90));
		stlist.add(new Student("200153","이순신",40,60,50));
		stlist.add(new Student("200126","일지매",50,40,90));
		stlist.add(new Student("200111","강감찬",20,10,50));
		
		for(int i=0; i<stlist.size(); i++) {
		   int total =stlist.get(i).getEg()
					+ stlist.get(i).getLg()
					+ stlist.get(i).getMa();
			stlist.get(i).setTotal(total);
		}
		for(int i =0; i<stlist.size(); i++) {
			stlist.get(i).setGrade(1);
		}
		for(int i = 0; i< stlist.size(); i++){										//석차
			for(int j =0; j<stlist.size(); j++){
				if(stlist.get(i).getTotal() < stlist.get(j).getTotal()){
					stlist.get(i).setGrade(stlist.get(i).getGrade()+1);
				}
			}
		}
//		Collections.sort(stlist, new SortTotal());
//		
//		for(int i=0; i<stlist.size(); i++) {
//				stlist.get(i).setGrade(i+1);
//		}
//		Collections.shuffle(stlist);
//		
//		System.out.println("=============정렬 전===============");
//		for(Student st : stlist) {
//			System.out.print(st);
//			System.out.print(","+st.getTotal());
//			System.out.println(","+st.getGrade());
//		}
		
		System.out.println("==========학번 정렬=================");
		Collections.sort(stlist);
		
		for(Student st : stlist) {
			System.out.print(st);
			System.out.print(","+st.getTotal());
			System.out.println(","+st.getGrade());
		}
		
		
		Collections.sort(stlist, new SortTotal());
//		for(int i =0; i<stlist.size(); i++) {
//			if(!stlist.get(i).getTotal().cotains())
//			
//		}
		
		System.out.println("===========총점--외부정렬============");
		
		for(Student st : stlist) {
			System.out.print(st);
			System.out.print(","+st.getTotal());
			System.out.println(","+st.getGrade());
		}
		
		
		
	}
}

class Student implements Comparable<Student>{
	private String num;
	private String name;
	private int lg;
	private int eg;
	private int ma;
	private int total;
	private int grade;
	
	public Student(String num, String name, int lg, int eg, int ma) {
		super();
		this.num = num;
		this.name = name;
		this.lg = lg;
		this.eg = eg;
		this.ma = ma;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLg() {
		return lg;
	}
	public void setLg(int lg) {
		this.lg = lg;
	}
	public int getEg() {
		return eg;
	}
	public void setEg(int eg) {
		this.eg = eg;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	@Override
	public String toString() {
		return num +","+ name +","+lg +","+eg +","+ma;
	}
	@Override
	public int compareTo(Student st ) {
			
		return getNum().compareTo(st.getNum());
	}
	
	
}

class SortTotal implements Comparator<Student>{

	@Override
	public int compare(Student st1, Student st2) {
			int score = 0;
				if(st1.getTotal() > st2.getTotal()) {
					return -1;
				}else if (st1.getTotal() == st2.getTotal()) {
					return -1;
				}else {
					return 1;
				}
	}
	
}


