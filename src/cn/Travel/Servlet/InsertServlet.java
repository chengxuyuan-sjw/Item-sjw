package cn.Travel.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.Travel.Factory.DaoFactory;
import cn.Travel.vo.User;

public class InsertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 User vo=new User();
		 vo.setUsename(request.getParameter("usename"));
		 vo.setPassword(request.getParameter("password"));
		 try {
			int i=DaoFactory.getIuserImpl().add(vo);
			if(i>0){
				request.getRequestDispatcher("/login.html").forward(request, response);
			}else{
				request.getRequestDispatcher("/sign-up.html").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
