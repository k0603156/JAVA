
public class Product {
	static int count =0;
	int serialNumber;
	static{
		count =200;
	}
	{
		++count;
		serialNumber =count;
	}
	public Product(){
		
	}
}
