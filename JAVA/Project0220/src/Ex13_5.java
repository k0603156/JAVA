import javax.swing.JOptionPane;

public class Ex13_5 {

	public static void main(String[] args) {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		
		String input =JOptionPane.showInputDialog("plz input any value");
		System.out.println("value:"+input);

	}
}

class ThreadEx5_1 extends Thread{
	public void run() {
		for(int i=10; i>0;i--) {
			System.out.println(i);
			try {
				sleep(1000);
			}catch(Exception e) {}
		}
	}
}