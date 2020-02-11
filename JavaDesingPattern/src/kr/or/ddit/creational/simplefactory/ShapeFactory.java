package kr.or.ddit.creational.simplefactory;

public class ShapeFactory {
	
	public Shape getShape(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		
		if(shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		}
		else if(shapeType.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		}else if(shapeType.equalsIgnoreCase("Square")) {
			return new Square();
		}
		return null;
		
		
		//객체 만드는거 여기안에서 작업함으로써 숨기기
		
	}
}
