package Shape;

public class Circle extends Shape{
	Point center;
	int r;
	Circle(){
		this(new Point(0,0),100);
	}
	Circle(Point center,int r){
		this.center=center;
		this.r=r;
	}
	void draw() {
		
	}
}
