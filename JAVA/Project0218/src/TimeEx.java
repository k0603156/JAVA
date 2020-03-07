import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class TimeEx {

	public static void main(String[] args) {
			LocalTime time = LocalTime.now();
			System.out.println(time);
	
			int min = time.get(ChronoField.MINUTE_OF_DAY);
			System.out.println(min);
			
			int hour = time.get(ChronoField.HOUR_OF_DAY);
			System.out.println(hour);
	}

}
