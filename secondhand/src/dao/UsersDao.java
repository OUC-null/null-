package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.Stuff;
import po.Users;
import util.DBUtil;

public class UsersDao {
//修改
	public int chg(int id,Users user){
		Connection conn =DBUtil.getConn();
		String sql= "update users set "
				+ " pwd=?, username=?, phone=?, paying=?, img=?,userid=? "
				+ " where id=?";
		PreparedStatement pstmt =null;
		int result =0;
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2,user.getUsername());
			pstmt.setInt(3,user.getPhone());
			pstmt.setString(4,user.getPaying());
			pstmt.setString(5,user.getImg());
			pstmt.setInt(6,user.getUserid());
			pstmt.setInt(7,id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}		
//根据用户名查询
	public Users findByUsername(String username){
		Connection conn =DBUtil.getConn();
		String sql= "select*from users where username=?";
		PreparedStatement pstmt =null;
		ResultSet rSet=null;
		Users users =null;
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rSet=pstmt.executeQuery();
			if(rSet.next()){
				users =new Users();
				users.setId(rSet.getInt(1));
				users.setUserid(rSet.getInt(2));
				users.setUsername(rSet.getString(3));
				users.setPwd(rSet.getString(4));
				users.setPhone(rSet.getInt(5));
				users.setPaying(rSet.getString(6));
				users.setImg(rSet.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return users;
	}
//根据用户名和密码查询
	public Users findByUsernameAndPwd(String username,String pwd){
		Connection conn=DBUtil.getConn();
		String sql="select * from users where username=? and pwd=?";
		PreparedStatement pstmt = null;
		ResultSet rSet= null;
		Users users=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2,pwd);
			rSet = pstmt.executeQuery();
			if(rSet.next()){
				users = new Users();
				users.setId(rSet.getInt(1));
				users.setUserid(rSet.getInt(2));
				users.setUsername(rSet.getString(3));
				users.setPwd(rSet.getString(4));
				users.setPhone(rSet.getInt(5));
				users.setPaying(rSet.getString(6));
				users.setImg(rSet.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
		}
		return users;			 
	}
	//添加用户
	public int add(Users users){
		Connection conn = DBUtil.getConn();
		String sql = "insert into"
				+ " users(username, pwd, userid, id, paying, img, phone) "
				+ " values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getUsername());
			pstmt.setString(2, users.getPwd());
			pstmt.setInt(4,users.getId());
			pstmt.setInt(5,users.getUserid());
			pstmt.setString(6,users.getPaying());
			pstmt.setString(7,users.getImg());
			pstmt.setInt(8,users.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}
//根据商品name查询
		public Stuff findByStuffname(String stuffname){
			Connection conn =DBUtil.getConn();
			String sql= "select*from menus where stuffname=?";
				PreparedStatement pstmt =null;
				ResultSet rSet=null;
				Stuff stuff =null;
				try {
					pstmt =conn.prepareStatement(sql);
					pstmt.setString(1, stuffname);
					rSet=pstmt.executeQuery();
					if(rSet.next()){
						stuff =new Stuff();
						stuff.setId(rSet.getInt(1));
						stuff.setStuffname(rSet.getString(2));
						stuff.setStuffid(rSet.getInt(3));
						stuff.setStuffimg(rSet.getString(4));
						stuff.setPrice(rSet.getInt(5));
						stuff.setInfo(rSet.getString(6));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DBUtil.closeRst(rSet);
					DBUtil.closePstmt(pstmt);
					DBUtil.closeConn(conn);
				}
				return stuff;
		}
}
