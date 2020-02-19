package Time;

public class Time {
	private int hour;
	private int minute;
	private int second;
	Time(int hour, int minute, int second){
		this.hour 	=hour;
		this.minute =minute;
		this.second =second;
	}
	void setTime(int hour,int minute, int second){
		this.hour 	=hour;
		this.minute =minute;
		this.second =second;
	}
	public String toString() {
		return hour+":"+minute+":"+second;
	}
}
