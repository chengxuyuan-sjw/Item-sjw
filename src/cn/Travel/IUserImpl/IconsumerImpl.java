package cn.Travel.IUserImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







import cn.Travel.vo.consumer;
import cn.Travle.IUser.IConsumer;
import cn.sheng.dbc.DataBaseConnection;

public class IconsumerImpl implements IConsumer {

	@Override
	public List<consumer> find(Object vo) throws Exception {
		List<consumer> list = new ArrayList<consumer>();
		String sql = "select * from consumer WHERE usename=?";
		Connection conn = new DataBaseConnection().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setObject(1, vo);
			rs = psmt.executeQuery();
			while (rs.next()) {
				consumer user = new consumer();
				user.setData(rs.getString("data"));
				user.setId(rs.getString("id"));
				user.setNote(rs.getString("note"));
				user.setPrice(rs.getString("price"));
				user.setPhoto(rs.getString("photo"));
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
	public int insert(consumer vo)throws Exception{
		int i = 0;
		String sql = "insert into consumer(usename,id,note,data,price,photo)values(?,?,?,?,?,?)";
		Connection conn = new DataBaseConnection().getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUsename());
			psmt.setString(2, vo.getId());
			psmt.setString(3, vo.getNote());
			psmt.setString(4, vo.getData());
			psmt.setString(5, vo.getPrice());
			psmt.setString(6, vo.getPhoto());
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
	 
	
	public int count(Object vo)throws Exception{
		     int x=0;
			String sql = "SELECT SUM(price) FROM consumer WHERE usename=? ";
			Connection conn = new DataBaseConnection().getConnection();
			PreparedStatement psmt = null;
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setObject(1, vo);
				ResultSet rs = psmt.executeQuery();
		
				while(rs.next()){
					x=rs.getInt(1);
				}
				
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
			return x;
	 }
	
	 public List<consumer> all(consumer vo)throws Exception{
		String sql = "SELECT * FROM consumer LIMIT ? ,?";
		Connection conn = new DataBaseConnection().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<consumer> list= new ArrayList<consumer>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getLimit1());
			psmt.setInt(2, vo.getLimit2());
			rs = psmt.executeQuery();
			while (rs.next()) {
				consumer con = new consumer();
				con.setId(rs.getString("id"));
				con.setNote(rs.getString("note"));
				con.setPhoto(rs.getString("photo"));
				con.setPrice(rs.getString("price"));
				con.setUsename(rs.getString("usename"));
				con.setData(rs.getString("data"));
				list.add(con);
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
	 public List<consumer> Limit(consumer vo)throws Exception{
		 List<consumer> list = new ArrayList<consumer>();
		 String sql="SELECT * FROM consumer WHERE usename=? LIMIT ? ,? ";
		 Connection conn = new DataBaseConnection().getConnection();
			PreparedStatement psmt = null;
			ResultSet rs = null;
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(2, vo.getLimit1());
				psmt.setInt(3, vo.getLimit2());
				psmt.setString(1, vo.getUsename());
				rs = psmt.executeQuery();
				while (rs.next()) {
					consumer user = new consumer();
					user.setData(rs.getString("data"));
					user.setId(rs.getString("id"));
					user.setNote(rs.getString("note"));
					user.setPrice(rs.getString("price"));
					user.setPhoto(rs.getString("photo"));
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
}
