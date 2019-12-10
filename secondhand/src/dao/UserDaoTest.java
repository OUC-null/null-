package dao;

import org.junit.Test;
import po.User;;

public class UserDaoTest {
	private UserDao userDao=new UserDao();
	//
	
	@Test
	public void testAdd() {
		User user= new User();
		user.setStuid(1234);
		user.setPwd("1234");
		user.setName("Alice");
		int result = userDao.add(user);
		System.out.println(result);
		
	}

}
