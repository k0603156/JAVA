package Time;

public class Run {

	public static void main(String[] args) {
		Time t 	=new Time(18,57,34);
		System.out.println(t.toString()); 
		t.setTime(12, 24, 33);
		System.out.println(t.toString()); 
	}

}
