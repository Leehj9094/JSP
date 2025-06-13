package file;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.FileServiceImpl;

public class DownloadController implements SubController {

private FileServiceImpl fileService;
	
	public DownloadController() throws Exception{
		fileService = FileServiceImpl.getInstance();
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			// GET
//			if(req.getMethod().equals("GET")) {
//				req.getRequestDispatcher("/WEB-INF/view/file/list.jsp").forward(req, resp);
//				return;
//			}
			
			// parameter
			
			
			// isValid
			
			
			// service
			boolean isUploaded = fileService.download(req,resp);
			
			// view
//			req.setAttribute("map", map);
//			req.getRequestDispatcher("/WEB-INF/view/file/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
