package service;

import dao.UserDao;
import po.User;

public class UserService {
	private UserDao userDao = new UserDao();
	//ע��
	public int Add(User user) {
		int result =userDao.add(user);
		return result;
		
	}

}
