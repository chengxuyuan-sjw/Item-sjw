package cn.Travel.Factory;

import java.sql.Connection;



import cn.Travel.IUserImpl.ICosumerLoginImpl;
import cn.Travel.IUserImpl.IPhotoImpl;
import cn.Travel.IUserImpl.IUserImpl;
import cn.Travel.IUserImpl.IconsumerImpl;
import cn.Travle.IUser.IConsumer;
import cn.Travle.IUser.IConsumerlogin;
import cn.Travle.IUser.IPhoto;
import cn.Travle.IUser.IUser;

public class DaoFactory {
       public static IUser getIuserImpl(){
    	   return new IUserImpl();
       }
       
       public static IPhoto getIPhotoImpl(){
    	   return new IPhotoImpl();
       }
       
      public static IConsumerlogin getICosumerLogin(){
    	  return new ICosumerLoginImpl();
      }
     
      public static IConsumer getIConsumerImpl(){
    	  return new IconsumerImpl();
      }
}