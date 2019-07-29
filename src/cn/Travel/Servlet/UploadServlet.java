package cn.Travel.Servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import cn.Travel.Factory.DaoFactory;
import cn.Travel.vo.Photo;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


public class UploadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");  
		ServletConfig config=getServletConfig();
		try {
			
		SmartUpload smart=new SmartUpload();
		smart.setCharset("UTF-8");
		
		smart.initialize(config, request, response);
		
		 
				       smart.upload();
					   String filename=UUID.randomUUID()+"."+smart.getFiles().getFile(0).getFileExt();
					   String filepath=getServletContext().getRealPath("/Upload/")+filename;
					   smart.getFiles().getFile(0).saveAs(filepath);
					   String note=smart.getRequest().getParameter("note");
					   String edit=smart.getRequest().getParameter("editorValue");
						String id=smart.getRequest().getParameter("id");
						String price=smart.getRequest().getParameter("price");
						String recom=smart.getRequest().getParameter("recom");
					   Photo vo=new Photo();
					    vo.setId(id);
						vo.setPhoto(filename);
						vo.setNote(note);
					    vo.setPrice(price);
					    vo.setRecom(recom);
					    vo.setEdit(edit);
						int i=DaoFactory.getIPhotoImpl().insert(vo);
						if(i>0){
						request.getRequestDispatcher("/table-list1.jsp").forward(request, response);
						}
						

						
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
