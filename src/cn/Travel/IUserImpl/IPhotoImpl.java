package cn.Travel.IUserImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;






import cn.Travel.vo.Photo;
import cn.Travle.IUser.IPhoto;
import cn.sheng.dbc.DataBaseConnection;

public class IPhotoImpl implements IPhoto {

	@Override
	public List<Photo> find() throws Exception {
		List<Photo> list = new ArrayList<Photo>();
		String sql = "select * from  Photo";
		Connection conn = new DataBaseConnection().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
			     Photo photo = new Photo();
				photo.setId(rs.getString("id"));
				photo.setPhoto(rs.getString("photo"));
				photo.setNote(rs.getString("note"));
				photo.setPrice(rs.getString("price"));
				photo.setRecom(rs.getString("recom"));
				photo.setEdit(rs.getString("edit"));
				list.add(photo);
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

	@Override
	public Integer insert(Photo vo) throws Exception {
		int i = 0;
		String sql = "insert into Photo(id,photo,note,price,recom,edit)values(?,?,?,?,?,?)";
		Connection conn = new DataBaseConnection().getConnection();//获得一个与数据库的连接,后能和数据库直接进行操作
		PreparedStatement psmt = null;//获得一个对数据库进行操作的对象
		try {
			psmt = conn.prepareStatement(sql);//把sql语句发送到数据库
			psmt.setString(1, vo.getId());//获取封装类中的值id
			psmt.setString(2, vo.getPhoto());
			psmt.setString(3, vo.getNote());
			psmt.setString(4, vo.getPrice());
			psmt.setString(5, vo.getRecom());
			psmt.setString(6, vo.getEdit());
			i = psmt.executeUpdate();//返回数据插入的条数储存到i里
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

	@Override
	public Integer delete(Photo vo) throws Exception {
		// TODO Auto-generated method stub
				int i = 0;
				String sql = "delete from photo where id = ?";
				Connection conn = new DataBaseConnection().getConnection();
				PreparedStatement psmt = null;
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getId());
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
  public Integer updata (Photo vo)throws Exception{
	// TODO Auto-generated method stub
			int i = 0;
			String sql = "update photo set photo=?, note = ? ,recom=?,edit=?,price=? where id = ?";
			Connection conn = new DataBaseConnection().getConnection();
			PreparedStatement psmt = null;
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(6, vo.getId());
				psmt.setString(1, vo.getPhoto());
				psmt.setString(2, vo.getNote());
				psmt.setString(3, vo.getRecom());
				psmt.setString(4, vo.getEdit());
				psmt.setString(5, vo.getPrice());
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
  
  public String findbyid(String id)throws Exception{
	    String p1="";
		String sql = "select * from Photo where id=? ";
		Connection conn = new DataBaseConnection().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				 p1=rs.getString("edit");	  
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
		return p1;
  }
}
