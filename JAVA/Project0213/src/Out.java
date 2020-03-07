
public class Out {
	class InstanceInner{
		int iv =100;
	}
	static class StaticInner{
		int iv =150;
		static int cv =300;
	}
	void myMethod() {
		class LocalInner{
			int iv =350;
		}
	}
}
