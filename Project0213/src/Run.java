
public class Run {
	public static void main(String[] args) {
		Out out =new Out();
		Out.InstanceInner instanceInner = out.new InstanceInner();
		Out.StaticInner staticInner = new Out.StaticInner();
		
		System.out.println(staticInner.iv);
		System.out.println(Out.StaticInner.cv);
	}
}
