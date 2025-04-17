package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {         "/request/remove","/request/attr/add","/request/attr/replace","/request/attr/remove"})
public class C05ListenerTest extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[SERVLET] C05ListenerTest service");
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
		if(uri.contains("/request/remove")) {
			session.invalidate();
		} else if(uri.contains("/request/attr/add")) {
			session.setAttribute("R_KEY", "R_VAL");
		}else if(uri.contains("/request/attr/replace")) {
			session.setAttribute("R_KEY", "R_VAL2");;
		}else if(uri.contains("/request/attr/remove")) {
			session.removeAttribute("R_KEY");;
		}
	}
	
	
	
}
