
public class Ex13_2 {

	public static void main(String[] args) {
	long startTime =	System.currentTimeMillis();
	
	for(int i= 0; i<300;i++)
		System.out.printf("%s", new String("-"));
	
	System.out.print("\n time consumed:" + (System.currentTimeMillis() - startTime));
	System.out.println();
	
	for(int i=0; i<300;i++)
		System.out.printf("%s", new String("|"));
	
	System.out.print("\n time consumed:" + (System.currentTimeMillis() - startTime));
		
	}

}
