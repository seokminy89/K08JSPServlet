package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
어노테이션을 통한 요청명 매핑. *를 통해 여러 요청명을 한번에 매핑 처리한다. 
즉, .one으로 끝나는 모든 요청명에 대해 매핑처리 하였다.
*/
@WebServlet("*.one")
public class FrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//request 내장 객체를 통해 현재 요청된 URI을 얻어온다.
		String uri = req.getRequestURI();
		System.out.println(uri);//=> /K08JSPServlet/13Servlet/login.one 와 같은 형태가 된다.
		//얻어온 URI주소에서 마지막에 있는 /(슬래시)의 index값을 찾는다.
		int lastSlash = uri.lastIndexOf("/");
		//앞에서 얻은 index를 통해 URL을 자른다. 즉 마지막에 있는 요청명만 남게 된다.
		String commandStr = uri.substring(lastSlash);
		
		//어디서 들어온 요청인지 판단한다.
		if(commandStr.equals("/regist.one"))
			registFunc(req);//회원가입을 처리할 메서드 호출
		else if(commandStr.equals("/login.one"))
			loginFunc(req);//로그인
		else if(commandStr.equals("/freeboard.one"))
			freeboardFunc(req);//자유게시판
		
		//요청명과 관련된 변수들을 request영역에 저장한다.
		req.setAttribute("uri", uri);
		req.setAttribute("commandStr", commandStr);
		//View로 포워드 한다.
		req.getRequestDispatcher("/13Servlet/FrontController.jsp").forward(req, resp);
	}
	/*
	만약 get방식의 요청이 들어올 때 처리할 doGet()메소드가 없으면 405에러가 발생한다.
	*/
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	System.out.println("post방식으로 들어오는 요청처리");
//	}
	
	
	//페이지별 처리 메서드
	
	void registFunc(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>회원가입<h4>");
	}
	void loginFunc(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>로그인<h4>");
	}
	void freeboardFunc(HttpServletRequest req) {
		req.setAttribute("resultValue", "<h4>자유게시판<h4>");
	}
}
