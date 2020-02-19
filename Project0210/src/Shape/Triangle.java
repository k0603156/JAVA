package Shape;

public class Triangle extends Shape{
	Point[] point;
	
	Triangle(Point[] point){
		this.point	=point;
	}
	Triangle(Point point1, Point point2, Point point3){
		this.point 	=new Point[] {point1,point2,point3};
	}
	void draw() {
		
	}
}
