package service;

import dao.StuffDao;
import po.Stuff;

public class StuffService {
	private StuffDao stuffDao=new StuffDao();
	//修改
		public int chg(int stuffid , Stuff stuff){
			//根据修改后的菜品名修改
			Stuff s = stuffDao.findByStuffname(stuff.getStuffname());
			//如果能够查到，查到的ID要与修改的ID不一致，不允许修改
			if(s != null && s.getId() != stuffid){
				return -1;
			}
			return stuffDao.chg(stuffid, stuff);
		}
	public class StuffService {
	//删除已发布商品信息
	public int del(int stuffid) {
		return stuffDao.del(stuffid);
	}
}
