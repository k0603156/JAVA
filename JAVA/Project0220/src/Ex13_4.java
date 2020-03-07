import javax.swing.JOptionPane;

public class Ex13_4 {

	public static void main(String[] args) {
		String input =JOptionPane.showInputDialog("plz input any value");
		System.out.println("value:"+input);
		
		for(int i=10; i>0;i--)
			System.out.println(i);
		try {
			Thread.sleep(1000);
		}catch(Exception e) {}
	}
}
