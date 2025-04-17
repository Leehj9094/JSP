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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Type.Role;

public class PermissionFilter implements Filter{
	
	// URL : Permission Value
	private Map<String,Role> pageGradeMap = new HashMap(); 
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 
		String projectpath = filterConfig.getServletContext().getContextPath();		// 공유폴더의 프로젝트
		// admin_main에 		필요한 권한 값(3)	- ROLE_ADMIN
		// manager_main에 	필요한 권한 값(2)	- ROLE_MANAGER
		// user_main에 		필요한 권한 값(1)	- ROLE_USER
		//					권한없음(0)		- ROLE_ANONYMOUS
		
		pageGradeMap.put(projectpath+"/admin_main", Role.ROLE_ADMIN);		// 3	// 특정한 문자에 대한 값 = 열거형
		pageGradeMap.put(projectpath+"/manager_main", Role.ROLE_MANAGER);	// 2
		pageGradeMap.put(projectpath+"/user_main", Role.ROLE_USER);			// 1
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		HttpSession session = request.getSession();
		
		String myRole = (String)session.getAttribute("role");
		if(myRole==null) {
			response.sendRedirect(request.getContextPath()+"/login.do?msg=not authenticated...");
			return ;
		}
		
		//
		Role my = null;
		switch(myRole)
		{
			case "ROLE_USER":
				my = Role.ROLE_USER;
				break;
			case "ROLE_MANAGER":
				my = Role.ROLE_MANAGER;
				break;
			case "ROLE_ADMIN":
				my = Role.ROLE_ADMIN;
				break;
			default :
				break;
		}
		
		// Page Role Value 꺼내기
		String requestUri = request.getRequestURI();		// /project/admin_main...
		Role pageRole = pageGradeMap.get(requestUri);
		
		System.out.printf("URL : %s,MyRole : %d, PageRole : %d\n", requestUri, my.ordinal(), pageRole.ordinal());
		
		if(my.ordinal()<pageRole.ordinal()) {
			throw new ServletException("해당 권한으로는 접근이 불가능한 페이지입니다.");
		}
		
		System.out.println("[FILTER] Perm Filter start...");
		chain.doFilter(req, resp);
		System.out.println("[FILTER] Perm Filter end...");
	}

	

}
