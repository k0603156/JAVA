package persistence;

public interface MemberDAO {

	boolean insert(MemberDTO mdto);

	MemberDTO login(MemberDTO mdto);
	
	int checkEmail(String email);
}
