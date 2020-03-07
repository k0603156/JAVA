import java.text.ChoiceFormat;
import java.text.MessageFormat;

public class ChoiceFormatEx2 {

	public static void main(String[] args) {

		String pattern = "Name: {0} Tel:{1} Age:{2} Birthday:{3}";
		Object[][] arguments = {
				{"leejichan", "02-123-3453","29","01-26"},
				{"leejichan", "02-123-3453","29","01-26"},
				{"leejichan", "02-123-3453","29","01-26"}
				};
		
		String[] result= new String[3];
	
		System.out.println(result);
		}

}