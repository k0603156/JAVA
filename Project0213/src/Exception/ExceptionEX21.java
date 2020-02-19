package Exception;
import java.io.*;

public class ExceptionEX21{
	public static void main(String[] argv){
		File f = createFile(argv[0]);
	}
	
	static File createFile(String filename){
		File f;
	try{
		if(filename ==null || filename.equals("")) throw new Exception("invalidation filename");

	}catch(Exception e){
		filename="unknown.txt";
	}finally{
		f = new File(filename);
		}
		createNewFile(f);
		return f;
	}
	
		static void createNewFile(File f){
			try{
				f.createNewFile();
			}catch(Exception e){}
		}
	}