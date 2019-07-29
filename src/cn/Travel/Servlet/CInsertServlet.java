package cn.Travel.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.Travel.Factory.DaoFactory;
import cn.Travel.vo.CosumerLogin;
import cn.Travel.vo.User;

public class CInsertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 CosumerLogin vo=new CosumerLogin();
		 vo.setUsename(request.getParameter("usename"));
		 vo.setPassword(request.getParameter("password"));
		 try {
			 int i1=DaoFactory.getICosumerLogin().add1(vo);
			int i=DaoFactory.getICosumerLogin().add(vo);
			if(i>0&&i1>0){
				request.getRequestDispatcher("/Clogin.html").forward(request, response);
			}else{
				request.getRequestDispatcher("/Csign-up.html").forward(request, response);
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
