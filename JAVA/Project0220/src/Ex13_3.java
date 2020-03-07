
public class Ex13_3 {
	static long startTime =0;
	public static void main(String[] args) {
		ThreadEX3_1 th1 = new ThreadEX3_1();
		th1.start();
	
	startTime = System.currentTimeMillis();
	
	for(int i=0; i<300;i++)
		System.out.printf("%s",new String("-"));
	
	System.out.print("time consumed:"+ (System.currentTimeMillis() - Ex13_3.startTime));
	}
}
class ThreadEX3_1 extends Thread{
	public void run() {
		for(int i=0; i<300;i++)
			System.out.printf("%s", new String("|"));
		
		System.out.print("time consumed:" +(System.currentTimeMillis() - Ex13_3.startTime));
	}
}
