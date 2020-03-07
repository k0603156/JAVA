package Unit;

public abstract class Unit{
	int x, y;
	
	void move(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println( this.getClass().getName()+" is Moved "+x+","+y);
	}
	void stop() {
		System.out.println("Stopped");
	}
	void showLocation() {
		System.out.println(x+","+y);
	}
	

}
