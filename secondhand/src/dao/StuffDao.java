package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import po.Stuff;

import util.DBUtil;

public class StuffDao {
	//���������µĶ�����Ʒ��Ϣ
	public int add(Stuff stuff) {
		//��������
		Connection conn = DBUtil.getConn();
		//SQL���
		String sql = "insert into stuff(id, stuffid, "
				+ "stuffimg, info, price, stuffname) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		//����PreparedStatement
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			//���ò���
			pstmt.setInt(1, stuff.getId());
			pstmt.setInt(2, stuff.getStuffid());
			pstmt.setString(3, stuff.getStuffimg());
			pstmt.setString(4, stuff.getInfo());
			pstmt.setInt(5, stuff.getPrice());
			pstmt.setString(6, stuff.getStuffname());
		
			//����SQL���
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}	
	//ɾ
	
	
}
