package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import po.Stuff;

import util.DBUtil;

public class StuffDao {
	//增，发布新的二叔物品信息
	public int add(Stuff stuff) {
		//创建连接
		Connection conn = DBUtil.getConn();
		//SQL语句
		String sql = "insert into stuff(id, stuffid, "
				+ "stuffimg, info, price, stuffname) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		//创建PreparedStatement
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setInt(1, stuff.getId());
			pstmt.setInt(2, stuff.getStuffid());
			pstmt.setString(3, stuff.getStuffimg());
			pstmt.setString(4, stuff.getInfo());
			pstmt.setInt(5, stuff.getPrice());
			pstmt.setString(6, stuff.getStuffname());
		
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
	//删
	
	
}
