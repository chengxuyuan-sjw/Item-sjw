package cn.Travel.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.Travel.Factory.DaoFactory;
import cn.Travel.vo.consumer;


public class ShopServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String note=request.getParameter("note");
		String price=request.getParameter("price");
		String usename=request.getParameter("usename");
		String photo=request.getParameter("photo");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();//创建一个date对象保存当前时间
		String dateStr = df.format(date);
		try {
			consumer consumer=new consumer();
			consumer.setData(dateStr);
			consumer.setId(id);
			consumer.setNote(note);
			consumer.setPrice(price);
			consumer.setUsename(usename);
			consumer.setPhoto(photo);
			int i=DaoFactory.getIConsumerImpl().insert(consumer);
			if(i>0){
				request.getRequestDispatcher("/index.jsp").forward(request, response);
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
