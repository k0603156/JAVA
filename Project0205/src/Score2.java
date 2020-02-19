import java.util.Scanner;

public class Score2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		char grade, plus='0';
		 if(score>=90) {
			 grade='A';
			 if(score>=95){
				 plus='+';
			 }
		 }else if(score>=80 && score<=89){
			 grade='B';
			 if(score>=85){
				 plus='+';
			 }
		 }
		 else if(score>=70 && score<=79){
			 grade='C';
			 if(score>=75){
				 plus='+';
			 }
		 }
		 else if(score>=60 && score<=69){
			 grade='D';
			 if(score>=65){
				 plus='+';
			 }
		 }else {
			 grade='F';
		 }
		 System.out.printf("%d%d ¿‘¥œ¥Ÿ.", grade,plus);
	}

}
