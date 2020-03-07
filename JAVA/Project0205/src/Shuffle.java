
import java.util.*;
public class Shuffle {

	public static void main(String[] args) {
//		int[] numArr = {0,1,2,3,4,4,5,6,7,8,9};
//		System.out.println(Arrays.toString(numArr));
//		for(int i=0;i<100;i++) {
//			int n= (int)(Math.random()*10);
//			int tmp  = numArr[0];
//			numArr[0] = numArr[n];
//			numArr[n] = tmp;
//			
//		}
//		System.out.println(Arrays.toString(numArr));
		String[] name = {"kim","park","yi"};
		char ch;
		ch = name[0].charAt(2);
		System.out.println(ch);
		 int i = name[1].length();
		 System.out.println(i);
		  String temp = name[1].substring(1,3);
		  System.out.println(temp);
		  
		  if(name[2].equals("yi"))
			  System.out.println("°°À½");
	}

}
