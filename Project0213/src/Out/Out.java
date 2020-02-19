package Out;

public class Out {

	int value =10;
	class Inner{
		int value =20;
		void method() {
			int value =25;
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Out.this.value);
		}
	}
}
