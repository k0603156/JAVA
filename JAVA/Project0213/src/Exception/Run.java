
package Exception;

public class Run {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			System.out.println(1/0);
////			throw new Exception("err");
//		}catch(ArithmeticException e) {
//			System.out.println(e.getMessage());
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("Exit");
	}
	static void method1 () throws Exception{

			method2();
	
	
	}
	static void method2 () throws Exception {
		throw new Exception();
	}

}

