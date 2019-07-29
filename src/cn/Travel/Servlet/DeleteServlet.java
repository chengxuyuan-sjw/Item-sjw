package cn.Travel.Servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.Travel.Factory.DaoFactory;
import cn.Travel.vo.Photo;

import com.jspsmart.upload.SmartUpload;


public class DeleteServlet extends HttpServlet {
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");  
		ServletConfig config=getServletConfig();
		try {
			//第一步初始化
		SmartUpload smart=new SmartUpload();
		smart.setCharset("UTF-8");
		//第二部初始化上传环境
		smart.initialize(config, request, response);
		//第三步接收所有的上传环
		 
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
						vo.setPhoto(filename);
						vo.setNote(note);
						vo.setId(id);
						vo.setEdit(edit);
						vo.setPrice(price);
						vo.setRecom(recom);
						int i=DaoFactory.getIPhotoImpl().updata(vo);
						if(i>0){
							request.getRequestDispatcher("/table-list1.jsp").forward(request, response);
						}
					
						
		}catch(Exception e){
			
		}
		
					
		
						
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
