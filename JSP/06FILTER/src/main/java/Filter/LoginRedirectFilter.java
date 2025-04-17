package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Type.Role;

@WebFilter("/login.do")
public class LoginRedirectFilter implements Filter {

	private Map<String, Role> pageGradeMap = new HashMap();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String projectpath = filterConfig.getServletContext().getContextPath();

		pageGradeMap.put(projectpath + "/admin_main", Role.ROLE_ADMIN);
		pageGradeMap.put(projectpath + "/manager_main", Role.ROLE_MANAGER);
		pageGradeMap.put(projectpath + "/user_main", Role.ROLE_USER);
		pageGradeMap.put(projectpath + "/login_do", Role.ROLE_LOGIN);

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("[FILTER] Pedirect Filter start...");
		chain.doFilter(req, resp);
		
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String method = request.getMethod();
		HttpSession session = (request).getSession();

		String role = (String) session.getAttribute("role");
		if (method.contains("POST") && (role!=null)) 
		{
			System.out.println("[FILTER] 로그인된 상태 확인! role : " + role);
			switch(role)
			{
				case "ROLE_USER":
					response.sendRedirect(request.getContextPath()+"/user_main");
					return ;
					// break;
				case "ROLE_MANAGER":
					response.sendRedirect(request.getContextPath()+"/manager_main");
					return ;
					// break;
				case "ROLE_ADMIN":
					response.sendRedirect(request.getContextPath()+"/admin_main");
					return ;
					// break;
				default :
					response.sendRedirect(request.getContextPath()+"/main.do");
					return ;
					// break;
			}
		}
		
		System.out.println("[FILTER] Pedirect Filter end...");
	}
}
