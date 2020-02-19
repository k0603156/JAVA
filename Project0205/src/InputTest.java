import java.util.*;

public class InputTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("태어난 해를 입력 해 주세요");
		int num = scanner.nextInt();
		System.out.printf("%d 살입니다.",new Date().getYear()- num+1);
	}

}
