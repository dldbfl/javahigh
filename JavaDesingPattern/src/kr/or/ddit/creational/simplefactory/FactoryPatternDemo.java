package kr.or.ddit.creational.simplefactory;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		
		//팩토리 객체 생성
		Shape shape1 = shapeFactory.getShape("CIRCLE");
//		Shape shape1 = new Circle();
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		shape2.draw();
		
		Shape shape3 = shapeFactory.getShape("SQUARE");
		shape3.draw();
	}
}
