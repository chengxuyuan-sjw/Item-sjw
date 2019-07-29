package cn.Travel.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.Travel.Factory.DaoFactory;
import cn.Travel.vo.User;

@SuppressWarnings("serial")
public class UpdataServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String password1=request.getParameter("password1");//旧密码
		String password2=request.getParameter("password2");//新密码
		String usename=request.getParameter("usename");//用户名
		try {
			User user=DaoFactory.getIuserImpl().queryObject(usename);
			String pwd=user.getPassword();
			      if(pwd.equals(password1)){
				User vo=new User();
				vo.setPassword(password2);
				vo.setUsename(usename);
				int i=DaoFactory.getIuserImpl().update(vo);
				if(i>0){
					request.getRequestDispatcher("/login.html").forward(request,response);
				}else{
					request.getRequestDispatcher("/updata.html").forward(request, response);
				}
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
