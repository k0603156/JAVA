import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ex11_1 {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>(10);
		list1.add(new Integer(5));
		list1.add(new Integer(1));
		list1.add(new Integer(9));
		list1.add(new Integer(19));
		list1.add(new Integer(30));
		Collections.sort(list1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1<o2?1:-1;
			}
		
		});
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		System.out.println(list1);
		
	}

}
