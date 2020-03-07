import java.util.Comparator;
import java.util.stream.Stream;

public class Ex14_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Student> studentStream = Stream.of(
				new Student("bruce",3,300),
				new Student("thor",1,200),
				new Student("stark",2,100),
				new Student("blackpenther",2,150),
				new Student("captain",1,200),
				new Student("spider",3,290),
				new Student("ant",3,180)
				);
		studentStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
	}

}

class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	Student(String name, int ban, int totalScore){
		this.name=name;
		this.ban=ban;
		this.totalScore=totalScore;
	}
	public String toString() {
		return String.format("[%s,%d,%d]", name,ban,totalScore);
	}
	String getName() {return name;}
	int getBan() {return ban;}
	int getTototalScore() {return totalScore;}
	
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}
