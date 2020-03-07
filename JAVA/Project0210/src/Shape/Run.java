package Shape;

public class Run {

	public static void main(String[] args) {
		Shape s = new Shape();
		Circle c1 = new Circle();
		Circle c2 = new Circle(new Point(100,100),50);
		Point[] p = {new Point(100,100)
					,new Point(150,150)
					,new Point(200,200)};
		
		Triangle T = new Triangle(p);
		
		System.out.println(c1.color+c1.r);
		System.out.println(c2.color+c2.r);
		s.draw();
		c1.draw();
		c2.draw();
		T.draw();
	}

}
