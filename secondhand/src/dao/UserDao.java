package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.User;
import util.DBUtil;

public class UserDao {
	
	//�û���¼
	//����ѧ�š������������¼ ����user�����������Ϣ����ע��
	public int add(User user) {
		//��������
		Connection conn = DBUtil.getConn();
		//SQL���
		String sql = "insert into user(stuid, pwd, "
				+ "name, phone, payimg, img, id) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		//����PreparedStatement
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			//���ò���
			pstmt.setInt(1, user.getStuid());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setInt(4, user.getPhone());
			pstmt.setString(5, user.getPayimg());
			pstmt.setString(6, user.getImg());
			pstmt.setInt(7, user.getId());
			
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
	

}
	 
	


