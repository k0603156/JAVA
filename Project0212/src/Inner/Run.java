package Inner;

import Inner.InnerEx1.*;

//public class Run {
//
//	public static void main(String []args) {
//		Child3 c = new Child3();
//		c.method1();
//		c.method2();
//		MyInterface2.staticMethod();
//		MyInterface.staticMethod();
//	}
//}

public class Run {
	public static void main(String []args) {
		InnerEx1 ie1 = new InnerEx1();
		InstanceInner e = ie1.new InstanceInner();
		
		System.out.println(InstanceInner.CONST);
		System.out.println(e.iv);
		
		System.out.println(InnerEx1.StaticInner.CONST);
		System.out.println(new InnerEx1.StaticInner().iv);

//		 new InnerEx1().myMethod();
		System.out.println();
	}
}