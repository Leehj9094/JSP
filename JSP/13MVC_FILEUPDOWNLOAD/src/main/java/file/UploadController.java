package file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.FileServiceImpl;

public class UploadController implements SubController {

	private FileServiceImpl fileService;
	
	public UploadController() throws Exception{
		fileService = FileServiceImpl.getInstance();
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			// GET
			if(req.getMethod().equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/file/upload.jsp").forward(req, resp);
				return;
			}
			
			// parameter
			
			
			// isValid
			
			
			// service
			boolean isUpload = fileService.upload(req, resp);
			
			// view
			if(isUpload)
				resp.sendRedirect(req.getContextPath() + "/file/upload");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
