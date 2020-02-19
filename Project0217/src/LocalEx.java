import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

public class LocalEx {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		
		System.out.println(today);
		System.out.println(now);
		
		LocalDate birthDay = LocalDate.of(1999, 12, 31);
		LocalDate beforeDay = LocalDate.of(1999, 12, 22);
		LocalTime birthTime = LocalTime.of(23, 56,41);
		
		System.out.println(birthDay);
		System.out.println(birthTime);
		
		Year year = Year.of(2020);

	}

}
