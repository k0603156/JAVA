
public class Run {

	public static void main(String[] args) {
		Car c= new Car();
		
		c.color="black";
		c.gear="auto";
		c.door=3;
		System.out.println(c.color+ c.gear+c.door);
		
		Product p1= new Product();
		Product p2= new Product();
		Product p3= new Product();
		
		System.out.println(p1.serialNumber+"\n"+p2.serialNumber);
	}

}
