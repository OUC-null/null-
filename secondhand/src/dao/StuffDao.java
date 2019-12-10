package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.Stuff;
import util.DBUtil;

public class StuffDao {
//修改
	public int chg(int stuffid, Stuff stuff){
		Connection conn =DBUtil.getConn();
		String sql= "update menus set "
				+ " stuffname =?,id=?,price=?,img=?,info=? "
				+ " where stuffid=?";
		PreparedStatement pstmt =null;
		int result =0;
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, stuff.getStuffname());
			pstmt.setInt(2, stuff.getId());
			pstmt.setInt(3,stuff.getPrice());
			pstmt.setString(4,stuff.getStuffimg());
			pstmt.setString(5,stuff.getInfo());
			pstmt.setInt(6,stuffid);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuffid);
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
			public int del(int stuffid) {
		// 获取连接
		Connection conn = DBUtil.getConn();
		// SQL语句
		String sql = "delete from stuff where stuffid=?";
		// PreparedStatement
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, stuffid);

			// 发送SQl语句
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		// 返回
		return result;

	}
	public int add(Stuff stuff) {
		//????????
		Connection conn = DBUtil.getConn();
		//SQL???
		String sql = "insert into stuff(id, stuffid, "
				+ "stuffimg, info, price, stuffname) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		//????PreparedStatement
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			//?????
			pstmt.setInt(1, stuff.getId());
			pstmt.setInt(2, stuff.getStuffid());
			pstmt.setString(3, stuff.getStuffimg());
			pstmt.setString(4, stuff.getInfo());
			pstmt.setInt(5, stuff.getPrice());
			pstmt.setString(6, stuff.getStuffname());
		
			//???SQL???
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
