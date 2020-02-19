package Default;

import Inner.InnerEx1;

public class Run {

	public static void main(String []args) {
		Child3 c = new Child3();
		c.method1();
		c.method2();
		MyInterface2.staticMethod();
		MyInterface.staticMethod();
	}
}


