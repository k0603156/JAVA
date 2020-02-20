public class Ex13_11 {

	static long startTime =0;
	public static void main(String[] args){

		Mythread1 th1 =new Mythread1();
		Mythread2 th2 = new Mythread2();
		
		th1.start();
		th2.start();
		
		startTime = System.currentTimeMillis();
		
		try {
			th1.join();
			th2.join();
		}catch(InterruptedException e) {
			
		}
		System.out.print("spend:" +(System.currentTimeMillis() - Ex13_11.startTime));
	}
}
class Mythread1 extends Thread{
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print(new String("-"));
		}
	}
}
class Mythread2 extends Thread{
	public void run() {
		for(int i=0; i<300;i++) {
			System.out.print(new String("|"));
		}
	}
}
