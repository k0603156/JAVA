import java.util.stream.Stream;
import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student2{
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	Student2(String name, boolean isMale, int hak, int ban, int score){
		this.name	=name;
		this.isMale	=isMale;
		this.hak	=hak;
		this.ban	=ban;
		this.score	=score;
	}
	String 	getName() 	{	return name;	}
	boolean	isMale()	{	return isMale;	}
	int		getHak()	{	return hak;		}
	int		getBan()	{	return ban;		}
	int		getScore()	{	return score;	}
	
	public String toString() {
		return String.format("[%s, %s, %d grade %d class, %3d point]", name, isMale ? "male":"female",hak, ban, score);
	}
	
	enum Level	{HIGH, MID, LOW}
}

public class Ex14_10 {

	public static void main(String[] args) {
		Student2[]	stuArr	= {
				new Student2("PersonA",true,1,1,300),
				new Student2("PersonB",false,1,1,250),
				new Student2("PersonC",true,1,2,200),
				new Student2("PersonD",true,1,3,150),
				new Student2("PersonE",true,1,2,100),
				new Student2("PersonF",false,1,1, 50),
				new Student2("PersonG",true,1,3,100),
				new Student2("PersonH",false,1,1,150)
		};
		
		System.out.printf("1. by Sex%n");
		
		Map<Boolean, List<Student2>> stuBySex	=	Stream.of(stuArr).collect(partitioningBy(Student2::isMale));
		
		List<Student2>	maleStudent				=	stuBySex.get(true);
		List<Student2>	femaleStudent			=	stuBySex.get(false);
		
		for(Student2 s: maleStudent)	System.out.println(s);
		for(Student2 s: femaleStudent)	System.out.println(s);
		
		System.out.printf("%n2.%n");
		
		Map<Boolean, Long> stuNumBySex			=	Stream.of(stuArr).collect(partitioningBy(Student2::isMale, counting()));
		
		System.out.println(stuNumBySex.get(true));
		System.out.println(stuNumBySex.get(false));
		
		
		System.out.printf("%n3.%n");
		
		Map<Boolean, Optional<Student2>> topScoreBySex	=	Stream.of(stuArr).collect(partitioningBy(Student2::isMale, maxBy(comparingInt(Student2::getScore))));
		
		System.out.println(topScoreBySex.get(true));
		System.out.println(topScoreBySex.get(false));
		
		Map<Boolean, Student2> topScoreBySex2			=	Stream.of(stuArr).collect(partitioningBy(Student2::isMale, collectingAndThen(maxBy(comparingInt(Student2::getScore)),Optional::get)));
		
		System.out.println(topScoreBySex2.get(true));
		System.out.println(topScoreBySex2.get(false));
		
		System.out.printf("%n4.%n");
		
		Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex	=	Stream.of(stuArr).collect(partitioningBy(Student2::isMale, partitioningBy(s->s.getScore() <= 100)));
		
		List<Student2> failedMaleStu	=	failedStuBySex.get(true).get(true);
		List<Student2> failedFemaleStu	=	failedStuBySex.get(false).get(true);
		
		for(Student2 s: failedMaleStu) 		System.out.println(s);
		for(Student2 s: failedFemaleStu) 	System.out.println(s);
	}

}
