package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.User;
import util.DBUtil;

public class UserDao {
	
	//用户登录
	//根据学号、姓名、密码登录 若在user表中无相关信息则需注册
	public int add(User user) {
		//创建连接
		Connection conn = DBUtil.getConn();
		//SQL语句
		String sql = "insert into user(stuid, pwd, "
				+ "name, phone, payimg, img, id) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		//创建PreparedStatement
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setInt(1, user.getStuid());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setInt(4, user.getPhone());
			pstmt.setString(5, user.getPayimg());
			pstmt.setString(6, user.getImg());
			pstmt.setInt(7, user.getId());
			
			//发送SQL语句
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}
	

}
	 
	


