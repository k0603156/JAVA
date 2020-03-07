
public class Run {

	public static void main(String[] args) {
//		Tv tv0 = new Tv();
//		Tv tv1 = new Tv();
//		
//		tv0.channel=3;
//		System.out.println(tv0.channel);
//		
//		tv1.channel=1;
//		tv0 = tv1;
//		System.out.println(tv0.channel);
//		
//		Card c0 = new Card();
//		c0.kind= "Heart";
//		c0.number= 7;
//		
//		Card c1 = new Card();
//		c1.kind= "Spade";
//		c1.number= 4;
//		
//		System.out.println(c0.kind+c0.number+","+c1.kind+c1.number);
//		System.out.println(c0.height+c0.width+","+(c1.height+c1.width));
		
//		long result = new MyMath().add(1L,2L);
//		System.out.println(result);
		
		long result = factorial(4);
		System.out.println(result);

	}
	static long factorial(int n) {
		return n==1? 1 : n* factorial(n-1);
	}

}
