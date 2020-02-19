package Parent;

public class Child extends Parent {
	int x =20;
	void method() {
		System.out.println(this.x);
		System.out.println(super.x);
	}
}
