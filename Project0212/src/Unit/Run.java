package Unit;


public class Run {

	public static void main(String[] args) {	
		Tank tank = new Tank();
		tank.move(1, 2);
		
		Marine marine= new Marine();
		marine.move(10, 2);
		
		tank.showLocation();
		marine.showLocation();
		
	}

}
