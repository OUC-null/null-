package service;

import dao.UsersDao;
import po.Users;

public class UsersService {
	private UsersDao usersDao = new UsersDao();
	
	//注册
	public Users reg(String username , String pwd){
		return usersDao.findByUsername(username);
	}
	//登录
	public Users login(String name, String pwd){
		/*Users user = new Users();
		Users u= usersDao.findByName(user.getName());
		//判断是否已经注册
		if(u != null && u.getName() != name){
			 usersDao.findByName(name);
		}*/
		return usersDao.findByUsernameAndPwd(name, pwd);
	}
	//修改
	public int chg(int id,Users user){
		Users u= usersDao.findByUsername(user.getUsername());
		//如果能够查到，查到的ID要与修改的ID不一致，不允许修改
		if(u != null && u.getId() != id){
			return -1;
		}
		return usersDao.chg(id, user);
	}
	//添加
		public int add(Users user){
			return usersDao.add(user);
		}
}
