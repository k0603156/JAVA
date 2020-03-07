package Ex10;

import java.lang.reflect.Array;
import java.util.Calendar;

public class Run {

	public static void main(String[] args) {
		
	if(args.length !=2) {
		System.out.println("usage:java filename 2020 02");
		return;
	}
	int year = Integer.parseInt(args[0]);
	int month = Integer.parseInt(args[1]);
	int START_DAY_OF_WEEK =0;
	int END_DAY =0;
	 Calendar sDay = Calendar.getInstance();
	 Calendar eDay = Calendar.getInstance();
	 
	 
	 sDay.set(year, month -1 ,1);
	 eDay.set(year,month,1);
	 eDay.add(Calendar.DATE,-1);
	 
	 START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
	 
	 END_DAY = eDay.get(Calendar.DATE);
			 System.out.println(" "+args[0]+"Y"+args[1]+"M");
			 System.out.println("S M T W T F S");
			
}
	}