import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		for(int i= 2; i<=score;i++) {
			for(int j=1; j<=9;j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
		}
	}

}
