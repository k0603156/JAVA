package Default;

public class Child3 extends Parent3 implements MyInterface, MyInterface2{
	
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		MyInterface2.super.method1();
	}
	public void method2() {
		System.out.println("method2 in Child3");
	}
}
