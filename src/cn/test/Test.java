package cn.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import cn.Travel.Factory.DaoFactory;
import cn.Travel.vo.CosumerLogin;
import cn.Travel.vo.Photo;
import cn.Travel.vo.User;
import cn.Travel.vo.consumer;


public class Test {

	@org.junit.Test
	public void test() {
			try {
				User vo=new User();
				vo.setUsename("sjw");
				vo.setPassword("123");
				TestCase.assertTrue(DaoFactory.getIuserImpl().findLogin(vo));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	@org.junit.Test
	public void Testinsert(){
	
			User vo=new User();
			vo.setUsename("lgq");
			vo.setPassword("123");
			try {
				int i=DaoFactory.getIuserImpl().add(vo);
				System.out.println(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	@org.junit.Test
	public void Testall(){
		   List<User> list=new ArrayList<User>();
		   try {
			list=DaoFactory.getIuserImpl().queryAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Iterator<User> iter=list.iterator();
		   while(iter.hasNext()){
			   User user=iter.next();
			   System.out.println(user.getUsename());
			   System.out.println(user.getPassword());
		   }
		   
	}
	@org.junit.Test
	public void TestUpdata(){
		 User vo=new User();
		 vo.setPassword("123");
		 vo.setUsename("sjw");
		 try {
			int i=DaoFactory.getIuserImpl().update(vo);
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.junit.Test
	public void Testfind(){
		
		try {
			User user=DaoFactory.getIuserImpl().queryObject("sjw");
			System.out.println(user.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@org.junit.Test
	public void TestFind(){
		
		try {
			List<Photo> list=DaoFactory.getIPhotoImpl().find();
			Iterator<Photo> iter=list.iterator();
			while(iter.hasNext()){
				Photo photo=new Photo();
				photo=iter.next();
				System.out.println(photo.getPhoto());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.junit.Test
	public void Testupadta1(){
		 Photo photo=new Photo();
		 photo.setId("1");
		 photo.setPhoto("222");
		 photo.setNote("222");
		 int i;
		try {
			i = DaoFactory.getIPhotoImpl().updata(photo);
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.junit.Test
	public void TestLogin1(){
		try {
			CosumerLogin login=new CosumerLogin();
			login.setUsename("sjw1");
			login.setPassword("1234");
			DaoFactory.getICosumerLogin().login(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@org.junit.Test
	public void TestFind11(){
		consumer vo=new consumer();
		vo.setUsename("sjw3");
		try {
			List<consumer> list=DaoFactory.getIConsumerImpl().find(vo);
			Iterator<consumer> iter=list.iterator();
			while(iter.hasNext()){
				consumer vo1=new consumer();
				vo1=iter.next();
				System.out.println(vo1.getPhoto());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@org.junit.Test
	public void TestCount(){
		try {
			int i=DaoFactory.getIConsumerImpl().count("sjw3");
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@org.junit.Test
	public void Testlimit(){
		consumer con=new consumer();
		con.setUsename("sjw3");
		con.setLimit1(1);
		con.setLimit2(3);
		try {
			List<consumer> list=DaoFactory.getIConsumerImpl().Limit(con);
			Iterator<consumer> iter=list.iterator();
			while(iter.hasNext()){
				consumer con1=new consumer();
				con1=iter.next();
				System.out.println(con1.getUsename());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.junit.Test
	public void TestFindByid(){
		try {
			String i=DaoFactory.getIPhotoImpl().findbyid("7");
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
