import java.time.Instant;

public class Ex3 {

	public static void main(String[] args) {
		Instant now = Instant.now();
		Instant now2 = Instant.ofEpochSecond(now.getEpochSecond());
		
		System.out.println(now);
		System.out.println(now2);
		
		long lTime = now.toEpochMilli();
		System.out.println(lTime);
	}

}
