import java.util.Arrays;
import java.util.Comparator;

public class Ex11_7 {

	public static void main(String[] args) {
		String[] strArr = {"cat","Dog","lion","tiger"};
		
		Arrays.sort(strArr);
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());
		System.out.println("strArr="+Arrays.toString(strArr));
	}

}

class Descending implements Comparator<Object>{
	public int compare(Object oL, Object oR) {
		
		if(oL instanceof Comparable && oR instanceof Comparable) {
			return ((Comparable)oL).compareTo((Comparable)oR) * -1;
		}
		return -1;
		
	}
}