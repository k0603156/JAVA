package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import persistence.MemberDTO;

public interface MemberService {
	boolean regist(MemberDTO mdto);
	MemberDTO login(MemberDTO mdto);
	void execute(HttpServletRequest request, HttpServletResponse response, String action);
}
