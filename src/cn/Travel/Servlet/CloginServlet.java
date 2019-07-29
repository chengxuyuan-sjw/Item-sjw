   package cn.Travel.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.Travel.Factory.DaoFactory;
import cn.Travel.vo.CosumerLogin;
import cn.Travel.vo.User;



public class CloginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 try{
			 CosumerLogin vo=new CosumerLogin();
		 vo.setUsename(request.getParameter("usename"));
		 vo.setPassword(request.getParameter("password"));
		 HttpSession session=request.getSession();
	      session.setAttribute("usename", request.getParameter("usename"));
	      session.setAttribute("password", request.getParameter("password"));
	    
			boolean i=DaoFactory.getICosumerLogin().login(vo);
			if(i==true){
				request.getRequestDispatcher("/table-list-img.jsp").forward(request,
						response);
			}else{
				request.getRequestDispatcher("/404.html").forward(request, response);
			}
		 }   catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      doGet(request, response);
	}

}
