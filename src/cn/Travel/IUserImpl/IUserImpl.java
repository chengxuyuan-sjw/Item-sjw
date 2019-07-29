package cn.Travel.IUserImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;




import cn.Travel.vo.User;
import cn.Travle.IUser.IUser;
import cn.sheng.dbc.DataBaseConnection;

public class IUserImpl implements IUser {
	private Connection conn = new DataBaseConnection().getConnection();
	private PreparedStatement stmt;
	

	@Override
	public boolean findLogin(User vo) throws Exception {
		String sql="SELECT COUNT(*) FROM User WHERE usename=? AND password=?";
        this.stmt=this.conn.prepareStatement(sql);
        this.stmt.setString(1, vo.getUsename());
        this.stmt.setString(2,vo.getPassword());
        ResultSet rs=this.stmt.executeQuery();
        int i;
        while(rs.next()){
       	 if(rs.getInt(1)>0)
       		 return true;
       	 
        }
        return false;
	}
	
	public Integer add(User vo) {
		int i = 0;
		String sql = "insert into user(usename,password)values(?,?)";
		Connection conn = new DataBaseConnection().getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUsename());
			psmt.setString(2, vo.getPassword());
			i = psmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public Integer update(User vo)throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		String sql = "update user set  password= ? where usename = ?";
		Connection conn = new DataBaseConnection().getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPassword());
			psmt.setString(2, vo.getUsename());
			i = psmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	
	public List<User> queryAll()throws Exception {
		List<User> list = new ArrayList<User>();
		String sql = "select * from  user";
		Connection conn = new DataBaseConnection().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				User user = new User();
                user.setUsename(rs.getString("usename"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			rs.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public User queryObject(String vo) {
		// TODO Auto-generated method stub
		User user = null;
		String sql = "select * from user where usename =  ?";
		Connection conn = new DataBaseConnection().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo);
			rs = psmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			rs.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
