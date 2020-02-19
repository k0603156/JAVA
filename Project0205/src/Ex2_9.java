
public class Ex2_9 {

	public static void main(String[] args) {
		String url = "www.codechobo.com";
		float f1 =.10f;
		float f2=1e1f;
		float f3=3.14e3f;
		double d = 1.23456789;
		System.out.printf("f1=%f, %e, %g%n", f1,f1,f1);
		System.out.printf("f2=%f, %e, %g%n", f2,f2,f2);
		System.out.printf("f3=%f, %e, %g%n", f3,f3,f3);
		
		System.out.printf("d=%f%n", d);
		System.out.printf("d=%14.10f%n", d);
		System.out.printf("[12345678901234567890]%n");
		System.out.printf("[%s]%n", url);
		System.out.printf("[%20s]%n", url);
		System.out.printf("[%-20s]%n", url);
		System.out.printf("[%.8s]%n", url);

		System.out.printf("%d\n", 15);
		System.out.printf("%#o\n", 15);
		System.out.printf("%#x\n", 15);
		System.out.printf("#%X\n", 15);
		System.out.printf("%s", Integer.toBinaryString(15));
		
		float f= 123.4567890f;
		System.out.printf("%f\n",f);
		System.out.printf("%.2f\n",f);
		System.out.printf("%10.2f\n",f);
	}

}
