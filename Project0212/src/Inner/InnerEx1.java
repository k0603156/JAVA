package Inner;

public class InnerEx1 {
	class InstanceInner{
		int iv =100;
//		static int cv =100;
		final static int CONST =4;
	}
	public static class StaticInner{
		int iv =140;
		static int cv =180;
		public final static int CONST =1;
	}
	void myMethod() {
		class LocalInner{
			int iv =200;
//			static int cv =150;
			final static int CONST =2;
		}
//		static class StaticLocalInner{
//			int iv =140;
//		}
		
		LocalInner localInner = new LocalInner();
		System.out.println(localInner.iv);
		System.out.println(StaticInner.CONST+localInner.iv);
		
	}
}

