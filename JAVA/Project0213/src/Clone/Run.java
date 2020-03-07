package Clone;

public class Run {

	public static void main(String[] args) {
		Point p1 = new Point(3,4);
		Circle c1 = new Circle(p1,3);
		Circle c2 = (Circle)c1.clone();
	
//		Point p2 = (Point) p1.clone();
		
		System.out.println(p1.toString());
//		System.out.println(p2.toString());
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		p1.x=4;
		p1.y=15;
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}

}
