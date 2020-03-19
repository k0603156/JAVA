package persistence;

import java.util.List;

public interface MemberDAO {

	boolean insert(MemberDTO mdto);
	
	int destory(String email);
	
	MemberDTO login(MemberDTO mdto);
	
	List<MemberDTO> getList();
	
	int checkEmail(String email);
}
