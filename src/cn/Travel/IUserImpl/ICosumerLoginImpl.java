package cn.Travel.IUserImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.Travel.vo.CosumerLogin;
import cn.Travel.vo.User;
import cn.Travel.vo.consumer;
import cn.Travle.IUser.IConsumerlogin;
import cn.sheng.dbc.DataBaseConnection;

public class ICosumerLoginImpl implements IConsumerlogin {
	private Connection conn = new DataBaseConnection().getConnection();
	private PreparedStatement stmt;
	
	public boolean login(CosumerLogin vo) throws Exception {
		String sql="SELECT COUNT(*) FROM consumerlogin WHERE usename=? AND password=?";
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
	public Integer add(CosumerLogin vo) {
		int i = 0;
		String sql = "insert into consumerlogin (usename,password)values(?,?)";
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
	
	public Integer add1(CosumerLogin vo) {
		int i1 = 0;
		String sql = "insert into consumer (usename)values(?)";
		Connection conn = new DataBaseConnection().getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUsename());
			i1 = psmt.executeUpdate();
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
		return i1;
	}
}
