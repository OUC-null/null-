package dao;

import org.junit.Test;

import po.Users;

public class UsersDaoTest {
	private UsersDao usersDao = new UsersDao();
	@Test
	public void testChg() {
		Users user= new Users();
		user.setUsername("cuipi");
		user.setPwd("123");
		user.setPhone("12343211232");
		user.setPaying("21122222121122222");
		user.setImg("22233223232");
		user.setUserid("17020031001");
	System.out.println(usersDao.chg(1, user));
	}

}
