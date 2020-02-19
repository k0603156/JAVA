package Out;

public class Run {
	public static void main(String[] args) {
		Out o = new Out();
		Out.Inner oi = o.new Inner();
		oi.method();
	}
}
